package br.com.pedidos.controllers;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.pedidos.model.ClientSession;
import br.com.pedidos.model.Token;
import br.com.pedidos.model.Usuario;
import br.com.pedidos.services.ClientSessionService;
import br.com.pedidos.services.UsuarioService;

@RestController
@RequestMapping(value="/auth")
public class AuthenticationController {
	
	@Autowired
	UsuarioService usuarioService;
	@Autowired
	ClientSessionService clientSessionService;
	
	
	@RequestMapping(value="/signin", method= RequestMethod.POST)
	@ResponseBody
	public Token signIn(@RequestBody Usuario usuario, HttpServletResponse response) {
		
		Usuario usuarioFound = usuarioService.buscarUsuario(usuario.getLogin());
		
		if (usuarioFound != null) {
			if (BCrypt.checkpw(usuario.getSenha(), usuarioFound.getSenha())) {
				response.setStatus(HttpServletResponse.SC_ACCEPTED);
				
				Date now = new Date();
				
				ClientSession clientSession =  clientSessionService.buscarPorUsuario(usuarioFound);
				
				if(clientSession != null) {
					if (this.isTokenValid(now, clientSession)) {
						System.out.println("vencido");
						clientSessionService.deleteClientSession(clientSession.getToken());
						return this.generateTokenAndSaveClientSession(now, usuarioFound);
					} else {
						return new Token(clientSession.getToken());
					}
					
				} else {				
					return this.generateTokenAndSaveClientSession(now, usuarioFound);
				}
				
			} 
		}
		
		response.setStatus(HttpServletResponse.SC_FORBIDDEN);
		return null;
		
	}
	
	public Token generateTokenAndSaveClientSession(Date now, Usuario usuario) {
		TimeZone tz = TimeZone.getTimeZone("America/Fortaleza");
		UUID token = UUID.randomUUID();
		ClientSession clientSession = new ClientSession();
		
		Calendar c = Calendar.getInstance();
		c.setTime(now);
		c.add(Calendar.DATE, 2);
		
		clientSession.setToken(token.toString());
		clientSession.setUsuario(usuario);
		clientSession.setVencimento(c.getTime());
		
		clientSessionService.salvarClientSession(clientSession);
		
		Token tokenT = new Token(clientSession.getToken());
		
		return tokenT;
	}
	
	public boolean isTokenValid(Date now, ClientSession clientSession) {
		return (now.compareTo(clientSession.getVencimento()) > 0);
	}
	
	@RequestMapping(value="/checkToken", method= RequestMethod.POST)
	public ResponseEntity checkToken(@RequestBody ClientSession clientSession) {
		Date now = new Date();
		
		ClientSession cs = clientSessionService.buscarClientSession(clientSession.getToken());
		
		if(cs != null) {
			if (!this.isTokenValid(now, cs)) {
				return new ResponseEntity(HttpStatus.ACCEPTED);				
			}
		} 
		return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
	}

}
