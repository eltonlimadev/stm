package br.com.trendcode.stm;

import static org.mockito.Mockito.validateMockitoUsage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.trendcode.stm.model.Usuario;
import br.com.trendcode.stm.repository.UsuarioRepository;

class UsuarioRepositoryTest {

	UsuarioRepository usuarioRepository = null;
	
	@BeforeEach
	void setUp() throws Exception {
		usuarioRepository = new UsuarioRepository();
	}
	
	@Test
	void testCreate() {
		Usuario usuario = new Usuario();
		usuario.setNome("Elton Gomes da Silva Lima");
		usuario.setCpf("09294567427");
		usuario.setTelefone("83 9 8111-2982");
		usuario.setEmail("eltonlima.dev@hotmail.com");
		usuario.setSenha("1010");
		usuarioRepository.create(usuario);
	}

	void testFindByCpf() {
		Usuario usuario = usuarioRepository.findByCpf("09294567427");
		System.out.println("Nome: "+ usuario.getNome());
	}
	
	void testReadAll() {
		for(Usuario usuario : usuarioRepository.readAll()) {
			System.out.println("Nome: "+usuario.getNome() +", CPF: "+ usuario.getCpf());
		}
	}
	
	void testUpdate() {
		Usuario usuario = new Usuario();
		usuario.setCodigo(1);
		usuario.setNome("Elton Gomes da Silva Lima");
		usuario.setCpf("09294567427");
		usuario.setTelefone("83 9 8111-2982");
		usuario.setEmail("eltonlima.dev@hotmail.com");
		usuario.setSenha("1010");
		usuarioRepository.update(usuario);
	}
	
	void testDelete() {
		Usuario usuario = new Usuario();
		usuario.setCodigo(1);
		usuarioRepository.delete(usuario);
	}
}
