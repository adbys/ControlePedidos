package br.com.pedidos.controllers;

import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.pedidos.model.ClientSession;
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
	public UUID signIn(@RequestBody Usuario usuario, HttpServletResponse response) {
		
		Usuario usuarioFound = usuarioService.buscarUsuario(usuario.getLogin());
		
		if (usuarioFound == null) {
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
			return null;
		}
		
		if (BCrypt.checkpw(usuario.getSenha(), usuarioFound.getSenha())) {
			UUID token = UUID.randomUUID();
			response.setStatus(HttpServletResponse.SC_ACCEPTED);
			Date data = new Date();
			ClientSession clientSession = new ClientSession();
			
			clientSession.setToken(token.toString());
			clientSession.setUsuario(usuarioFound);
			clientSession.setVencimento(data);
			
			clientSessionService.salvarClientSession(clientSession);
			
			return token;
		} else {
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
			return null;
		}
		
	}
	
	@RequestMapping(value="/checkToken", method= RequestMethod.POST)
	public ResponseEntity checkToken(@RequestBody ClientSession clientSession) {
		System.out.println(clientSession.getToken());
		ClientSession cs = clientSessionService.buscarClientSession(clientSession.getToken());
		System.out.println(cs == null);
		if(cs != null) {
			return new ResponseEntity(HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
		}
	}

}
