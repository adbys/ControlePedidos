package br.com.pedidos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pedidos.model.Categoria;
import br.com.pedidos.repository.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	CategoriaRepository categoriaRepository;
	
	public Categoria salvarCategoria (Categoria categoria) {
		categoriaRepository.save(categoria);
		
		return categoria;
	}
	
	public List<Categoria> buscarTodas () {
		return categoriaRepository.findAll();
	}
	
}
