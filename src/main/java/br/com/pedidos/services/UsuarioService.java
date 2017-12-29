package br.com.pedidos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pedidos.model.Usuario;
import br.com.pedidos.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;
	
	public Usuario salvarUsuario(Usuario usuario) {
		usuarioRepository.save(usuario);
		
		return usuario;
	}
	
	public Usuario buscarUsuario(String login) {		
		return usuarioRepository.findByLogin(login);
	}
}
