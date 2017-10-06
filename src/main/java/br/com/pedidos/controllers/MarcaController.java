package br.com.pedidos.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.pedidos.model.Marca;
import br.com.pedidos.services.MarcaService;





@RestController
@RequestMapping(value="/marca")
public class MarcaController {
	
private List<Marca> marcas = new ArrayList<Marca>();

	@Autowired
	MarcaService marcaService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Marca> getMarcas () {
		
		return marcaService.buscarTodas();
		
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Marca saveMarca (@RequestBody Marca marca) {
		
		marcaService.salvarLoja(marca);
		
		return marca;
		
	}

}
