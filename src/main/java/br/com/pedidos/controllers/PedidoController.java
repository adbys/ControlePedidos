package br.com.pedidos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.pedidos.model.Pedido;
import br.com.pedidos.services.PedidoService;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
	
	@Autowired
	PedidoService pedidoService;
	
	@RequestMapping(method = RequestMethod.POST)
	public Long salvePedido (@RequestBody Pedido pedido) { 
		
		pedidoService.salvarPedido(pedido);
		
		return pedido.getId();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Pedido> getPedidos () {
		return this.pedidoService.buscarTodos();
	}

}
