package br.com.pedidos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.pedidos.model.Loja;
import br.com.pedidos.services.LojaService;



@RestController
@RequestMapping(value = "/loja")
public class LojaController {
	
	@Autowired
	LojaService lojaService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Loja> getLojas () {
		
		return lojaService.buscarTodas();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Loja saveLoja(@RequestBody Loja loja) {
		
		lojaService.salvarLoja(loja);
		
		return loja;
	}

}
