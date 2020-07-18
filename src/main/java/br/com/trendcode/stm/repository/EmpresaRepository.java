package br.com.trendcode.stm.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.trendcode.stm.connection.ConnectioFactory;
import br.com.trendcode.stm.model.Empresa;

public class EmpresaRepository {

	private Connection connection = null;

	public EmpresaRepository() {

		connection = ConnectioFactory.getConnection();
	}

	public boolean create(Empresa empresa) {

		connection = ConnectioFactory.getConnection();
		
		String sql = "INSERT INTO TB_EMPRESA (razaoSocial,nome,cnpj,inscricaoEstadual,inscricaoMunicipal) VALUES (?,?,?,?,?)";
		PreparedStatement statement = null;

		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, empresa.getRazaoSocial());
			statement.setString(2, empresa.getNome());
			statement.setString(3, empresa.getCnpj());
			statement.setString(4, empresa.getInscricaoEstadual());
			statement.setString(5, empresa.getInscricaoMunicipal());
			statement.executeUpdate();
			return true;

		} catch (SQLException e) {
			System.err.println("Erro ao Salvar Empresa.: " + e);
			return false;

		} finally {
			ConnectioFactory.closeConnection(connection, statement);
		}
	}
	
	public Empresa findByCodigo(Long codigo) {
		
		connection = ConnectioFactory.getConnection();
		
		String sql = "SELECT * FROM TB_EMPRESA WHERE codigo=?";
		
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		Empresa empresa = new Empresa();
		
		try {
			statement = connection.prepareStatement(sql);
			statement.setLong(1, codigo);
			resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
				empresa.setCodigo(resultSet.getLong("codigo"));
				empresa.setRazaoSocial(resultSet.getString("razaoSocial"));
				empresa.setNome(resultSet.getString("nome"));
				empresa.setCnpj(resultSet.getString("cnpj"));
				empresa.setInscricaoEstadual(resultSet.getString("inscricaoEstadual"));
				empresa.setInscricaoMunicipal(resultSet.getString("inscricaoMunicipal"));
			}
			
		} catch (SQLException e) {
			System.err.println("Erro ao Ler Registro no Banco de Dados.: " + e);
			
		}finally {
			ConnectioFactory.closeConnection(connection, statement, resultSet);
		}
		
		return empresa;
	}
	
	public Empresa findByCnpj(String cnpj) {
		
		connection = ConnectioFactory.getConnection();
		
		String sql = "SELECT * FROM TB_EMPRESA WHERE cnpj=?";
		
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		Empresa empresa = new Empresa();
		
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, cnpj);
			resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
				empresa.setCodigo(resultSet.getLong("codigo"));
				empresa.setRazaoSocial(resultSet.getString("razaoSocial"));
				empresa.setNome(resultSet.getString("nome"));
				empresa.setCnpj(resultSet.getString("cnpj"));
				empresa.setInscricaoEstadual(resultSet.getString("inscricaoEstadual"));
				empresa.setInscricaoMunicipal(resultSet.getString("inscricaoMunicipal"));
			}
			
		} catch (SQLException e) {
			System.err.println("Erro ao Ler Registro no Banco de Dados.: " + e);
			
		}finally {
			ConnectioFactory.closeConnection(connection, statement, resultSet);
		}
		
		return empresa;
	}

	public List<Empresa> readAll() {

		connection = ConnectioFactory.getConnection();
		
		String sql = "SELECT * FROM TB_EMPRESA";
		
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		List<Empresa> empresas = new ArrayList<>();
		
		try {
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
				
				Empresa empresa = new Empresa();
				empresa.setCodigo(resultSet.getLong("codigo"));
				empresa.setRazaoSocial(resultSet.getString("razaoSocial"));
				empresa.setNome(resultSet.getString("nome"));
				empresa.setCnpj(resultSet.getString("cnpj"));
				empresa.setInscricaoEstadual(resultSet.getString("inscricaoEstadual"));
				empresa.setInscricaoMunicipal(resultSet.getString("inscricaoMunicipal"));
				
				empresas.add(empresa);
			}
			
		} catch (SQLException e) {
			System.err.println("Erro ao Ler Registros no Banco de Dados.: " + e);
			
		}finally {
			ConnectioFactory.closeConnection(connection, statement, resultSet);
		}
		
		return empresas;
	}
	
	public boolean update(Empresa empresa) {

		connection = ConnectioFactory.getConnection();
		
		String sql = "UPDATE TB_EMPRESA SET razaoSocial=?,nome=?,cnpj=?,inscricaoEstadual=?,inscricaoMunicipal=? WHERE codigo=?";
		PreparedStatement statement = null;

		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, empresa.getRazaoSocial());
			statement.setString(2, empresa.getNome());
			statement.setString(3, empresa.getCnpj());
			statement.setString(4, empresa.getInscricaoEstadual());
			statement.setString(5, empresa.getInscricaoMunicipal());
			statement.setLong(6, empresa.getCodigo());
			statement.executeUpdate();
			return true;

		} catch (SQLException e) {
			System.err.println("Erro ao Atualizar Empresa.: " + e);
			return false;

		} finally {
			ConnectioFactory.closeConnection(connection, statement);
		}
	}

	public boolean delete(Empresa empresa) {

		connection = ConnectioFactory.getConnection();
		
		String sql = "DELETE FROM TB_EMPRESA WHERE codigo=?";
		PreparedStatement statement = null;

		try {
			statement = connection.prepareStatement(sql);
			statement.setLong(1, empresa.getCodigo());
			statement.executeUpdate();
			return true;

		} catch (SQLException e) {
			System.err.println("Erro ao Deletar Registro Empresa.: " + e);
			return false;

		} finally {
			ConnectioFactory.closeConnection(connection, statement);
		}
	}
}
