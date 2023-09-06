package com.jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jdbc.modelo.Reservas;

public class ReservasDAO {
	final private Connection con;

	public ReservasDAO(Connection con) {
		this.con = con;
	}
	

	public void guardar(Reservas reservas) { 
		try{

			final PreparedStatement statement = con.prepareStatement("INSERT INTO RESERVAS ("
					+ "fecha_de_entrada,"
					+ "fecha_de_salida,"
					+ "forma_de_pago, "
					+ "valor)" 
					+ "VALUES(?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
			try(statement){
				statement.setDate(1, reservas.getDateIn());
				statement.setDate(2, reservas.getDateOut());
				statement.setString(3, reservas.getFormaPago());
				statement.setString(4, reservas.getValor());
				


				statement.execute();
				final ResultSet resultSet = statement.getGeneratedKeys();

				try(resultSet){
					while(resultSet.next()) {
						reservas.setId(resultSet.getInt(1));
						System.out.println(String.format("Fue insertado la reserva de %s",reservas));
					}
				}
			
			}
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public List<Reservas> buscar(){
		List<Reservas> reservas = new ArrayList<Reservas>();
		
		try {
			try (final PreparedStatement statement = con.prepareStatement("SELECT id, fecha_de_entrada, fecha_de_salida, "
					+ "valor,forma_de_pago FROM RESERVAS")){
				statement.execute();
				transformarResultSetEnReserva(reservas,statement);
				
			}
			return reservas;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	public void transformarResultSetEnReserva(List<Reservas> reservas, PreparedStatement statement)throws SQLException{ 
		try(ResultSet resultSet = statement.getResultSet();){
			while (resultSet.next()) {
				Reservas reserva = new Reservas(resultSet.getInt(1),resultSet.getDate(2), resultSet.getDate(3),resultSet.getString(4),resultSet.getString(5));
				reservas.add(reserva);
			}
		}
	} 
	public List<Reservas> buscarReservaId(String id) {
		List<Reservas> reservas = new ArrayList<Reservas>();
		try {
			try (final PreparedStatement statement = con.prepareStatement("SELECT id, fecha_de_entrada, fecha_de_salida, "
					+ "valor,forma_de_pago FROM RESERVAS WHERE ID = ?")){
				statement.setString(1, id);
				statement.execute();
				transformarResultSetEnReserva(reservas,statement);
			}
			return reservas;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	public void eliminar(Integer id) {
		try {
			final PreparedStatement statement = con.prepareStatement("DELETE FROM RESERVAS WHERE ID = ?");
			try(statement){
				statement.setInt(1, id);;
				statement.execute();
				
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public void modificar(Date dateIn, Date dateOut, String valor, String formaPago, Integer id) {
		try {
			final PreparedStatement statement = con.prepareStatement("UPDATE RESERVAS SET "
					+ " fecha_de_entrada = ?, "
					+ " fecha_de_salida = ?, "
					+ " valor = ?, "
					+ " forma_de_pago = ?"
					+ " WHERE ID = ?");
			try(statement){
				statement.setDate(1, dateIn);
				statement.setDate(2, dateOut);
				statement.setString(3, valor);
				statement.setString(4, formaPago);
				statement.setInt(5, id);
				statement.execute();
			}
		} catch (SQLException e) {
			throw new RuntimeException (e);
		}
	}
}
