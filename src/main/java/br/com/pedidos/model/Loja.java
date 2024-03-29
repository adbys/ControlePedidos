package br.com.pedidos.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Loja implements Comparable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long lojaId;
	private String nome;
//	@OneToMany(mappedBy = "loja", targetEntity = Pedido.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//	private List<Pedido> pedidos;
	
	public Loja () {
		
	}
	
	public Long getId () {
		return this.lojaId;
	}
	
	public void setId (Long id) {
		this.lojaId = id;
	}
	
	public String getNome () {
		return this.nome;
	}
	
	public void setNome (String nome) {
		this.nome = nome;
	}

	@Override
	public int compareTo(Object o) {
		Loja outraLoja = (Loja) o;

		return this.nome.compareTo(outraLoja.getNome());
	}


}
