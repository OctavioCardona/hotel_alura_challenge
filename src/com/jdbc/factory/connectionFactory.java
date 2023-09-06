package com.jdbc.factory;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class connectionFactory {
	
	private DataSource datasource;
	
	public connectionFactory(){
		ComboPooledDataSource pooledDataSource = new ComboPooledDataSource(); 
		pooledDataSource.setJdbcUrl("jdbc:mysql://localhost/hotel_alura?useTimeZone=UTC");
		pooledDataSource.setUser("root");
		pooledDataSource.setPassword("270300");
		pooledDataSource.setMaxPoolSize(10);
		
		this.datasource = pooledDataSource;
	}
	public Connection recuperarConexion() {
		
		try {
			return this.datasource.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

}
