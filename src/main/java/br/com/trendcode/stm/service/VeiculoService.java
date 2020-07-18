package br.com.trendcode.stm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.trendcode.stm.model.Empresa;
import br.com.trendcode.stm.model.Veiculo;
import br.com.trendcode.stm.repository.VeiculoRepository;
import br.com.trendcode.stm.service.exceptions.ObjectNotFoundException;

@Service
public class VeiculoService {

	VeiculoRepository veiculoRepository = null;
	
	public VeiculoService() {
		veiculoRepository = new VeiculoRepository();
	}
	
	public void salvar(Veiculo veiculo) {
		veiculoRepository.create(veiculo);
	}
	
	public Veiculo buscarPorCodigo(Long codigo) {
		Veiculo veiculo = veiculoRepository.findByCodigo(codigo);
		
		if(veiculo.getCodigo() == 0) {
			throw new ObjectNotFoundException("Objeto Não Encontrado! CNPJ: " + codigo
					+ ", Tipo: " + Empresa.class.getName());
		}
		return veiculo;
	}
	
	public Veiculo buscarPorPlaca(String placa) {
		Veiculo veiculo = veiculoRepository.findByPlaca(placa);
		
		if(veiculo.getCodigo() == 0) {
			throw new ObjectNotFoundException(("Objeto Não Encontrado! Placa: " + placa
					+ ", Tipo: " + Veiculo.class.getName()));
		}
		return veiculo;
	}
	
	public List<Veiculo> buscarTodos() {
		List<Veiculo> veiculos = veiculoRepository.readAll();
		return veiculos;
	}
	
	public void editar(Veiculo veiculo) {
		buscarPorCodigo(veiculo.getCodigo());
		veiculoRepository.update(veiculo);
	}
	
	public void excluir(Veiculo veiculo) {
		buscarPorCodigo(veiculo.getCodigo());
		veiculoRepository.delete(veiculo);
	}
}
