package com.pootrab.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class MarcaVeiculo {
	
	@Id
	@NotNull
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int id;
	private String nome;
	
	@OneToMany(mappedBy="marcaveiculo")
	private List<ModeloVeiculo> modelosveiculos;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
}
