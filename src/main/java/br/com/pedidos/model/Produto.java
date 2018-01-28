package br.com.pedidos.model;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Embeddable
public class Produto {
	
	private String nome;
	private int quantidade;
	@Enumerated(EnumType.STRING)
	private CategoriaProdutos categoria;
	private double precoCusto;
	private double precoVenda;
	private boolean recebido;
	private String cor;
	private String tamanho;
	@Enumerated(EnumType.STRING)
	private GeneroProdutos genero;
	
	
	
	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getTamanho() {
		return tamanho;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}

	public GeneroProdutos getGenero() {
		return genero;
	}

	public void setGenero(GeneroProdutos genero) {
		this.genero = genero;
	}

	public boolean isRecebido() {
		return recebido;
	}

	public void setRecebido(boolean recebido) {
		this.recebido = recebido;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getQuantidade() {
		return quantidade;
	}
	
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	public CategoriaProdutos getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaProdutos categoria) {
		this.categoria = categoria;
	}

	public double getPrecoCusto() {
		return precoCusto;
	}
	
	public void setPrecoCusto(double precoCusto) {
		this.precoCusto = precoCusto;
	}
	
	public double getPrecoVenda() {
		return precoVenda;
	}
	
	public void setPrecoVenda(double precoVenda) {
		this.precoVenda = precoVenda;
	}
	
}
