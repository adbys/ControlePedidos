package br.com.pedidos.model;

public class ValorPorLoja {
	
	private String loja;
	private double valor;
	
	public ValorPorLoja(String nome, Double valor) {
		this.loja = nome;
		this.valor = valor;
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
