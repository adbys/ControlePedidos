package br.com.pedidos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pedidos.model.Mes;

public interface MesFinanceiroRepository extends JpaRepository<Mes, Long> {

	public Mes findByMesAndAno(String mes, String ano);

	public Mes findById(long id);
	
}
