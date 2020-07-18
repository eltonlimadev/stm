package br.com.trendcode.stm.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.trendcode.stm.connection.ConnectioFactory;
import br.com.trendcode.stm.model.Empresa;
import br.com.trendcode.stm.model.Veiculo;

public class VeiculoRepository {

	private Connection connection = null;
	
	public VeiculoRepository() {
		
		connection = ConnectioFactory.getConnection();
	}
	
	public boolean create (Veiculo veiculo) {
		
		connection = ConnectioFactory.getConnection();
		
		String sql = "INSERT INTO TB_VEICULO (placa,marca,ano,modelo,cor,chassi,renavam,combustivel,odometro,situacao,estatus,proprietario)"
				     + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
		
		PreparedStatement statement = null;
		
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, veiculo.getPlaca());
			statement.setString(2, veiculo.getMarca());
			statement.setInt(3, veiculo.getAno());
			statement.setString(4, veiculo.getModelo());
			statement.setString(5, veiculo.getCor());
			statement.setString(6, veiculo.getChassi());
			statement.setString(7, veiculo.getRenavam());
			statement.setString(8, veiculo.getCombustivel());
			statement.setDouble(9, veiculo.getOdometro());
			statement.setString(10, veiculo.getSituacao());
			statement.setString(11, veiculo.getStatus());
			statement.setLong(12, veiculo.getProprietario().getCodigo());
			statement.executeUpdate();
			
