package br.com.pedidos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pedidos.model.MesFinanceiro;

public interface MesFinanceiroRepository extends JpaRepository<MesFinanceiro, Long> {

	public MesFinanceiro findByMesAndAno(String mes, String ano);

	public MesFinanceiro findById(long id);
	
}
