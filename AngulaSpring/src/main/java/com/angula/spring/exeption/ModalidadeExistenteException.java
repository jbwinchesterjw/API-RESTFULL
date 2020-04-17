package com.angula.spring.exeption;

public class ModalidadeExistenteException  extends RuntimeException{

	private static final long serialVersionUID = 8654993108615905595L;

	public ModalidadeExistenteException(String mensagem) {
		super(mensagem);
	}
	
	public ModalidadeExistenteException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
}
