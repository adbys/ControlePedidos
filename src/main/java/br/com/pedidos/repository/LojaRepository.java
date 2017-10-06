package br.com.pedidos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pedidos.model.Loja;

public interface LojaRepository extends JpaRepository<Loja, Long> {

}
