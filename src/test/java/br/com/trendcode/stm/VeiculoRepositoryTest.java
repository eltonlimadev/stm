package br.com.trendcode.stm;

import org.junit.jupiter.api.BeforeEach;
import br.com.trendcode.stm.model.Empresa;
import br.com.trendcode.stm.model.Veiculo;
import br.com.trendcode.stm.repository.VeiculoRepository;

class VeiculoRepositoryTest {

	VeiculoRepository veiculoRepository = null;
	
	@BeforeEach
	void setUp() throws Exception {
		veiculoRepository = new VeiculoRepository();
	}

	void testCreate() {
		
		Empresa proprietario = new Empresa();
		proprietario.setCodigo(3);
		
		Veiculo veiculo = new Veiculo();
		veiculo.setPlaca("JFH-2059");
		veiculo.setMarca("Chevrolet");
		veiculo.setAno(1999);
		veiculo.setModelo("Corsa Hatch 4P");
		veiculo.setCor("Prata");
		veiculo.setChassi("JH53446GFR876678");
		veiculo.setRenavam("846640985");
		veiculo.setCombustivel("Gasolina");
		veiculo.setOdometro(200.000);
		veiculo.setSituacao("Desmobilizado");
		veiculo.setStatus("Vendido");
		veiculo.setProprietario(proprietario);
		
		veiculoRepository.create(veiculo);
	}

	void testFindByCnpj() {
		Veiculo veiculo = veiculoRepository.findByPlaca("JFH-2059");
		System.out.println("Modelo: "+ veiculo.getModelo());
	}
	
	void testReadAll() {
		
		for (Veiculo veiculo : veiculoRepository.readAll()) {
			System.out.println("Veículo: " + veiculo.getPlaca() + " Proprietário: " + veiculo.getProprietario().getRazaoSocial());
		}
	}
	
	void testUpdate() {
		
		Empresa proprietario = new Empresa();
		proprietario.setCodigo(1);
		
		Veiculo veiculo = new Veiculo();
		veiculo.setCodigo(2);
		veiculo.setPlaca("OYR-7717");
		veiculo.setMarca("Volkswagen");
		veiculo.setAno(1999);
		veiculo.setModelo("Gol G5 4P");
		veiculo.setCor("Branco");
		veiculo.setChassi("JH53446GFR876678");
		veiculo.setRenavam("846640985");
		veiculo.setCombustivel("Gasolina");
		veiculo.setOdometro(200.000);
		veiculo.setSituacao("Desmobilizado");
		veiculo.setStatus("Vendido");
		veiculo.setProprietario(proprietario);
		
		veiculoRepository.update(veiculo);
	}
	
	void testDelete() {
		
		Veiculo veiculo = new Veiculo();
		veiculo.setCodigo(2);
		
		veiculoRepository.delete(veiculo);
	}
}
