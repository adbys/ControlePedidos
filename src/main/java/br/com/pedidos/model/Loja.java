package br.com.pedidos.model;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Embeddable
public class Loja {
	
	@Id
	@GeneratedValue
	private Long id;
	private String nome;
	public Loja () {
		
	}
	
	public Long getId () {
		return this.id;
	}
	
	public void setId (Long id) {
		this.id = id;
	}
	
	public String getNome () {
		return this.nome;
	}
	
	public void setNome (String nome) {
		this.nome = nome;
	}

}
