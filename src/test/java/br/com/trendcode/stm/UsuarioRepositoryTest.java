package br.com.trendcode.stm;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.com.trendcode.stm.model.Usuario;
import br.com.trendcode.stm.model.enums.Perfil;
import br.com.trendcode.stm.repository.UsuarioRepository;

class UsuarioRepositoryTest {

	UsuarioRepository usuarioRepository = null;
	private BCryptPasswordEncoder passwordEncoder = null;

	
	@BeforeEach
	void setUp() throws Exception {
		usuarioRepository = new UsuarioRepository();
		passwordEncoder = new BCryptPasswordEncoder();
	}
	
	void testCreate() {
		Usuario usuario = new Usuario();
		usuario.setNome("Cliente");
		usuario.setCpf("12345678910");
		usuario.setTelefone("83 9 8111-2982");
		usuario.setEmail("cliente@hotmail.com");
		usuario.setSenha(passwordEncoder.encode("2020"));
		usuario.setPerfil(Perfil.CLIENTE);
		usuarioRepository.create(usuario);
	}
	
	@Test
	void testCreateCrypted() {
		Usuario usuario = new Usuario();
		usuario.setNome("Funcionario");
		usuario.setCpf("99999999911");
		usuario.setTelefone("83988789138");
		usuario.setEmail(("funcionario@hotmail.com"));
		usuario.setSenha(passwordEncoder.encode("3030"));
		usuario.setPerfil(Perfil.FUNCIONARIO);
		usuarioRepository.create(usuario);
	}

	void testFindByCpf() {
		Usuario usuario = usuarioRepository.findByCpf("09294567427");
		System.out.println("Nome: "+ usuario.getNome() +" - Perfil: " + usuario.getPerfil());
	}
	
	
	void testReadAll() {
		for(Usuario usuario : usuarioRepository.readAll()) {
			System.out.println("Nome: "+usuario.getNome() +", CPF: "+ usuario.getCpf() + " - Perfil: " + usuario.getPerfil());
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
		usuario.setPerfil(Perfil.ADMIN);
		usuarioRepository.update(usuario);
	}
	
	void testDelete() {
		Usuario usuario = new Usuario();
		usuario.setCodigo(6);
		usuarioRepository.delete(usuario);
	}
}
