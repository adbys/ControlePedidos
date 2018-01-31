package br.com.pedidos.services;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pedidos.model.Mes;
import br.com.pedidos.model.Pedido;
import br.com.pedidos.repository.MesFinanceiroRepository;

@Service
public class MesFinanceiroService {
	
	@Autowired
	MesFinanceiroRepository mesFinanceiroRepository;
	
	public Mes salvarMes (Mes mes) {
		mesFinanceiroRepository.save(mes);
		
		return mes;
	}
	
	public List<Mes> buscarTodas () {
		
		List<Mes> meses = mesFinanceiroRepository.findAll();
		Collections.sort(meses);
		
		return meses;
	}
	
	public Mes buscarMesEAno (String mes, String ano) {
		return mesFinanceiroRepository.findByMesAndAno(mes, ano);
	}

	public Mes buscarPorId(long id) {
		return mesFinanceiroRepository.findById(id);
	}
	
	
	

}
