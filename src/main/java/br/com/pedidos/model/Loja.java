package br.com.pedidos.model;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Embeddable
public class Loja {
	
	private String nome;
	public Loja () {
		
	}
	
	public String getNome () {
		return this.nome;
	}
	
	public void setNome (String nome) {
		this.nome = nome;
	}

}
