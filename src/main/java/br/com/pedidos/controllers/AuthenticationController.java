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
import br.com.pedidos.services.AuthService;
import br.com.pedidos.services.ClientSessionService;
import br.com.pedidos.services.UsuarioService;

@RestController
@RequestMapping(value="/auth")
public class AuthenticationController {
	
	@Autowired
	AuthService authService;
	
	
	
	@RequestMapping(value="/signin", method= RequestMethod.POST)
	@ResponseBody
	public Token signIn(@RequestBody Usuario usuario, HttpServletResponse response) {
		
		Token token = authService.authenticateUserAndGenerateToken(usuario);
		
		if(token != null) {
			response.setStatus(HttpServletResponse.SC_ACCEPTED);
			return token;
		} else {
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
			return null;
		}
		
		
	}
	

	

}
