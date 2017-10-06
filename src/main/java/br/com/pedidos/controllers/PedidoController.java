package br.com.pedidos.controllers;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.pedidos.model.Pedido;

@RestController
@RequestMapping("/pedido")
public class PedidoController {
	
	@RequestMapping(method = RequestMethod.POST)
	public Pedido salvarPedido (@RequestBody Pedido pedido) {
		
		System.out.println(pedido);
		
		return pedido;
	}

}
