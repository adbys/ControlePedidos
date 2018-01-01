package br.com.pedidos.model;

import java.util.Collection;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OrderColumn;

@Entity
public class FormaDePagamento {
	
	@Id
	@GeneratedValue
	private long id;
	private String nome;
	@ElementCollection
	@OrderColumn
	private Collection<String> parcelas;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Collection<String> getParcelas() {
		return parcelas;
	}
	public void setParcelas(Collection<String> parcelas) {
		this.parcelas = parcelas;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	

}
