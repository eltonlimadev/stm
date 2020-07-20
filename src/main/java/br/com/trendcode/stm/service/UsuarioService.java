package br.com.trendcode.stm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.trendcode.stm.model.Usuario;
import br.com.trendcode.stm.repository.UsuarioRepository;
import br.com.trendcode.stm.service.exceptions.ObjectNotFoundException;

@Service
public class UsuarioService {

	UsuarioRepository usuarioRepository = null;
	
	public UsuarioService () {
		usuarioRepository = new UsuarioRepository();
	}
	
	public void salvar(Usuario usuario) {
		usuarioRepository.create(usuario);
	}
	
	public Usuario buscarPorCodigo (Long codigo) {
		Usuario usuario = usuarioRepository.findByCodigo(codigo);
		if(usuario.getCodigo()==0) {
			throw new ObjectNotFoundException("Objeto Não Encontrado! Código: " + codigo
					+ ", Tipo: " + Usuario.class.getName());
		}
		return usuario;
	}
	
	public Usuario buscarPorCpf (String cpf) {
		Usuario usuario = usuarioRepository.findByCpf(cpf);
		if(usuario.getCodigo()==0) {
			throw new ObjectNotFoundException("Objeto Não Encontrado! Código: " + cpf
					+ ", Tipo: " + Usuario.class.getName());
		}
		return usuario;
	}
	
	public List<Usuario> buscarTodos (){
		List<Usuario> usuarios = usuarioRepository.readAll();
		return usuarios;
	}
	
	public void editar (Usuario usuario) {
		buscarPorCodigo(usuario.getCodigo());
		usuarioRepository.update(usuario);
	}
	
	public void excluir (Usuario usuario) {
		buscarPorCodigo(usuario.getCodigo());
		usuarioRepository.delete(usuario);
	}
}
