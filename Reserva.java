package br.ufpb.dcx.poo.restaurantes.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class Reserva extends AbstractRestaurants{
	
	private Long id;
	private String dataInicial;
	private String dataFinal;
	private int numPessoas;
	private String nomeResponsavel;
	private int numMesa;
	
	public Reserva() {
		super();
	}

	public Reserva(Long id, String dataInicial, String dataFinal, int numPessoas, String nomeResponsavel, int numMesa) {
	
		this.id = id;
		this.dataInicial = dataInicial;
		this.dataFinal = dataFinal;
		this.numPessoas = numPessoas;
		this.nomeResponsavel = nomeResponsavel;
		this.numMesa = numMesa;
	}

	public String getNomeResponsavel() {
		return nomeResponsavel;
	}

	public void setNomeResponsavel(String nomeResponsavel) {
		this.nomeResponsavel = nomeResponsavel;
	}

	public int getNumMesa() {
		return numMesa;
	}

	public void setNumMesa(int numMesa) {
		this.numMesa = numMesa;
	}

	public long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDataInicial() {
		return dataInicial;
	}

	public void setDataInicial(String dataInicial) {
		this.dataInicial = dataInicial;
	}

	public String getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(String dataFinal) {
		this.dataFinal = dataFinal;
	}

	public int getNumPessoas() {
		return numPessoas;
	}

	public void setNumPessoas(int numPessoas) {
		this.numPessoas = numPessoas;
	}
	
}
