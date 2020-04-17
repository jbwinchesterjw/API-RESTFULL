package com.angula.spring.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.angula.spring.domain.Modalidade;
import com.angula.spring.service.ModalidadeService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping({"/modalidade"})
public class ModalidadeController {

	@Autowired
	private ModalidadeService modalidadeService;

	/*buscar todos os registro na tabela*/
	@RequestMapping(method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE
	})
	public ResponseEntity<List<Modalidade>> listar() {
		return ResponseEntity.status(HttpStatus.OK).body(modalidadeService.listar());
	}
	
	/*salvar registros relacionados a modalidade*/
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void>salvar(@RequestBody Modalidade modalidade) {
		modalidade = modalidadeService.salvar(modalidade);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(modalidade.getId_modalidade()).toUri();
		return ResponseEntity.created(uri).build();
		
	}
	
	/*lista registros por id*/
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity <?>buscarId(@PathVariable("id") Long id) {
		Optional<Modalidade> modalidade = modalidadeService.buscarId(id);
		return ResponseEntity.status(HttpStatus.OK).body(modalidade);
	}
	
	/*deletar resgistro modalidade por id*/
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
		modalidadeService.deletar(id);
		
		return ResponseEntity.noContent().build();
	}
	
	/*atualizar registros modalidades por id*/
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> atualizar(@RequestBody Modalidade modalidade,@PathVariable("id") Long id) {
		modalidade.setId_modalidade(id);
		modalidadeService.atualizar(modalidade);
		
		return ResponseEntity.noContent().build();
	}
}
