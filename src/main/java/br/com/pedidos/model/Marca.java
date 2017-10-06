package br.com.pedidos.model;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Embeddable
public class Marca {

	@Id
	@GeneratedValue
	private Long id;
	private String nome;
	private String codigo;
	
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

}
