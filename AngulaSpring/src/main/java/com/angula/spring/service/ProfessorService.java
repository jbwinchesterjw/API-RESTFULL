package com.angula.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.angula.spring.domain.Professor;
import com.angula.spring.exeption.ProfessorNaoEncontradaExeption;
import com.angula.spring.repository.IProfessorRepository;

@Service
public class ProfessorService {

	@Autowired
	private IProfessorRepository iprofessorRepository;
	
	public List <Professor> listar(){
		return iprofessorRepository.findAll();
	}
	
	public Optional<Professor> buscarId(Long id) {
			Optional<Professor> professor = iprofessorRepository.findById(id);
			
			if (professor == null) {
				throw new ProfessorNaoEncontradaExeption("Professor não encontrada !");
			}
			
			return professor;
	}
	
	public Professor salvar(Professor professor) {
		professor.setId_professor(null);
		return iprofessorRepository.save(professor);
	}
	
	public void  deletar(Long id) {
		
		try {
			iprofessorRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ProfessorNaoEncontradaExeption("O professor nao pode ser encontrado !");
		}
		
	}
	
	public void atualizar(Professor professor) {
		verificaExitenciaProfessor(professor);
		iprofessorRepository.save(professor);
	}
	
	private void verificaExitenciaProfessor(Professor professor) {
		buscarId(professor.getId_professor());
	}
	
	
}
