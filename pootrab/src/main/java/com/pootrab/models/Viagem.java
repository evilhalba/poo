package com.pootrab.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Viagem {
	
	
	@Id
	@NotNull
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int idViagem;
	
	
	private double vlCustoEstMotorista;
	private double vlCustoEstVeiculo;
	private String dtSolicitacao;

	@ManyToMany
	@JoinTable(
			name="ViagemTemPessoas", 
			joinColumns = @JoinColumn(name = "idViagem", referencedColumnName = "idViagem"),
			inverseJoinColumns = @JoinColumn(name = "idPessoa")
			)
	private List<Pessoa> pessoas;

	@ManyToOne
	@JoinColumn(name="idUnidade")
	private Unidade unidade;
	
	@ManyToOne
	@JoinColumn(name="idTipoDeslocamento")
	private TipoDeslocamento tipodeslocamento;
	
	@ManyToOne
	@JoinColumn(name="idVeiculo")
	private Veiculo veiculo;
	
	@ManyToOne
	@JoinColumn(name="idSituacao")
	private Situacao situacao;
	
	
	@ManyToOne
	@JoinColumn(name="idSeguradora")
	private Seguradora seguradora;
	/*
	 * NO MINIMO UMA PESSOA COM TIPO MOTORISTA
	 * MANY TO MANY EM PESSOA
	 * UNIDADE ONE TO MANY
	 * TIPO DESCOLAMENTO ONE TO MANY
	 * VEICULO ONE TO MANY
	 * SITUAÇAO ONE TO MANY
	 * SEGURADORA ONE TO MANY
	 */


	public int getIdViagem() {
		return idViagem;
	}


	public void setIdViagem(int idViagem) {
		this.idViagem = idViagem;
	}


	public double getVlCustoEstMotorista() {
		return vlCustoEstMotorista;
	}


	public void setVlCustoEstMotorista(double vlCustoEstMotorista) {
		this.vlCustoEstMotorista = vlCustoEstMotorista;
	}


	public double getVlCustoEstVeiculo() {
		return vlCustoEstVeiculo;
	}


	public void setVlCustoEstVeiculo(double vlCustoEstVeiculo) {
		this.vlCustoEstVeiculo = vlCustoEstVeiculo;
	}


	public String getDtSolicitacao() {
		return dtSolicitacao;
	}


	public void setDtSolicitacao(String dtSolicitacao) {
		this.dtSolicitacao = dtSolicitacao;
	}


	public List<Pessoa> getPessoas() {
		return pessoas;
	}


	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}


	public Unidade getUnidade() {
		return unidade;
	}


	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}


	public TipoDeslocamento getTipodeslocamento() {
		return tipodeslocamento;
	}


	public void setTipodeslocamento(TipoDeslocamento tipodeslocamento) {
		this.tipodeslocamento = tipodeslocamento;
	}


	public Veiculo getVeiculo() {
		return veiculo;
	}


	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}


	public Situacao getSituacao() {
		return situacao;
	}


	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}


	public Seguradora getSeguradora() {
		return seguradora;
	}


	public void setSeguradora(Seguradora seguradora) {
		this.seguradora = seguradora;
	}
	
	
	
}
