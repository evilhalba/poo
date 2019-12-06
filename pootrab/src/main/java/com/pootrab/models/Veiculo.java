package com.pootrab.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
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
	

	@ManyToOne
	@JoinColumn(name="idmodeloveiculo")
	private ModeloVeiculo modeloveiculo;

	
	@OneToMany(mappedBy="veiculo")
	private List<Viagem> viagens;


	
	
	
}
