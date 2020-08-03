package br.com.trendcode.stm;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.trendcode.stm.model.enums.Perfil;
import br.com.trendcode.stm.repository.PerfilRepository;

class PerfilRepositoryTest {

	PerfilRepository perfilRepository = null;
	
	@BeforeEach
	void setUp() throws Exception {
		perfilRepository = new PerfilRepository();
	}
	
	@Test
	void testCreate() {
		perfilRepository.create(Perfil.ADMIN);
		perfilRepository.create(Perfil.FORNECEDOR);
		perfilRepository.create(Perfil.FUNCIONARIO);
		perfilRepository.create(Perfil.CLIENTE);
	}	
}