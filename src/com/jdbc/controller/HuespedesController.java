package com.jdbc.controller;

import java.sql.Date;
import java.util.List;

import com.jdbc.dao.HuespedesDAO;
import com.jdbc.factory.connectionFactory;
import com.jdbc.modelo.Huespedes;


public class HuespedesController {
	
	private HuespedesDAO huespedesDAO;
	
	public HuespedesController() {
		this.huespedesDAO = new HuespedesDAO(new connectionFactory().recuperarConexion());
	}
	
	public void guardar(Huespedes huespedes) {
		huespedesDAO.guardar(huespedes);
	}
	public List<Huespedes> buscar(){
		return this.huespedesDAO.buscar();
	}
	public List<Huespedes> buscarHuespedesId(String id){
		return this.huespedesDAO.buscarHuespedesId(id);
	}
	public void eliminar(Integer id) {
		huespedesDAO.eliminar(id);
	}
	public void modificar(String nombre, String apellido, Date fechaNacimiento, String nacionalidad, String telefono, Integer idReservas, Integer id) {
		huespedesDAO.modificar(nombre, apellido, fechaNacimiento, nacionalidad, telefono, idReservas, id);
	}

}
