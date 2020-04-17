package com.angula.spring.exeption;

public class AlunoNaoEncontradaExeption extends RuntimeException {

	
	private static final long serialVersionUID = 445679794888390347L;
	
	public AlunoNaoEncontradaExeption(String mensagem) {
		super(mensagem);
	}
	
	public AlunoNaoEncontradaExeption(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}

}
