package br.ufpb.dcx.poo.restaurantes.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Mesa extends AbstractRestaurants{
	
	private Long id;
	private String numero;
	private Boolean deReserva;
	private int capacidade;
	
	public Mesa() {
		super();
	}


	public Mesa(Long id, String numero, Boolean deReserva, int capacidade) {
		super();
		this.id = id;
		this.numero = numero;
		this.deReserva = deReserva;
		this.capacidade = capacidade;
	}


	public long getId() {
		return id;
	}


	@Override
	public void setId(Long id) {
		this.id = id;
		
	}

	public String getNumero() {
		return numero;
	}


	public void setNumero(String numero) {
		this.numero = numero;
	}


	public Boolean getDeReserva() {
		return deReserva;
	}


	public void setDeReserva(Boolean deReserva) {
		this.deReserva = deReserva;
	}


	public int getCapacidade() {
		return capacidade;
	}


	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}
	
}
