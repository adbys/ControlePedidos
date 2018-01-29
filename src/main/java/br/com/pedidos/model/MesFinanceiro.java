package br.com.pedidos.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class MesFinanceiro implements Comparable {
	
	@Id
	@GeneratedValue
	private Long id;
	private String mes;
	private String ano;
	@ManyToMany
	private List<Pedido> pedidos;
	
	public MesFinanceiro(String mes, String ano) {
		this.mes = mes;
		this.ano = ano;
		pedidos = new ArrayList<Pedido>();
	}
	
	public MesFinanceiro() {
		
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMes() {
		return mes;
	}
	public void setMes(String mes) {
		this.mes = mes;
	}
	public String getAno() {
		return ano;
	}
	public void setAno(String ano) {
		this.ano = ano;
	}
	
	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
	
	public List<Pedido> getPedidos() {
		return this.pedidos;
	}
	
	public void adicionarPedido (Pedido pedido) {
		this.pedidos.add(pedido);
	}
	
	public double getValorTotal() {
		
		double valorTotal = 0;
		
		for (Pedido pedido : pedidos) {
			valorTotal += (pedido.getValorTotal() / pedido.getFormaDePagamento().getParcelas().size());
		}
		
		return valorTotal;
	}
	
	public double getValorTotalComDesconto() {
		
		double valorTotal = 0;
		
		for (Pedido pedido : pedidos) {
			valorTotal += ((pedido.getValorTotal() - pedido.getValorTotal() * (pedido.getDesconto() / 100)) / pedido.getFormaDePagamento().getParcelas().size());
		}
		
		return valorTotal;
	}
	
	public List<ValorPorLoja> getValorTotalPorLoja() {
		HashMap<Loja, ValorPorLoja> valorTotalPorLoja = new HashMap<Loja, ValorPorLoja>();
		
		for(Pedido pedido : this.pedidos) {
			Double valorLoja = (pedido.getValorTotal() / pedido.getFormaDePagamento().getParcelas().size());
			Double valorLojaComDesconto = pedido.getValorTotalComDesconto();
			 if (valorTotalPorLoja.get(pedido.getLoja()) == null) {
				 ValorPorLoja valorPorLoja = new ValorPorLoja(pedido.getLoja().getNome(), valorLoja, valorLojaComDesconto);
				 valorTotalPorLoja.put(pedido.getLoja(), valorPorLoja);
			 } else {
				 ValorPorLoja valorPorLoja = valorTotalPorLoja.get(pedido.getLoja());
				 Double valorAcumulado = valorLoja + valorPorLoja.getValor();
				 Double valorComDesconto =  pedido.getValorTotalComDesconto();
				 
				 valorPorLoja.setValor(valorAcumulado);
				 valorPorLoja.setValorComDesconto(valorComDesconto);
				 
				 valorTotalPorLoja.put(pedido.getLoja(), valorPorLoja);
			 }
		}
		
		List<ValorPorLoja> retorno = new ArrayList<ValorPorLoja>();
		
		for(Loja chave : valorTotalPorLoja.keySet()) {
			retorno.add(valorTotalPorLoja.get(chave));
			
		}
		
		return retorno;
	}
	
	@Override
	public int compareTo(Object o) {
		MesFinanceiro outroMes = (MesFinanceiro) o;
		
		Locale ptBR = new Locale("pt", "BR");
		
		String mesAtual = this.getMes().toUpperCase() + "-" + this.getAno();
		String mesComparado = outroMes.getMes() + "-" + outroMes.getAno();
		
		Date dateMesAtual = new Date();
		Date dateMesComparado = new Date();
		
		try {
			dateMesAtual = new SimpleDateFormat("MMM-yyyy", ptBR).parse(mesAtual);
			dateMesComparado = new SimpleDateFormat("MMM-yyyy", ptBR).parse(mesComparado);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		//Ordenando em ordem crescente;
		return dateMesAtual.compareTo(dateMesComparado);
				
	}
	
	

}
