package br.com.trendcode.stm.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.trendcode.stm.connection.ConnectionFactory;
import br.com.trendcode.stm.model.Usuario;

public class UsuarioRepository {

	private Connection connection = null;
	
	public UsuarioRepository() {
		connection = ConnectionFactory.getConnection();
	}
	
	public boolean create (Usuario usuario) {
		
		connection = ConnectionFactory.getConnection();
		
		String sql = "INSERT INTO TB_USUARIO (nome,cpf,telefone,email,senha) VALUES (?,?,?,?,?)";
		PreparedStatement statement = null;
		
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, usuario.getNome());
			statement.setString(2, usuario.getCpf());
			statement.setString(3, usuario.getTelefone());
			statement.setString(4, usuario.getEmail());
			statement.setString(5, usuario.getSenha());
			statement.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.err.println("Erro ao Salvar Usuário.: " + e);
			return false;
			
		}finally {
			ConnectionFactory.closeConnection(connection, statement);
		}
	}
	
	public Usuario findByCodigo(Long codigo) {
		
		connection = ConnectionFactory.getConnection();
		
		String sql = "SELECT * FROM TB_USUARIO WHERE codigo=?";
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		Usuario usuario = new Usuario();
		
		try {
			statement = connection.prepareStatement(sql);
			statement.setLong(1, codigo);
			resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
				usuario.setCodigo(resultSet.getLong("codigo"));
				usuario.setNome(resultSet.getString("nome"));
				usuario.setCpf(resultSet.getString("cpf"));
				usuario.setTelefone(resultSet.getString("telefone"));
				usuario.setEmail(resultSet.getString("email"));
				usuario.setSenha(resultSet.getString("senha"));
			}
			
		} catch (SQLException e) {
			System.err.println("Erro ao Ler Registro no Banco de Dados.: " + e);
			
		}finally {
			ConnectionFactory.closeConnection(connection, statement, resultSet);
		}
		return usuario;
	}
	
	public Usuario findByCpf(String cpf) {
			
			connection = ConnectionFactory.getConnection();
			
			String sql = "SELECT * FROM TB_USUARIO WHERE cpf=?";
			PreparedStatement statement = null;
			ResultSet resultSet = null;
			
			Usuario usuario = new Usuario();
			
			try {
				statement = connection.prepareStatement(sql);
				statement.setString(1, cpf);
				resultSet = statement.executeQuery();
				
				while(resultSet.next()) {
					usuario.setCodigo(resultSet.getLong("codigo"));
					usuario.setNome(resultSet.getString("nome"));
					usuario.setCpf(resultSet.getString("cpf"));
					usuario.setTelefone(resultSet.getString("telefone"));
					usuario.setEmail(resultSet.getString("email"));
					usuario.setSenha(resultSet.getString("senha"));
				}
				
			} catch (SQLException e) {
				System.err.println("Erro ao Ler Registro no Banco de Dados.: " + e);
				
			}finally {
				ConnectionFactory.closeConnection(connection, statement, resultSet);
			}
			return usuario;
		}
	
	public List<Usuario> readAll() {

		connection = ConnectionFactory.getConnection();
		
		String sql = "SELECT * FROM TB_USUARIO";
		
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		List<Usuario> usuarios = new ArrayList<>();
		
		try {
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
				
				Usuario usuario = new Usuario();
				usuario.setCodigo(resultSet.getLong("codigo"));
				usuario.setNome(resultSet.getString("nome"));
				usuario.setCpf(resultSet.getString("cpf"));
				usuario.setTelefone(resultSet.getString("telefone"));
				usuario.setEmail(resultSet.getString("email"));
				usuario.setSenha(resultSet.getString("senha"));
				
				usuarios.add(usuario);
			}
			
		} catch (SQLException e) {
			System.err.println("Erro ao Ler Registros no Banco de Dados.: " + e);
			
		}finally {
			ConnectionFactory.closeConnection(connection, statement, resultSet);
		}
		
		return usuarios;
	}
	
	public boolean update(Usuario usuario) {
		
		connection = ConnectionFactory.getConnection();
		
		String sql = "UPDATE TB_USUARIO SET nome=?,cpf=?,telefone=?,email=?,senha=? WHERE codigo=?";
		PreparedStatement statement = null;
		
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, usuario.getNome());
			statement.setString(2, usuario.getCpf());
			statement.setString(3, usuario.getTelefone());
			statement.setString(4, usuario.getEmail());
			statement.setString(5, usuario.getSenha());
			statement.setLong(6, usuario.getCodigo());
			statement.executeUpdate();
			return true;
			
		} catch (SQLException e) {
			System.err.println("Erro ao Atualizar Usuário.: " + e);
			return false;
			
		}finally {
			ConnectionFactory.closeConnection(connection, statement);
		}
	}
	
	public boolean delete (Usuario usuario) {
		
		connection = ConnectionFactory.getConnection();
		
		String sql = "DELETE FROM TB_USUARIO WHERE codigo=?";
		PreparedStatement statement = null;
		
		try {
			statement = connection.prepareStatement(sql);
			statement.setLong(1, usuario.getCodigo());
			statement.executeUpdate();
			return true;
			
		} catch (SQLException e) {
			System.err.println("Erro ao Deletar Registro de Usuário.: " + e);
			return false;
			
		}finally {
			ConnectionFactory.closeConnection(connection, statement);
		}	
	}
}
