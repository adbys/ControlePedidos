package br.com.pedidos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pedidos.model.ClientSession;
import br.com.pedidos.model.Usuario;
import br.com.pedidos.repository.ClientSessionRepository;

@Service
public class ClientSessionService {
	
	@Autowired
	ClientSessionRepository clientSessionRepository;
	
	public String salvarClientSession(ClientSession clientSession) {
		clientSessionRepository.save(clientSession);
		
		return clientSession.getToken();
	}
	
	public ClientSession buscarClientSession(String token) {		
		return clientSessionRepository.findByToken(token);
	}
	
	public void deleteClientSession(String token) {
		
		ClientSession clientSession = this.clientSessionRepository.findByToken(token);
		
		clientSessionRepository.delete(clientSession);
		clientSessionRepository.flush();
	}
	
	public ClientSession buscarPorUsuario(Usuario usuario) {
		return clientSessionRepository.findByUsuario(usuario);
	}

}
