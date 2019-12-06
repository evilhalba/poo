package com.pootrab.models;

import java.util.List;



public class Viagem {
	private float vlCustoEstMotorista;
	private float vlCustoEstVeiculo;
	private int qtdPassageiros;
	private Unidade unidade;
	private TipoDeslocamento tipoDeslocamento;
	//private DataSolicitacao dtSolicitacao;
	private Veiculo veiculo;
	private Situacao situacao;
	private List<Passageiro> passageiros;
	private Motorista motorista;
	
	public Motorista getMotorista() {
		return motorista;
	}

	public void setMotorista(Motorista motorista) {
		this.motorista = motorista;
	}

	public List<Passageiro> getPassageiros() {
		return passageiros;
	}

	public void setPassageiros(List<Passageiro> passageiros) {
		this.passageiros = passageiros;
	}

	public Viagem(){}
	
	public Viagem(float vlCustoEstMotorista, float vlCustoEstVeiculo, int qtdPassageiros, Unidade unidade, TipoDeslocamento tipoDeslocamento,/* DataSolicitacao dtSolicitacao */, Veiculo veiculo, Situacao situacao ) {
		super();
		this.vlCustoEstMotorista=vlCustoEstMotorista;		
		this.vlCustoEstVeiculo=vlCustoEstVeiculo;
		this.qtdPassageiros=qtdPassageiros;
		this.unidade=unidade;
		this.tipoDeslocamento=tipoDeslocamento;
		//this.dtSolicitacao=dtSolicitacao;
		this.veiculo=veiculo;
		this.situacao=situacao;
	}
	
	public float getVlCustoEstMotorista() {
		return vlCustoEstMotorista;
	}
	public void setVlCustoEstMotorista(float vlCustoEstMotorista) {
		this.vlCustoEstMotorista = vlCustoEstMotorista;
	}
	public float getVlCustoEstVeiculo() {
		return vlCustoEstVeiculo;
	}
	public void setVlCustoEstVeiculo(float vlCustoEstVeiculo) {
		this.vlCustoEstVeiculo = vlCustoEstVeiculo;
	}
	public int getQtdPassageiros() {
		return qtdPassageiros;
	}
	public void setQtdPassageiros(int qtdPassageiros) {
		this.qtdPassageiros = qtdPassageiros;
	}
	public Unidade getUnidade() {
		return unidade;
	}
	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}
	public TipoDeslocamento getTipoDeslocamento() {
		return tipoDeslocamento;
	}
	public void setTipoDeslocamento(TipoDeslocamento tipoDeslocamento) {
		this.tipoDeslocamento = tipoDeslocamento;
	}
	public DataSolicitacao getDtSolicitacao() {
		return dtSolicitacao;
	}
	public void setDtSolicitacao(DataSolicitacao dtSolicitacao) {
		this.dtSolicitacao = dtSolicitacao;
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
}
