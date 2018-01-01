package br.com.pedidos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pedidos.model.FormaDePagamento;

public interface FormaDePagamentoRepository extends JpaRepository<FormaDePagamento, Long> {

}
