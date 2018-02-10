package br.com.pedidos.services;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pedidos.model.ClientSession;
import br.com.pedidos.model.Token;
import br.com.pedidos.model.Usuario;

@Service
public class AuthService {
	
	@Autowired
	ClientSessionService clientSessionService;
	@Autowired
	UsuarioService usuarioService;
	
	public Token authenticateUserAndGenerateToken(Usuario usuario) {
		
		Usuario usuarioFound = usuarioService.buscarUsuario(usuario.getLogin());
		
		if (usuarioFound != null) {
			if (BCrypt.checkpw(usuario.getSenha(), usuarioFound.getSenha())) {
				
				Date now = new Date();
				
				ClientSession clientSession =  clientSessionService.buscarPorUsuario(usuarioFound);
				
				if(clientSession != null) {
					if (this.isTokenValid(now, clientSession)) {
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
		
		return null;
		
	}
	
	private Token generateTokenAndSaveClientSession(Date now, Usuario usuario) {
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
	
	private boolean isTokenValid(Date now, ClientSession clientSession) {
		return (now.compareTo(clientSession.getVencimento()) > 0);
	}

	public int checkToken(String token) {
		ClientSession clientSession = clientSessionService.buscarClientSession(token);
		if (clientSession == null) {
			return HttpServletResponse.SC_BAD_REQUEST;
		} else {
			Date now = new Date();
			if (now.compareTo(clientSession.getVencimento()) > 0) {
				System.out.println("vencido");
				clientSessionService.deleteClientSession(token);
				return HttpServletResponse.SC_BAD_REQUEST;
			} else {
				return HttpServletResponse.SC_ACCEPTED;
			}
			
		}
	}

}
