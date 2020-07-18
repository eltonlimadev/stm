package br.com.trendcode.stm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import br.com.trendcode.stm.model.Empresa;
import br.com.trendcode.stm.service.EmpresaService;

@RestController
@RequestMapping(value="/empresas")
public class EmpresaController {

	@Autowired
	private EmpresaService empresaService;
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Empresa empresa){
		empresaService.salvar(empresa);
		return ResponseEntity.noContent().build();
	}
		
	@RequestMapping(value="/{cnpj}", method = RequestMethod.GET)
	public ResponseEntity<Empresa> findByCnpj(@PathVariable String cnpj){
		Empresa empresa = empresaService.buscarPorCnpj(cnpj);
		return ResponseEntity.ok().body(empresa);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Empresa>> findAll() {
		List<Empresa> empresas = empresaService.buscarTodos();
		return ResponseEntity.ok().body(empresas);
	}
	
	@RequestMapping(value="/{codigo}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Empresa empresa, @PathVariable Long codigo){
		empresa.setCodigo(codigo);
		empresaService.editar(empresa);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{codigo}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Long codigo){
		Empresa empresa = new Empresa();
		empresa.setCodigo(codigo);
		empresaService.excluir(empresa);
		return ResponseEntity.noContent().build();
	}
}
