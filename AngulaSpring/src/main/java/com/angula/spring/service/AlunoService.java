package com.angula.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.angula.spring.domain.Aluno;
import com.angula.spring.exeption.AlunoNaoEncontradaExeption;
import com.angula.spring.repository.IAlunoRepository;


@Service
public class AlunoService {

	@Autowired
	private IAlunoRepository ialunoRepository;
	
	public List <Aluno> listar(){
		return ialunoRepository.findAll();
	}
	
	public Optional<Aluno> buscarId(Long id) {
			Optional<Aluno> aluno = ialunoRepository.findById(id);
			
			if (aluno == null) {
				throw new AlunoNaoEncontradaExeption("Aluno não encontrada !");
			}
			
			return aluno;
	}
	
	public Aluno salvar(Aluno aluno) {
		aluno.setId_aluno(null);
		return ialunoRepository.save(aluno);
	}
	
	public void  deletar(Long id) {
		
		try {
			ialunoRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new AlunoNaoEncontradaExeption("O Aluno nao pode ser encontrado !");
		}
		
	}
	
	public void atualizar(Aluno aluno) {
		verificaExitenciaAluno(aluno);
		ialunoRepository.save(aluno);
	}
	
	private void verificaExitenciaAluno(Aluno aluno) {
		buscarId(aluno.getId_aluno());
	}
	
}
