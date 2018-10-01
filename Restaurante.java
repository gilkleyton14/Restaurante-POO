package br.ufpb.dcx.poo.restaurantes.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Restaurante extends AbstractRestaurants{

	private Long id;
	private String nome;

	public Restaurante() {
		super();
	}

	public Restaurante(long id, String nome) {
		this.id = id;
		this.nome = nome;

	}

	public long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Restaurante findOne(Integer codigo) {
		return null;
	}

	public void delete(Restaurante restaurante) {
		// TODO Auto-generated method stub
		
	}

}