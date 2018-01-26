package br.com.pedidos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pedidos.model.ClientSession;

public interface ClientSessionRepository extends JpaRepository<ClientSession, String> {
	
	public ClientSession findByToken(String token);

}
