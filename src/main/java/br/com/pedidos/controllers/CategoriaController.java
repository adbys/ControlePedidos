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
	CategoriaService cs;
	
	List<Categoria> categorias = new ArrayList<Categoria>();
	
	
	public CategoriaController () {
		
		Categoria categoria1 = new Categoria();
		categoria1.setNome("Masculino");
		
		Categoria categoria2 = new Categoria();
		categoria2.setNome("Feminino");
		
		Categoria categoria3 = new Categoria();
		categoria3.setNome("Infantil");
		
		Categoria categoria4 = new Categoria();
		categoria4.setNome("Acessório");
		
		categorias.add(categoria1);
		categorias.add(categoria2);
		categorias.add(categoria3);
		categorias.add(categoria4);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Categoria> getCategorias () {
		
		return categorias;
		
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Categoria saveCategoria (@RequestBody Categoria categoria) {
		System.out.println(categoria.getNome());
		
		categorias.add(categoria);
		
		return categoria;
	}
	
	
}
