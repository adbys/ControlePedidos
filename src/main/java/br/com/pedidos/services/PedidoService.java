package br.com.pedidos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pedidos.model.EstadoPedido;
import br.com.pedidos.model.Pedido;
import br.com.pedidos.model.Produto;
import br.com.pedidos.repository.PedidoRepository;

@Service
public class PedidoService {
	
	@Autowired
	PedidoRepository pedidoRepository;
	
	public Pedido salvarPedido (Pedido pedido) {
		
		pedido.setEstado(EstadoPedido.NAO_RECEBIDO);
		
		pedidoRepository.save(pedido);
		
		return pedido;
	}
	
	public List<Pedido> buscarTodos () {
		return this.pedidoRepository.findAll();
	}
	
	public Pedido buscarPorId (long id) {
		return this.pedidoRepository.findById(id);
	}
	
	public Pedido atualizarPedido (Pedido pedido) {
		
		boolean todosRecebidos = true;
		boolean peloMenosUmRecebido = false;
		
		for (Produto produto : pedido.getProdutos()) {
			if (produto.isRecebido() && !peloMenosUmRecebido) {
				peloMenosUmRecebido = true;
			}
			if (!produto.isRecebido()) {
				todosRecebidos = false;
			}
		}
		
		if (todosRecebidos) {
			pedido.setEstado(EstadoPedido.RECEBIDO);
		} else if (peloMenosUmRecebido) {
			pedido.setEstado(EstadoPedido.RECEBIDO_PARCIALMENTE);
		}
		
		
		this.pedidoRepository.save(pedido);
		
		return pedido;
	}

}
