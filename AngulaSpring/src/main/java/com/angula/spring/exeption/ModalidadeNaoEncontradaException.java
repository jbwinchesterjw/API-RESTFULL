package com.angula.spring.exeption;

public class ModalidadeNaoEncontradaException extends RuntimeException{

	private static final long serialVersionUID = -6131932107260663374L;
	
	public ModalidadeNaoEncontradaException(String mensagem) {
		super(mensagem);
	}
	
	public ModalidadeNaoEncontradaException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
	

}
