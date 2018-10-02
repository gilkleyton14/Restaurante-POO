package br.ufpb.dcx.poo.restaurantes.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Pedido extends AbstractRestaurants{
	
	private Long id;
	private String data;
	private String descricao;
	private float total;
	
	
	public Pedido() {
		super();
	}
	

	public Pedido(Long id, String data, String descricao, float total) {
		this.id = id;
		this.data = data;
		this.descricao = descricao;
		this.total = total;
	}

	public long getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getData() {
		return data;
	}


	public void setData(String data) {
		this.data = data;
	}

	public float getTotal() {
		return total;
	}


	public void setTotal(float total) {
		this.total = total;
	}

}
