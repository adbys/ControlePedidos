package br.com.pedidos.services;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pedidos.model.MesFinanceiro;
import br.com.pedidos.repository.MesFinanceiroRepository;

@Service
public class MesFinanceiroService {
	
	@Autowired
	MesFinanceiroRepository mesFinanceiroRepository;
	
	public MesFinanceiro salvarMes (MesFinanceiro mes) {
		mesFinanceiroRepository.save(mes);
		
		return mes;
	}
	
	public List<MesFinanceiro> buscarTodas () {
		
		List<MesFinanceiro> meses = mesFinanceiroRepository.findAll();
		Collections.sort(meses);
		
		return meses;
	}
	
	public MesFinanceiro buscarMesEAno (String mes, String ano) {
		return mesFinanceiroRepository.findByMesAndAno(mes, ano);
	}
	
	
	

}
