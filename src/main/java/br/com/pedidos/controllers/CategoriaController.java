package br.com.pedidos.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.pedidos.model.Categoria;
import br.com.pedidos.services.CategoriaService;

@RestController
@RequestMapping(value="/categoria")
public class CategoriaController {
	
	@Autowired
	CategoriaService categoriaService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Categoria> getCategorias () {

		return categoriaService.buscarTodas();
		
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Categoria saveCategoria (@RequestBody Categoria categoria) {
		
		categoriaService.salvarCategoria(categoria);
		
		return categoria;
	}
	
	
}
