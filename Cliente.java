package br.ufpb.dcx.poo.restaurantes.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Cliente extends AbstractRestaurants {
	
	private Long id;
	private String nome;
	
	public Cliente() {
		super();
	}

	public Cliente(int id, String nome) {
		this.id = (long) id;
		this.nome = nome;
	}

	public long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
		
	}
	
}
