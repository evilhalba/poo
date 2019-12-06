package com.pootrab.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class ModeloVeiculo {
	
	@Id
	@NotNull
	private String modeloveiculoid;
	
	
	
	
	@ManyToOne
	@JoinColumn(name="idMarcaVeiculo")
	private MarcaVeiculo marcaveiculo;
	
	@OneToMany(mappedBy="modeloveiculo")
	private List<Veiculo> veiculos;

	public String getModeloveiculoid() {
		return modeloveiculoid;
	}

	public void setModeloveiculoid(String modeloveiculoid) {
		this.modeloveiculoid = modeloveiculoid;
	}

	public MarcaVeiculo getMarcaveiculo() {
		return marcaveiculo;
	}

	public void setMarcaveiculo(MarcaVeiculo marcaveiculo) {
		this.marcaveiculo = marcaveiculo;
	}

	public List<Veiculo> getVeiculos() {
		return veiculos;
	}

	public void setVeiculos(List<Veiculo> veiculos) {
		this.veiculos = veiculos;
	}
	
	
	
}
