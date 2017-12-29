package br.com.pedidos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pedidos.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

	public Pedido findById(long id);
	
}
