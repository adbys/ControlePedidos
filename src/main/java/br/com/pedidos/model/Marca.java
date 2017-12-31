package br.com.pedidos.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Marca implements Comparable {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String nome;
	private String codigo;
//	@OneToMany(mappedBy = "marca", targetEntity = Pedido.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//	private List<Pedido> pedidos;
	
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

	@Override
	public int compareTo(Object marca) {
		Marca outraMarca = (Marca) marca;
		return this.nome.compareToIgnoreCase(outraMarca.getNome());
	}


}
