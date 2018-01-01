package br.com.pedidos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.pedidos.model.FormaDePagamento;
import br.com.pedidos.services.FormaDePagamentoService;

@RestController
@RequestMapping("/formaDePagamento")
public class FormaDePagamentoController {
	
	@Autowired
	FormaDePagamentoService formaDePagamentoService;

	@RequestMapping(method = RequestMethod.GET)
	public List<FormaDePagamento> getFormasDePagamento () {
		return this.formaDePagamentoService.buscarTodas();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public FormaDePagamento salvarFormaDePagamento (@RequestBody FormaDePagamento formaDePagamento) {
		this.formaDePagamentoService.salvarFormaDePagamento(formaDePagamento);
		
		return formaDePagamento;
		
	}
}
