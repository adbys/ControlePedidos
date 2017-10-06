package br.com.pedidos.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Pedido {
	
	@Id
	@GeneratedValue
	private Long id;
	private Date dataPedido;
	private String dataRecebimento;
	private String observacoes;
//	@Embedded
//	private Loja loja;
//	@Embedded
//	private Marca marca;
//	@Embedded
//	private List<Produto> produtos;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Date getDataPedido() {
		return dataPedido;
	}
	
	public void setDataPedido(Date dataPedido) {
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
	
//	public List<Produto> getProdutos() {
//		return produtos;
//	}
//	public void setProdutos(List<Produto> produtos) {
//		this.produtos = produtos;
//	}
	
	
	
}
