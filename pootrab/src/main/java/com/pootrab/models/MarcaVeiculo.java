package com.pootrab.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class MarcaVeiculo {
	
	@Id
	@NotNull
	private String marcaveiculoid;
	
	
	@OneToMany(mappedBy="marcaveiculo")
	private List<ModeloVeiculo> modelosveiculos;


	public String getMarcaveiculoid() {
		return marcaveiculoid;
	}


	public void setMarcaveiculoid(String marcaveiculoid) {
		this.marcaveiculoid = marcaveiculoid;
	}


	public List<ModeloVeiculo> getModelosveiculos() {
		return modelosveiculos;
	}


	public void setModelosveiculos(List<ModeloVeiculo> modelosveiculos) {
		this.modelosveiculos = modelosveiculos;
	}
	
	
	
	
}
