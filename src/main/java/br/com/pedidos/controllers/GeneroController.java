package br.com.pedidos.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.pedidos.model.GeneroProdutos;

@RestController
@RequestMapping("/genero")
public class GeneroController {

	@RequestMapping(method = RequestMethod.GET)
	public List<GeneroProdutos> getGeneros() {
		List<GeneroProdutos> retorno = new ArrayList<GeneroProdutos>();
		retorno.add(GeneroProdutos.FEMININO_ADULTO);
		retorno.add(GeneroProdutos.MASCULINO_ADULTO);
		retorno.add(GeneroProdutos.FEMINO_INFANTIL);
		retorno.add(GeneroProdutos.MASCULINO_INFANTIL);
		
		return retorno;
		
	}
	
}
