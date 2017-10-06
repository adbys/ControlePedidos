package br.com.pedidos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.pedidos.model.Marca;

@Repository
public interface MarcaRepository extends JpaRepository<Marca, Long> {

}
