package com.pootrab.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Pessoa {
	
	@Id
	@NotNull
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int idPessoa;
	@NotNull
	private int tipo;
	/*
	 * 1 =
	 * 2 = 
	 * 3 =
	 * 4 = 
	 * 
	 */
	
	private int nome;
	private String sexo;
	private String ncnh;
	private String rg;
	private String cpfecnpj;
	private String rasaoSocial;
	
	
	
	public int getIdPessoa() {
		return idPessoa;
	}
	public void setIdPessoa(int idPessoa) {
		this.idPessoa = idPessoa;
	}
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	public int getNome() {
		return nome;
	}
	public void setNome(int nome) {
		this.nome = nome;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getNcnh() {
		return ncnh;
	}
	public void setNcnh(String ncnh) {
		this.ncnh = ncnh;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getCpfecnpj() {
		return cpfecnpj;
	}
	public void setCpfecnpj(String cpfecnpj) {
		this.cpfecnpj = cpfecnpj;
	}
	public String getRasaoSocial() {
		return rasaoSocial;
	}
	public void setRasaoSocial(String rasaoSocial) {
		this.rasaoSocial = rasaoSocial;
	}

	
	
	
	
}
