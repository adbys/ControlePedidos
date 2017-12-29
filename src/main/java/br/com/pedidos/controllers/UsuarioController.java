package br.com.pedidos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.pedidos.model.Pedido;
import br.com.pedidos.model.Usuario;
import br.com.pedidos.services.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	UsuarioService usuarioService;
	
	@RequestMapping(method = RequestMethod.POST)
	public Long salveUsuario (@RequestBody Usuario usuario) {
		
		//TODO: criptografar senha antes de salvar usuário
		
		usuarioService.salvarUsuario(usuario);
		
		return usuario.getId();
	}
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public Usuario getUsuario (@RequestBody Usuario usuario) { 
		
		//TODO: Autenticar e gerar token
		
		Usuario usuarioFound = usuarioService.buscarUsuario(usuario.getLogin());
		
		return usuarioFound;	
		
		
	}
	
	

}
