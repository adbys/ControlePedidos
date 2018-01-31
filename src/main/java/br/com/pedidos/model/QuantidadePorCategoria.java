package br.com.pedidos.model;

public class QuantidadePorCategoria {
	
	private CategoriaProdutos categoria;
	private GeneroProdutos genero;
	private int quantidade;
	
	public QuantidadePorCategoria(CategoriaProdutos categoria, GeneroProdutos generoProdutos, int quantidade) {
		this.categoria = categoria;
		this.quantidade = quantidade;
		this.genero = generoProdutos;
	}
	public CategoriaProdutos getCategoria() {
		return categoria;
	}
	public void setCategoria(CategoriaProdutos categoria) {
		this.categoria = categoria;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	public GeneroProdutos getGenero() {
		return genero;
	}
	public void setGenero(GeneroProdutos genero) {
		this.genero = genero;
	}
	
	

}
