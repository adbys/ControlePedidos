package br.com.pedidos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.pedidos.model.Mes;
import br.com.pedidos.services.MesFinanceiroService;

@RestController
@RequestMapping(value="/detalhes")
public class FinanceiroController {
	
	@Autowired
	MesFinanceiroService financeiroService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Mes> getMeses () {
		
		return financeiroService.buscarTodas();
		
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public Mes getMesPorId (@PathVariable long id) {
		return this.financeiroService.buscarPorId(id);
	}

}
