package com.angula.spring.domain;

public class DetalhesErro {

	private String titulo;
	
	private Long status;
	
	private Long timestamp;
	
	private String mensagem_desenvolvedor;

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Long getStatus(long l) {
		return status;
	}

	public void setStatus(Long status) {
		this.status = status;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	public String getMensagem_desenvolvedor() {
		return mensagem_desenvolvedor;
	}

	public void setMensagem_desenvolvedor(String mensagem_desenvolvedor) {
		this.mensagem_desenvolvedor = mensagem_desenvolvedor;
	}
	
	
}