			return true;
			
		} catch (SQLException e) {
			System.err.println("Erro ao Salvar Veiculo.: " + e);
			
			return false;
		}finally {
			ConnectioFactory.closeConnection(connection, statement);
		}
	}
	
	public Veiculo findByCodigo(Long codigo) {
		
		connection = ConnectioFactory.getConnection();
		
		String sql = "select * from TB_VEICULO veiculo inner join TB_EMPRESA empresa on empresa.codigo = veiculo.proprietario where veiculo.codigo=?";
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		Veiculo veiculo = new Veiculo();
		
		try {
			statement = connection.prepareStatement(sql);
			statement.setLong(1, codigo);
			resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
				
				veiculo.setCodigo(resultSet.getLong("codigo"));
				veiculo.setPlaca(resultSet.getString("placa"));
				veiculo.setMarca(resultSet.getString("marca"));
				veiculo.setAno(resultSet.getInt("ano"));
				veiculo.setModelo(resultSet.getString("modelo"));
				veiculo.setCor(resultSet.getString("cor"));
				veiculo.setChassi(resultSet.getString("chassi"));
				veiculo.setRenavam(resultSet.getString("renavam"));
				veiculo.setCombustivel(resultSet.getString("combustivel"));
				veiculo.setOdometro(resultSet.getDouble("odometro"));
				veiculo.setSituacao(resultSet.getString("situacao"));
				veiculo.setStatus(resultSet.getString("estatus"));
				
				Empresa empresa = new Empresa();
				empresa.setCodigo(resultSet.getLong(13));
				empresa.setRazaoSocial(resultSet.getString("razaoSocial"));
				empresa.setNome(resultSet.getString("nome"));
				empresa.setCnpj(resultSet.getString("cnpj"));
				empresa.setInscricaoEstadual(resultSet.getString("inscricaoEstadual"));
				empresa.setInscricaoMunicipal(resultSet.getString("inscricaoMunicipal"));
				
				veiculo.setProprietario(empresa);
			}	
				
		} catch (SQLException e) {
			System.err.println("Erro ao Ler Registro no Banco de Dados.: " + e);
			
		}finally {
			ConnectioFactory.closeConnection(connection, statement, resultSet);
		}
		
		return veiculo;
	}
	
	public Veiculo findByPlaca(String placa) {
		
		connection = ConnectioFactory.getConnection();
		
		String sql = "select * from TB_VEICULO veiculo inner join TB_EMPRESA empresa on empresa.codigo = veiculo.proprietario where veiculo.placa=?";
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		Veiculo veiculo = new Veiculo();
		
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, placa);
			resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
				
				veiculo.setCodigo(resultSet.getLong("codigo"));
				veiculo.setPlaca(resultSet.getString("placa"));
				veiculo.setMarca(resultSet.getString("marca"));
				veiculo.setAno(resultSet.getInt("ano"));
				veiculo.setModelo(resultSet.getString("modelo"));
				veiculo.setCor(resultSet.getString("cor"));
				veiculo.setChassi(resultSet.getString("chassi"));
				veiculo.setRenavam(resultSet.getString("renavam"));
				veiculo.setCombustivel(resultSet.getString("combustivel"));
				veiculo.setOdometro(resultSet.getDouble("odometro"));
				veiculo.setSituacao(resultSet.getString("situacao"));
				veiculo.setStatus(resultSet.getString("estatus"));
				
				Empresa empresa = new Empresa();
				empresa.setCodigo(resultSet.getLong(13));
				empresa.setRazaoSocial(resultSet.getString("razaoSocial"));
				empresa.setNome(resultSet.getString("nome"));
				empresa.setCnpj(resultSet.getString("cnpj"));
				empresa.setInscricaoEstadual(resultSet.getString("inscricaoEstadual"));
				empresa.setInscricaoMunicipal(resultSet.getString("inscricaoMunicipal"));
				
				veiculo.setProprietario(empresa);
			}	
				
		} catch (SQLException e) {
			System.err.println("Erro ao Ler Registro no Banco de Dados.: " + e);
			
		}finally {
			ConnectioFactory.closeConnection(connection, statement, resultSet);
		}
		
		return veiculo;
	}
	
	public List<Veiculo> readAll(){
		
		connection = ConnectioFactory.getConnection();
		
		String sql = "select * from TB_VEICULO veiculo inner join TB_EMPRESA empresa on empresa.codigo = veiculo.proprietario";
		
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		List<Veiculo> veiculos = new ArrayList<Veiculo>();
		
		try {
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
				
				Veiculo veiculo = new Veiculo();
				veiculo.setCodigo(resultSet.getLong("codigo"));
				veiculo.setPlaca(resultSet.getString("placa"));
				veiculo.setMarca(resultSet.getString("marca"));
				veiculo.setAno(resultSet.getInt("ano"));
				veiculo.setModelo(resultSet.getString("modelo"));
				veiculo.setCor(resultSet.getString("cor"));
				veiculo.setChassi(resultSet.getString("chassi"));
				veiculo.setRenavam(resultSet.getString("renavam"));
				veiculo.setCombustivel(resultSet.getString("combustivel"));
				veiculo.setOdometro(resultSet.getDouble("odometro"));
				veiculo.setSituacao(resultSet.getString("situacao"));
				veiculo.setStatus(resultSet.getString("estatus"));
				
				Empresa empresa = new Empresa();
				empresa.setCodigo(resultSet.getLong(13));
				empresa.setRazaoSocial(resultSet.getString("razaoSocial"));
				empresa.setNome(resultSet.getString("nome"));
				empresa.setCnpj(resultSet.getString("cnpj"));
				empresa.setInscricaoEstadual(resultSet.getString("inscricaoEstadual"));
				empresa.setInscricaoMunicipal(resultSet.getString("inscricaoMunicipal"));
				
				veiculo.setProprietario(empresa);
				
				veiculos.add(veiculo);
			}
			
		} catch (SQLException e) {
			System.err.println("Erro ao Ler Registros no Banco de Dados.: " + e);
			
		}finally {
			ConnectioFactory.closeConnection(connection, statement, resultSet);
		}
		
		return veiculos;
	}
	
	public boolean update(Veiculo veiculo) {

		connection = ConnectioFactory.getConnection();
		
		String sql = "UPDATE TB_VEICULO SET placa=?,marca=?,ano=?,modelo=?,cor=?,chassi=?,renavam=?,combustivel=?,odometro=?,situacao=?,estatus=?,proprietario=? "
				+ "WHERE codigo=?";

		PreparedStatement statement = null;

		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, veiculo.getPlaca());
			statement.setString(2, veiculo.getMarca());
			statement.setInt(3, veiculo.getAno());
			statement.setString(4, veiculo.getModelo());
			statement.setString(5, veiculo.getCor());
			statement.setString(6, veiculo.getChassi());
			statement.setString(7, veiculo.getRenavam());
			statement.setString(8, veiculo.getCombustivel());
			statement.setDouble(9, veiculo.getOdometro());
			statement.setString(10, veiculo.getSituacao());
			statement.setString(11, veiculo.getStatus());
			statement.setLong(12, veiculo.getProprietario().getCodigo());
			statement.setLong(13, veiculo.getCodigo());
			statement.executeUpdate();

			return true;

		} catch (SQLException e) {
			System.err.println("Erro ao Atualizar Dados Veiculo.: " + e);
			return false;
			
		} finally {
			ConnectioFactory.closeConnection(connection, statement);
		}
	}
	
	public boolean delete(Veiculo veiculo) {
		
		connection = ConnectioFactory.getConnection();
		
		String sql = "DELETE FROM TB_VEICULO WHERE codigo=?";
		PreparedStatement statement = null;
		
		try {
			statement = connection.prepareStatement(sql);
			statement.setLong(1, veiculo.getCodigo());
			statement.executeUpdate();
			
			return true;
			
		} catch (SQLException e) {
			System.err.println("Erro ao Deletar Veiculo.: " + e);		
			return false;
			
		}finally {
			ConnectioFactory.closeConnection(connection, statement);
		}
	}
}
