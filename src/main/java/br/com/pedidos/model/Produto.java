package br.com.pedidos.model;

import javax.persistence.Embeddable;
import javax.persistence.Id;

@Embeddable
public class Produto {

	@Id
	private Long id;
	
}
