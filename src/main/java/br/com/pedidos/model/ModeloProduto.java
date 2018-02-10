package br.com.pedidos.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ModeloProduto {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long id;
	private String nome;
	@Enumerated(EnumType.STRING)
	private CategoriaProdutos categoria;
	@Enumerated(EnumType.STRING)
	private GeneroProdutos genero;
	private String cor;
	private double precoCusto;
	private double precoVenda;
	

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public GeneroProdutos getGenero() {
		return genero;
	}

	public void setGenero(GeneroProdutos genero) {
		this.genero = genero;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public CategoriaProdutos getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaProdutos categoria) {
		this.categoria = categoria;
	}

}
