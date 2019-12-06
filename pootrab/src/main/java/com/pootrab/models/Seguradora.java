package com.pootrab.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Seguradora {
	
	
	
	@Id
	@NotNull
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int id;
	private int nome;
	private String endereco;
	
	@OneToMany(mappedBy="seguradora")
	private List<Viagem> viagens;
	
	
	
	public List<Viagem> getViagens() {
		return viagens;
	}
	public void setViagens(List<Viagem> viagens) {
		this.viagens = viagens;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNome() {
		return nome;
	}
	public void setNome(int nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	

	
}
