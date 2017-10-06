package br.com.pedidos.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
@Embeddable
public class Marca {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String nome;
	private String codigo;
	@OneToMany(mappedBy = "marca", targetEntity = Pedido.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Pedido> pedidos;
	
	public Marca() {
		
	}
	
	public Long getId () {
		return this.id;
	}
	
	public void getId (Long id) {
		this.id = id;
	}
	
	public String getNome () {
		return this.nome;
	}
	
	public void setNome (String nome) {
		this.nome = nome;
	}
	
	public String getCodigo () {
		return this.codigo;
	}
	
	public void setCodigo (String codigo) {
		this.codigo = codigo;
	}
	
	public List<Pedido> getPedidos() {
		return this.pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

}
