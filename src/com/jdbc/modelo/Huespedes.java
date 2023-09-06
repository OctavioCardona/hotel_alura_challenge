package com.jdbc.modelo;

import java.sql.Date;

public class Huespedes {
	
	private Integer Id;
	private String nombre;
	private String apellido;
	private Date fechaNacimiento;
	private String nacionalidad;
	private String telefono;
	private Integer IdReservas;
	
	public Huespedes(String nombre, String apellido, Date fechaNacimiento, String nacionalidad, String telefono, Integer IdReservas) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.nacionalidad = nacionalidad;
		this.telefono = telefono;
		this.IdReservas = IdReservas;
	}
	public Huespedes(int Id, String nombre, String apellido, Date fechaNacimiento, String nacionalidad, String telefono, Integer IdReservas) {
		this.Id = Id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.nacionalidad = nacionalidad;
		this.telefono = telefono;
		this.IdReservas = IdReservas;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public void setIdReservas(Integer idReservas) {
		IdReservas = idReservas;
	}
	public Integer getId() {
		return Id;
	}
	public String getNombre() {
		return nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public String getNacionalidad() {
		return nacionalidad;
	}
	public String getTelefono() {
		return telefono;
	}
	public Integer getIdReservas() {
		return IdReservas;
	}
	
}
