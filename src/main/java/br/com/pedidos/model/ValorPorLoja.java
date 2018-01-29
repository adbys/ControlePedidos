package br.com.pedidos.model;

public class ValorPorLoja {
	
	private String loja;
	private double valor;
	private double valorComDesconto;
	
	public double getValorComDesconto() {
		return valorComDesconto;
	}

	public void setValorComDesconto(double valorComDesconto) {
		this.valorComDesconto = valorComDesconto;
	}

	public ValorPorLoja(String nome, Double valor) {
		this.loja = nome;
		this.valor = valor;
	}
	
	public ValorPorLoja(String nome, Double valorLoja, Double valorLojaComDesconto) {
		this.loja = nome;
		this.valor = valor;
		this.valorComDesconto = valorLojaComDesconto;
	}

	public String getLoja() {
		return loja;
	}
	public void setLoja(String loja) {
		this.loja = loja;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}

}
