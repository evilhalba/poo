package com.pootrab.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
@Entity
public class Situacao {
	
	
	@Id
	@NotNull
	private String situacaoid;
	
	
	@OneToMany(mappedBy="situacao")
	private List<Viagem> viagens;


	

	public String getSituacaoid() {
		return situacaoid;
	}


	public void setSituacaoid(String situacaoid) {
		this.situacaoid = situacaoid;
	}


	public List<Viagem> getViagens() {
		return viagens;
	}


	public void setViagens(List<Viagem> viagens) {
		this.viagens = viagens;
	}
	
	

	
	
}
