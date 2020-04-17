package com.angula.spring.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.angula.spring.domain.DetalhesErro;
import com.angula.spring.exeption.TurmaExistenteException;
import com.angula.spring.exeption.TurmaNaoEncontradaException;

@ControllerAdvice
public class TurmaExceptionHandler {

	@ExceptionHandler(TurmaNaoEncontradaException.class)
	public ResponseEntity<DetalhesErro> handleTurmaNaoEncontradoException(TurmaNaoEncontradaException e, HttpServletRequest request){
		
		DetalhesErro erro = new DetalhesErro();
	
		erro.setStatus(404l);
		erro.setTitulo("Turma não encontrada");
		erro.setMensagem_desenvolvedor("http://erros.angulaSpring.com/404");
		erro.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
		
	}
	
	@ExceptionHandler(TurmaExistenteException.class)
	public ResponseEntity<DetalhesErro> handleTurmaExistenteException
							(TurmaExistenteException e, HttpServletRequest request) {
		
		DetalhesErro erro = new DetalhesErro();
		erro.setStatus(409l);
		erro.setTitulo("Turma existente");
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
