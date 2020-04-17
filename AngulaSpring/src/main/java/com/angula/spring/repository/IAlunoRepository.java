package com.angula.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.angula.spring.domain.Aluno;

public interface IAlunoRepository extends JpaRepository<Aluno, Long>{

}
