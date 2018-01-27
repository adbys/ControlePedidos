package br.com.pedidos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.pedidos.model.MesFinanceiro;
import br.com.pedidos.services.MesFinanceiroService;

@RestController
@RequestMapping(value="/financeiro")
public class FinanceiroController {
	
	@Autowired
	MesFinanceiroService financeiroService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<MesFinanceiro> getMeses () {
		
		return financeiroService.buscarTodas();
		
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public MesFinanceiro getPedidosPorId (@PathVariable long id) {
		return this.financeiroService.buscarPorId(id);
	}

}
