package com.jdbc.modelo;

import java.sql.Date;

public class Reservas {
	
	
	private Integer id;
	private Date dateIn;
	private Date dateOut;
	private String valor;
	private String formaPago;
	
	public Reservas(Date dateIn, Date dateOut, String valor, String formaPago) {
		this.dateIn = dateIn;
		this.dateOut = dateOut;
		this.valor = valor;
		this.formaPago = formaPago;
	}
	
	public Reservas(int id, Date dateIn, Date dateOut, String valor, String formaPago) {
		this.id = id;
		this.dateIn = dateIn;
		this.dateOut = dateOut;
		this.valor = valor;
		this.formaPago = formaPago;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDateIn() {
		return dateIn;
	}

	public void setDateIn(Date dateIn) {
		this.dateIn = dateIn;
	}

	public Date getDateOut() {
		return dateOut;
	}

	public void setDateOut(Date dateOut) {
		this.dateOut = dateOut;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getFormaPago() {
		return formaPago;
	}

	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
	}


}

