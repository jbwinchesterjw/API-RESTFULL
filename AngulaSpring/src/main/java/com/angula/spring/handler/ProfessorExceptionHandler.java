package com.angula.spring.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.angula.spring.domain.DetalhesErro;
import com.angula.spring.exeption.ProfessorExistenteException;
import com.angula.spring.exeption.ProfessorNaoEncontradaExeption;

@ControllerAdvice
public class ProfessorExceptionHandler {

	@ExceptionHandler(ProfessorNaoEncontradaExeption.class)
	public ResponseEntity<DetalhesErro> handleProfessorNaoEncontradoException(ProfessorNaoEncontradaExeption e, HttpServletRequest request){
		
		DetalhesErro erro = new DetalhesErro();
	
		erro.setStatus(404l);
		erro.setTitulo("Professor não encontrado");
		erro.setMensagem_desenvolvedor("http://erros.angulaSpring.com/404");
		erro.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
		
	}
	
	@ExceptionHandler(ProfessorExistenteException.class)
	public ResponseEntity<DetalhesErro> handleProfessorExistenteException
							(ProfessorExistenteException e, HttpServletRequest request) {
		
		DetalhesErro erro = new DetalhesErro();
		erro.setStatus(409l);
		erro.setTitulo("Professor existente");
		erro.setMensagem_desenvolvedor("http://erros.angulaSpring.com/409");
		erro.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);
	}
	
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<DetalhesErro> handleDataIntegrityViolationException
							(DataIntegrityViolationException e, HttpServletRequest request) {
		
		DetalhesErro erro = new DetalhesErro();
		erro.setStatus(400l);
		erro.setTitulo("Requisição inválida");
		erro.setMensagem_desenvolvedor("http://erros.angulaSpring.com/400");
		erro.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
	}
}
