package br.com.pedidos.services;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pedidos.model.FormaDePagamento;
import br.com.pedidos.repository.FormaDePagamentoRepository;

@Service
public class FormaDePagamentoService {

	@Autowired
	FormaDePagamentoRepository formaDePagamentoRepository;
	
	public FormaDePagamento salvarFormaDePagamento (FormaDePagamento formaDePagamento) {
		String nome = "";
		List<String> parcelas = (List<String>)formaDePagamento.getParcelas();
		
		for (int i = 0; i < parcelas.size(); i++) {
			nome += parcelas.get(i);
			if (i != parcelas.size() - 1) {
				nome += "-";
			}
		}
		
		nome += "-dias";
		
		formaDePagamento.setNome(nome);
		
		this.formaDePagamentoRepository.save(formaDePagamento);
		
		return formaDePagamento;
	}
	
	public List<FormaDePagamento> buscarTodas () {
		return this.formaDePagamentoRepository.findAll();
	}
	
	
	
}
