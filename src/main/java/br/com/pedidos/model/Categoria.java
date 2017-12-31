package br.com.pedidos.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Categoria implements Comparable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String nome;
	
	public Categoria () {
		
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

	@Override
	public int compareTo(Object o) {
		Categoria categoria = (Categoria) o;
		return this.nome.compareTo(categoria.getNome());
	}

}
