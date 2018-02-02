package br.com.pedidos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pedidos.model.ModeloProduto;
import br.com.pedidos.repository.ModeloProdutoRepository;

@Service
public class ModeloProdutoService {
	
	@Autowired
	ModeloProdutoRepository modeloProdutoRepository;
	
	public ModeloProduto salvarModelo(ModeloProduto modeloProduto) {
		modeloProdutoRepository.save(modeloProduto);
		
		return modeloProduto;
	}
	
	public List<ModeloProduto> getTodosModelos() {
		return this.modeloProdutoRepository.findAll();
	}

}
