package com.angula.spring.exeption;

public class TurmaNaoEncontradaException  extends RuntimeException{

	private static final long serialVersionUID = 7633884103216539058L;
	public TurmaNaoEncontradaException(String mensagem) {
		super(mensagem);
	}
	
	public TurmaNaoEncontradaException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}

}
