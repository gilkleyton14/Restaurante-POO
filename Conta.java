package br.ufpb.dcx.poo.restaurantes.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Conta extends AbstractRestaurants{

	private long id;
	private double valor;
	private String formaPagamento;
	
	public Conta() {
		super();
	}

	public Conta(long id, double valor, String formaPagamento) {
		this.id = id;
		this.valor = valor;
		this.formaPagamento = formaPagamento;
	}

	public long getId() {
		return id;
	}
	
	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

}
