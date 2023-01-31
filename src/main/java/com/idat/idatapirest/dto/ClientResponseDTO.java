package com.idat.idatapirest.dto;

public class ClientResponseDTO {

	private Integer idcliente;
	private String nombrecliente;
	private String celularcliente;
	public Integer getIdcliente() {
		return idcliente;
	}
	public void setIdcliente(Integer idcliente) {
		this.idcliente = idcliente;
	}
	public String getNombrecliente() {
		return nombrecliente;
	}
	public void setNombrecliente(String nombrecliente) {
		this.nombrecliente = nombrecliente;
	}
	public String getCelularcliente() {
		return celularcliente;
	}
	public void setCelularcliente(String celularcliente) {
		this.celularcliente = celularcliente;
	}
}
