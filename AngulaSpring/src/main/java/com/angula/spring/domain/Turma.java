package com.angula.spring.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Turma {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_turma;
	
	private String nome;

	public Long getId_turma() {
		return id_turma;
	}

	public void setId_turma(Long id_turma) {
		this.id_turma = id_turma;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_turma == null) ? 0 : id_turma.hashCode());
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
		Turma other = (Turma) obj;
		if (id_turma == null) {
			if (other.id_turma != null)
				return false;
		} else if (!id_turma.equals(other.id_turma))
			return false;
		return true;
	}
	
	
	
	
	
}
