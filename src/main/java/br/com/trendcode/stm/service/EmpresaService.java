package br.com.trendcode.stm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.trendcode.stm.model.Empresa;
import br.com.trendcode.stm.repository.EmpresaRepository;
import br.com.trendcode.stm.service.exceptions.ObjectNotFoundException;

@Service
public class EmpresaService {

	EmpresaRepository empresaRepository = null;
	
	public EmpresaService() {
		empresaRepository = new EmpresaRepository();
	}
	
	public void salvar (Empresa empresa) {
		empresaRepository.create(empresa);
	}
	
	public Empresa buscarPorCodigo(Long codigo) {
		Empresa empresa = empresaRepository.findByCodigo(codigo);
		
		if(empresa.getCodigo() == 0) {
			throw new ObjectNotFoundException("Objeto Não Encontrado! CNPJ: " + codigo
					+ ", Tipo: " + Empresa.class.getName());
		}
		return empresa;
	}
	
	public Empresa buscarPorCnpj(String cnpj) {
		Empresa empresa = empresaRepository.findByCnpj(cnpj);
		
		if(empresa.getCodigo() == 0) {
			throw new ObjectNotFoundException("Objeto Não Encontrado! CNPJ: " + cnpj
					+ ", Tipo: " + Empresa.class.getName());
		}
		
		return empresa;
	}
	
	public List<Empresa> buscarTodos(){
		List<Empresa> empresas = empresaRepository.readAll();
		return empresas;
	}
	
	public void editar(Empresa empresa) {
		buscarPorCodigo(empresa.getCodigo());
		empresaRepository.update(empresa);
	}
	
	public void excluir(Empresa empresa) {
		buscarPorCodigo(empresa.getCodigo());
		empresaRepository.delete(empresa);
	}
}
