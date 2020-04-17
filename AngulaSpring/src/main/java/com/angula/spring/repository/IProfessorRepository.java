package com.angula.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.angula.spring.domain.Professor;

public interface IProfessorRepository extends JpaRepository<Professor, Long>{

}
