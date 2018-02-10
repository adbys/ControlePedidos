package br.com.pedidos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.pedidos.model.ModeloProduto;

@Repository
public interface ModeloProdutoRepository extends JpaRepository<ModeloProduto, Long> {

	ModeloProduto findById(long id);

}
