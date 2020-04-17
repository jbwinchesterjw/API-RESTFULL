package com.angula.spring.exeption;

public class AlunoExistenteException extends RuntimeException{
	
	
	private static final long serialVersionUID = 3037593794395757370L;

	public AlunoExistenteException(String mensagem) {
		super(mensagem);
	}
	
	public AlunoExistenteException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}

}
