package com.angula.spring.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Modalidade {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_modalidade;
	
	@Column(name = "nome")
	private String nome;

	@Column(name = "mensalidade")
	private Double mensalidade;

	
	public Long getId_modalidade() {
		return id_modalidade;
	}

	public void setId_modalidade(Long id_modalidade) {
		this.id_modalidade = id_modalidade;
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getMensalidade() {
		return mensalidade;
	}

	public void setMensalidade(Double mensalidade) {
		this.mensalidade = mensalidade;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_modalidade == null) ? 0 : id_modalidade.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Modalidade other = (Modalidade) obj;
		if (id_modalidade == null) {
			if (other.id_modalidade != null)
				return false;
		} else if (!id_modalidade.equals(other.id_modalidade))
			return false;
		return true;
	}

	
	
	
}
