package br.com.pedidos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.pedidos.model.Loja;

@Repository
public interface LojaRepository extends JpaRepository<Loja, Long> {

}
