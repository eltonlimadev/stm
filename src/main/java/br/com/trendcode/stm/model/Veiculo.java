package br.com.trendcode.stm.model;

import java.io.Serializable;

public class Veiculo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private long codigo;
	private String placa;
	private String marca;
	private int ano;
	private String modelo;
	private String cor;
	private String chassi;
	private String renavam;
	private String combustivel;
	private double odometro;
	private String situacao; // Reserva, Titular, Desmobilizado.
	private String status; // Em contrato, Disponível, Manutenção, Vendido.
	private Empresa proprietario;
	
	public Veiculo() {
		
	}

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getChassi() {
		return chassi;
	}

	public void setChassi(String chassi) {
		this.chassi = chassi;
	}

	public String getRenavam() {
		return renavam;
	}

	public void setRenavam(String renavam) {
		this.renavam = renavam;
	}

	public String getCombustivel() {
		return combustivel;
	}

	public void setCombustivel(String combustivel) {
		this.combustivel = combustivel;
	}

	public double getOdometro() {
		return odometro;
	}

	public void setOdometro(double odometro) {
		this.odometro = odometro;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Empresa getProprietario() {
		return proprietario;
	}

	public void setProprietario(Empresa proprietario) {
		this.proprietario = proprietario;
	}
}
