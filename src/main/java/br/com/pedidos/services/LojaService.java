package br.com.pedidos.services;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pedidos.model.Loja;
import br.com.pedidos.repository.LojaRepository;

@Service
public class LojaService {
	
	@Autowired
	LojaRepository lojaRepository;
	
	public Loja salvarLoja (Loja loja) {
		lojaRepository.save(loja);
		
		return loja;
	}
	
	public List<Loja> buscarTodas () {
		
		List<Loja> lojas = lojaRepository.findAll();
		Collections.sort(lojas);
		
		return lojas;
	}

}
