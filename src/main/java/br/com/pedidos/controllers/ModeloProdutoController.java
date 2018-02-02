package br.com.pedidos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.pedidos.model.ModeloProduto;
import br.com.pedidos.services.ModeloProdutoService;

@RestController
@RequestMapping(value="/modeloProduto")
public class ModeloProdutoController {
	
	@Autowired
	ModeloProdutoService modeloProdutoService;
	
	@RequestMapping(method = RequestMethod.POST)
	public ModeloProduto salvarModelo(@RequestBody ModeloProduto modelo) {
		return this.modeloProdutoService.salvarModelo(modelo);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<ModeloProduto> getModelos() {
		return this.modeloProdutoService.getTodosModelos();
	}

}
