package com.angula.spring.exeption;

public class ProfessorNaoEncontradaExeption extends RuntimeException{

	private static final long serialVersionUID = 4936074029169555489L;

	public ProfessorNaoEncontradaExeption(String mensagem) {
		super(mensagem);
	}
	
	public ProfessorNaoEncontradaExeption(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
}
