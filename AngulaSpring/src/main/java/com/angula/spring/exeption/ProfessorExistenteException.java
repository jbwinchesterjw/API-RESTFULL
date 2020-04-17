package com.angula.spring.exeption;

public class ProfessorExistenteException extends RuntimeException{


	private static final long serialVersionUID = 1759138551691876820L;

	public ProfessorExistenteException(String mensagem) {
		super(mensagem);
	}
	
	public ProfessorExistenteException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
}
