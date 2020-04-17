package com.angula.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.angula.spring.domain.Modalidade;
import com.angula.spring.exeption.TurmaNaoEncontradaException;
import com.angula.spring.repository.IModalidadeRepository;

@Service
public class ModalidadeService {

	@Autowired
	private IModalidadeRepository imodalidadeRepository;
	
	public List <Modalidade> listar(){
		return imodalidadeRepository.findAll();
	}
	
	public Optional<Modalidade> buscarId(Long id) {
			Optional<Modalidade> modalidade = imodalidadeRepository.findById(id);
			
			if (modalidade == null) {
				throw new TurmaNaoEncontradaException("Modalidade não encontrada !");
			}
			
			return modalidade;
	}
	
	public Modalidade salvar(Modalidade modalidade) {
		modalidade.setId_modalidade(null);
		return imodalidadeRepository.save(modalidade);
	}
	
	public void  deletar(Long id) {
		
		try {
			imodalidadeRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new TurmaNaoEncontradaException("Essa modalidade não pode ser encontrado !");
		}
		
	}
	
	public void atualizar(Modalidade modalidade) {
		verificaExitenciaModalidade(modalidade);
		imodalidadeRepository.save(modalidade);
	}
	
	private void verificaExitenciaModalidade(Modalidade modalidade) {
		buscarId(modalidade.getId_modalidade());
	}
	
}
