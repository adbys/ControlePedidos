package controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import model.Categoria;

@RestController
@RequestMapping(value="/categoria")
public class CategoriaController {
	
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
		
		categorias.add(categoria);
		
		return categoria;
	}

}
