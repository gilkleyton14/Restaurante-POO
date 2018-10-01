package br.ufpb.dcx.poo.restaurantes.models;

public abstract class AbstractRestaurants {
	
	public abstract long getId();
	public abstract void setId(Long id);
	
	public boolean temIdValido(){
		return  getId() != 0;
	}

}
