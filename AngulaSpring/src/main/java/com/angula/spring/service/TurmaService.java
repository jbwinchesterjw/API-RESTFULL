package com.angula.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.angula.spring.domain.Turma;
import com.angula.spring.exeption.TurmaNaoEncontradaException;
import com.angula.spring.repository.ITurmaRepository;

@Service
public class TurmaService {
	
	@Autowired
	private ITurmaRepository iturmaRepository;
	
	public List <Turma> listar(){
		return iturmaRepository.findAll();
	}
	
	public Optional<Turma> buscarId(Long id) {
			Optional<Turma> turma = iturmaRepository.findById(id);
			
			if (turma == null) {
				throw new TurmaNaoEncontradaException("Turma não encontrada !");
			}
			
			return turma;
	}
	
	public Turma salvar(Turma aluno) {
		aluno.setId_turma(null);
		return iturmaRepository.save(aluno);
	}
	
	public void  deletar(Long id) {
		
		try {
			iturmaRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new TurmaNaoEncontradaException("A turma não pode ser encontrado !");
		}
		
	}
	
	public void atualizar(Turma turma) {
		verificaExitenciaTurma(turma);
		iturmaRepository.save(turma);
	}
	
	private void verificaExitenciaTurma(Turma turma) {
		buscarId(turma.getId_turma());
	}

}
