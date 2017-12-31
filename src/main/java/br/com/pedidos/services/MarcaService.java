package br.com.pedidos.services;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pedidos.model.Marca;
import br.com.pedidos.repository.MarcaRepository;

@Service
public class MarcaService {
	
	@Autowired
	MarcaRepository marcaRepository;
	
	public Marca salvarLoja (Marca marca) {
		marcaRepository.save(marca);
		
		return marca;
	}
	
	public List<Marca> buscarTodas () {
		
		List<Marca> marcas = marcaRepository.findAll();
		Collections.sort(marcas);
		
		return marcas;
	}

}
