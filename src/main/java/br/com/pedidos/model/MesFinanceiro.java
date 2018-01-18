package br.com.pedidos.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class MesFinanceiro implements Comparable {
	
	@Id
	@GeneratedValue
	private Long id;
	private String mes;
	private String ano;
	private double valorTotal;
	
	public MesFinanceiro(String mes, String ano, double valorParcela) {
		this.mes = mes;
		this.ano = ano;
		this.valorTotal = valorParcela;
	}
	
	public MesFinanceiro() {
		
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMes() {
		return mes;
	}
	public void setMes(String mes) {
		this.mes = mes;
	}
	public String getAno() {
		return ano;
	}
	public void setAno(String ano) {
		this.ano = ano;
	}
	public double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	@Override
	public int compareTo(Object o) {
		MesFinanceiro outroMes = (MesFinanceiro) o;
		
		if(this.ano.compareTo(outroMes.getAno()) == 0) {
			return this.mes.compareTo(outroMes.getMes());
		} else {
			return this.ano.compareTo(outroMes.getAno());
		}
		
	}
	
	

}
