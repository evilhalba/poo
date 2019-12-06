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
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int id;
	
	
	private String nome;
	
	@ManyToOne
	@JoinColumn(name="idMarcaVeiculo")
	private MarcaVeiculo marcaveiculo;
	
	@OneToMany(mappedBy="modeloVeiculo")
	private List<Veiculo> veiculos;
	
	
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
