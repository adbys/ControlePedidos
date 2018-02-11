package br.com.pedidos.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ModeloProduto getProdutosPorId (@PathVariable long id, HttpServletResponse response) {
		ModeloProduto modelo = this.modeloProdutoService.getProdutoPorId(id);
		if (modelo == null) {
			try {
				response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		} else {
			response.setStatus(HttpServletResponse.SC_ACCEPTED);
			return modelo;
		}
	}

}
