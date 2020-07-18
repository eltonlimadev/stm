package br.com.trendcode.stm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.trendcode.stm.model.Veiculo;
import br.com.trendcode.stm.service.VeiculoService;

@RestController
@RequestMapping(value="/veiculos")
public class VeiculoController {

	@Autowired
	private VeiculoService veiculoService;
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert (@RequestBody Veiculo veiculo){
		veiculoService.salvar(veiculo);
		return ResponseEntity.ok().build();
	}
	
	@RequestMapping(value = "/{placa}", method = RequestMethod.GET)
	public ResponseEntity<Veiculo> findByPlaca (@PathVariable String placa){
		Veiculo veiculo = veiculoService.buscarPorPlaca(placa);
		return ResponseEntity.ok().body(veiculo);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Veiculo>> findAll (){
		List<Veiculo> veiculos = veiculoService.buscarTodos();
		return ResponseEntity.ok().body(veiculos);
	}
	
	@RequestMapping(value="/{codigo}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update (@RequestBody Veiculo veiculo, @PathVariable Long codigo){
		veiculo.setCodigo(codigo);
		veiculoService.editar(veiculo);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{codigo}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete (@PathVariable Long codigo){
		Veiculo veiculo = new Veiculo();
		veiculo.setCodigo(codigo);
		veiculoService.excluir(veiculo);
		return ResponseEntity.noContent().build();
	}
}
