package com.angula.spring.exeption;

public class TurmaExistenteException extends RuntimeException{

	
	private static final long serialVersionUID = -7814786779253792771L;

	public TurmaExistenteException(String mensagem) {
		super(mensagem);
	}
	
	public TurmaExistenteException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
}
