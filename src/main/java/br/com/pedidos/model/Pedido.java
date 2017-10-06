package br.com.pedidos.model;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

@Entity
public class Pedido {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String dataPedido;
	private String dataRecebimento;
	private String observacoes;
	private String loja;
	private String marca;
//	@ManyToOne
//	@JoinColumn(name = "loja_id")
//	private Loja loja;
//	@ManyToOne
//	@JoinColumn(name = "marca_id")
//	private Marca marca;
	@ElementCollection
	@CollectionTable(
		name="produtos",
		joinColumns=@JoinColumn(name="pedido_id")
	)
	private List<Produto> produtos;
	
	public String getLoja() {
		return this.loja;
	}
	
	public String getMarca() {
		return this.marca;
	}
	
	public void setLoja(String loja) {
		this.loja = loja;
	}

	public void setMarca(String marca) {
		this.marca = marca;
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
	
//	public Loja getLoja() {
//		return loja;
//	}
//	
//	public void setLoja(Loja loja) {
//		this.loja = loja;
//	}
//	
//	public Marca getMarca() {
//		return marca;
//	}
//	public void setMarca(Marca marca) {
//		this.marca = marca;
//	}

	public String getObservacoes() {
		return observacoes;
	}
	
	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}
	
	public List<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
	
	
}
