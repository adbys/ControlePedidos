package br.com.pedidos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.pedidos.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {

	//@Query(value="SELECT usuario FROM Usuario usr where usr.login = :login")
	public Usuario findByLogin(String login);
	
}
