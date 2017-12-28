package br.com.pedidos.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Pedido {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String dataPedido;
	private String dataRecebimento;
	private String observacoes;
	private double valorTotal;
	private int desconto;
	@ElementCollection
	private Set<Produto> produtos;
	@OneToOne
	@JoinColumn(name = "loja_id")
	private Loja loja;
	@OneToOne
	@JoinColumn(name = "marca_id")
	private Marca marca;
//	@ElementCollection
//	@CollectionTable( 
//		name="produtos",
//		joinColumns=@JoinColumn(name="pedido_id")
//	)
//	private List<Produto> produtos;
	
	public Loja getLoja() {
		return this.loja;
	}
	
	public Marca getMarca() {
		return this.marca;
	}
	
	public void setLoja(Loja loja) {
		this.loja = loja;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}
	

	public Pedido() {
		this.produtos = new HashSet<Produto>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getDataPedido() {
		return dataPedido;
	}
	
	public void setDataPedido(String dataPedido) {
		this.dataPedido = dataPedido;
	}
	
	public String getDataRecebimento() {
		return dataRecebimento;
	}
	
	public void setDataRecebimento(String dataRecebimento) {
		this.dataRecebimento = dataRecebimento;
	}

	public String getObservacoes() {
		return observacoes;
	}
	
	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}
	
	public double getValorTotal() {
		return this.valorTotal;
	}
	
	public void setValorTotal (double valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	public double getDesconto() {
		return this.desconto;
	}
	
	public void setDesconto (int desconto) {
		this.desconto = desconto;
	}
	
	public Set<Produto> getProdutos() {
		return produtos;
	}
	
	public void setProdutos(Set<Produto> produtos) {
		this.produtos = produtos;
	}
	
}
