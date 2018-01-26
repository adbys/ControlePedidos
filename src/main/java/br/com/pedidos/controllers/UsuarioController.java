package br.com.pedidos.controllers;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.pedidos.model.Usuario;
import br.com.pedidos.services.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	UsuarioService usuarioService;
	
	@RequestMapping(method = RequestMethod.POST)
	public String salveUsuario (@RequestBody Usuario usuario) {
		
		String senha = usuario.getSenha();
		String senhaCriptografada = BCrypt.hashpw(senha, BCrypt.gensalt());
		
		usuario.setSenha(senhaCriptografada);
		
		usuarioService.salvarUsuario(usuario);
		
		return usuario.getLogin();
	}

}
