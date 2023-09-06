package com.jdbc.controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.jdbc.factory.connectionFactory;
import com.jdbc.dao.ReservasDAO;
import com.jdbc.modelo.Reservas;


public class ReservasController {
	
	private ReservasDAO reservasDAO;
	
	public ReservasController() {
		this.reservasDAO = new ReservasDAO(new connectionFactory().recuperarConexion());
	}
	
	public void guardar(Reservas reservas) {
		reservasDAO.guardar(reservas);
	}
	public List<Reservas> buscar(){
		return this.reservasDAO.buscar();
	}
	public List<Reservas> buscarId(String id){
		return this.reservasDAO.buscarReservaId(id);
	}
	public void eliminar(Integer id) {
		reservasDAO.eliminar(id);
	}
	public void modificar(Date dateIn, Date dateOut, String valor, String formaPago, Integer id) {
		reservasDAO.modificar(dateIn, dateOut, valor, formaPago, id);
	}

}
