package br.com.trendcode.stm;

import org.junit.jupiter.api.BeforeEach;
import br.com.trendcode.stm.model.Empresa;
import br.com.trendcode.stm.repository.EmpresaRepository;

class EmpresaRepositoryTest {

	EmpresaRepository empresaRepository = null;
	
	@BeforeEach
	void setUp() throws Exception {
		empresaRepository = new EmpresaRepository();
	}

	void testCreate() {
		
		Empresa empresa = new Empresa();
		empresa.setNome("TrendCode");
		empresa.setRazaoSocial("Trendcode Systems LTDA");
		empresa.setCnpj("098987546000110");
		empresa.setInscricaoEstadual("365637687");
		empresa.setInscricaoMunicipal("9833259758");
		
		Empresa empresa1 = new Empresa();
		empresa1.setNome("Locavel");
		empresa1.setRazaoSocial("Locavel Serviços LTDA");
		empresa1.setCnpj("098987562300198");
		empresa1.setInscricaoEstadual("361127689");
		empresa1.setInscricaoMunicipal("0833259654");
		
		empresaRepository.create(empresa);
	}

	void testFindByCnpj() {
		
		Empresa empresa = empresaRepository.findByCnpj("098987546000110");
		System.out.println("Razão Social: "+ empresa.getRazaoSocial());
	}
	
	void testReadAll() {
		for(Empresa empresa : empresaRepository.readAll()) {
			System.out.println("Empresa: "+empresa.getRazaoSocial() +" CNPJ: "+ empresa.getCnpj());
		}
	}

	void testUpdate() {
		
		Empresa empresa = new Empresa();
		empresa.setCodigo(1);
		empresa.setNome("TrendCode Systems");
		empresa.setRazaoSocial("TrendCode Systems LTDA");
		empresa.setCnpj("098987546000110");
		empresa.setInscricaoEstadual("365637687");
		empresa.setInscricaoMunicipal("9833259758");
		
	}

	void testDelete() {
		
		Empresa empresa = new Empresa();
		empresa.setCodigo(1);
		
	}
}
