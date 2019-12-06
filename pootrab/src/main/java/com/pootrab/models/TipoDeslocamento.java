package com.pootrab.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
@Entity
public class TipoDeslocamento {
	
	@Id
	@NotNull
	private String tipodeslocamentoid;
	
	
	@OneToMany(mappedBy="tipodeslocamento")
	private List<Viagem> viagens;


	public String getTipodeslocamentoid() {
		return tipodeslocamentoid;
	}


	public void setTipodeslocamentoid(String tipodeslocamentoid) {
		this.tipodeslocamentoid = tipodeslocamentoid;
	}


	public List<Viagem> getViagens() {
		return viagens;
	}


	public void setViagens(List<Viagem> viagens) {
		this.viagens = viagens;
	}
	
	
	
	
	
	
	
}
