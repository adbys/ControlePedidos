package br.com.pedidos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pedidos.model.Pedido;
import br.com.pedidos.model.Produto;
import br.com.pedidos.repository.PedidoRepository;

@Service
public class PedidoService {
	
	@Autowired
	PedidoRepository pedidoRepository;
	
	public Pedido salvarPedido (Pedido pedido) {
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
		
		boolean recebido = true;
		
		for (Produto produto : pedido.getProdutos()) {
			if (!produto.isRecebido()) {
				recebido = false;
				break;
			}
		}
		
		pedido.setRecebido(recebido);
		
		this.pedidoRepository.save(pedido);
		
		return pedido;
	}

}
