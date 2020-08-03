package br.com.trendcode.stm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.trendcode.stm.model.Usuario;
import br.com.trendcode.stm.service.UsuarioService;

@RestController
@RequestMapping(value="/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert (@RequestBody Usuario usuario){
		usuarioService.salvar(usuario);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{cpf}", method = RequestMethod.GET)
	public ResponseEntity<Usuario> findByCpf (@PathVariable String cpf){
		Usuario usuario = usuarioService.buscarPorCpf(cpf);
		return ResponseEntity.ok().body(usuario);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Usuario>> findAll (){
		List<Usuario> usuarios = usuarioService.buscarTodos();
		return ResponseEntity.ok().body(usuarios);
	}
	
	@RequestMapping(value = "/{codigo}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update (@RequestBody Usuario usuario, @PathVariable Long codigo){
		usuario.setCodigo(codigo);
		usuarioService.editar(usuario);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{codigo}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete (@PathVariable Long codigo){
		Usuario usuario = new Usuario();
		usuario.setCodigo(codigo);
		usuarioService.excluir(usuario);
		return ResponseEntity.noContent().build();
	}
}
