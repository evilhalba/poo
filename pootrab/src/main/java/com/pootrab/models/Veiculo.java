package com.pootrab.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;


@Entity
public class Veiculo {
	
	@Id
	@NotNull
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int id;
	@NotNull
	private String placa;
	

	@OneToMany
	@JoinTable(name="idModeloVeiculo")
	private ModeloVeiculo modeloVeiculo;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getPlaca() {
		return placa;
	}


	public void setPlaca(String placa) {
		this.placa = placa;
	}


	public ModeloVeiculo getModeloVeiculo() {
		return modeloVeiculo;
	}


	public void setModeloVeiculo(ModeloVeiculo modeloVeiculo) {
		this.modeloVeiculo = modeloVeiculo;
	}
	
	

	

	
}
