package br.com.trendcode.stm.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionFactory {

	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/stm?useTimezone=true&serverTimezone=UTC";
	private static final String USER = "dev";
	private static final String PASSWORD = "dev";
	
	public static Connection getConnection() {
		
		try {
			
			Class.forName(DRIVER);
			return DriverManager.getConnection(URL, USER, PASSWORD);
			
		} catch (SQLException | ClassNotFoundException e) {
			
			throw new RuntimeException("Erro na Conexão.", e);
		}
	}
	
	public static void closeConnection(Connection connection) {
		
		if(connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				System.err.println("Erro no Fechamento da Conexão: " + e);
			}
		}
	}
	
	public static void closeConnection(Connection connection, PreparedStatement statement) {
		
		if(statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				System.err.println("Erro no Fechamento da Conexão: " + e);
			}
		}
		closeConnection(connection);
	}
	
	public static void closeConnection(Connection connection, PreparedStatement statement, ResultSet resultSet) {
		
		if(resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				System.err.println("Erro no Fechamento da Conexão: " + e);
			}
			closeConnection(connection, statement);
		}
	}
}

