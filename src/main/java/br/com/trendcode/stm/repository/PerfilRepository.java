package br.com.trendcode.stm.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import br.com.trendcode.stm.connection.ConnectionFactory;
import br.com.trendcode.stm.model.enums.Perfil;

public class PerfilRepository {

	private Connection connection;

	public PerfilRepository() {
		connection = ConnectionFactory.getConnection();
	}

	public boolean create(Perfil perfil) {

		connection = ConnectionFactory.getConnection();

		String sql = "INSERT INTO TB_PERFIL (codigo, descricao) VALUES (?,?)";
		PreparedStatement statement = null;

		try {
			statement = connection.prepareStatement(sql);
			statement.setInt(1, perfil.getCodigo());
			statement.setString(2, perfil.getDescricao());
			statement.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.err.println("Erro ao Salvar Perfil na Base de Dados.: " + e);
			return false;

		} finally {
			ConnectionFactory.closeConnection(connection, statement);
		}
	}

}
