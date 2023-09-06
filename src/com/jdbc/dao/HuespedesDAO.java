package com.jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jdbc.modelo.Huespedes;

public class HuespedesDAO {
	
	final private Connection con;

	public HuespedesDAO(Connection con) {
		this.con = con;
	}
	
	public void guardar(Huespedes huespedes) {
		try{

			final PreparedStatement statement = con.prepareStatement("INSERT INTO HUESPEDES ("
					+ "nombre,"
					+ "apellido,"
					+ "fecha_de_nacimiento,"
					+ "nacionalidad,"
					+ "telefono,"
					+ "reserva_id)" 
					+ "VALUES(?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
			try(statement){
				
				statement.setString(1, huespedes.getNombre());
				statement.setString(2, huespedes.getApellido());
				statement.setDate(3, huespedes.getFechaNacimiento());
				statement.setString(4, huespedes.getNacionalidad());
				statement.setString(5, huespedes.getTelefono());
				statement.setInt(6, huespedes.getIdReservas());
				statement.execute();
				
				final ResultSet resultSet = statement.getGeneratedKeys();

				try(resultSet){
					while(resultSet.next()) {
						huespedes.setId(resultSet.getInt(1));
						System.out.println(String.format("Fue insertado el huesped de %s",huespedes));
					}
				}
			
			}
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	public List<Huespedes> buscar(){
		List<Huespedes> huespedes = new ArrayList<Huespedes>();
		
		try {
			try (final PreparedStatement statement = con.prepareStatement("SELECT id, "
					+ "nombre,"
					+ "apellido,"
					+ "fecha_de_nacimiento,"
					+ "nacionalidad,"
					+ "telefono,"
					+ "reserva_id FROM HUESPEDES")){
				statement.execute();
				transformarResultSetEnHusped(huespedes,statement);
				
			}
			return huespedes;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	} 
	public List<Huespedes> buscarHuespedesId(String id){
		List<Huespedes> huespedes = new ArrayList<Huespedes>();

		try {
			try (final PreparedStatement statement = con.prepareStatement("SELECT id, "
					+ "nombre,"
					+ "apellido,"
					+ "fecha_de_nacimiento,"
					+ "nacionalidad,"
					+ "telefono,"
					+ "reserva_id FROM HUESPEDES WHERE reserva_id = ?")){
				statement.setString(1, id);
				statement.execute();
				transformarResultSetEnHusped(huespedes,statement);

			}
			return huespedes;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public void transformarResultSetEnHusped(List<Huespedes> huespedes, PreparedStatement statement)throws SQLException{ 
		try(ResultSet resultSet = statement.getResultSet();){
			while (resultSet.next()) {
				Huespedes huesped = new Huespedes(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),
						resultSet.getDate(4),resultSet.getString(5),resultSet.getString(6),resultSet.getInt(7));
				huespedes.add(huesped);
			}
		}
	}
	public void eliminar(Integer id) {
		try {
			final PreparedStatement statement = con.prepareStatement("DELETE FROM HUESPEDES WHERE ID = ?");
			try(statement){
				statement.setInt(1, id);;
				statement.execute();
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public void modificar(String nombre, String apellido, Date fechaNacimiento, String nacionalidad, String telefono, Integer idReservas, Integer id) {
		try {
			final PreparedStatement statement = con.prepareStatement("UPDATE HUESPEDES SET "
					+ " nombre = ?, "
					+ " apellido = ?, "
					+ " fecha_de_nacimiento = ?, "
					+ " nacionalidad = ?, "
					+ " telefono = ?, "
					+ " reserva_id = ?"
					+ " WHERE ID = ?");
			try(statement){
				statement.setString(1, nombre);
				statement.setString(2, apellido);
				statement.setDate(3, fechaNacimiento);
				statement.setString(4, nacionalidad);
				statement.setString(5, telefono);
				statement.setInt(6, idReservas);
				statement.setInt(7, id);
				statement.execute();
			}
		} catch (SQLException e) {
			throw new RuntimeException (e);
		}
	}
}
