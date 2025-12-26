package com.inventario.appinventario.exception;

import java.util.HashMap;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ManejadorErrores {

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> manejarErrores(MethodArgumentNotValidException ex) {

		Map<String,String> errores =new HashMap<String, String>();

		ex.getBindingResult().getAllErrors().forEach(error -> {
			String campo = ((FieldError) error).getField();
			String mensajeError = error.getDefaultMessage();
			errores.put(campo, mensajeError);

		});

		return errores;

	}
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(ProductoNoEncontradoException.class)
	public Map<String, String> manejarNoEncontrado(ProductoNoEncontradoException ex) {
	    Map<String, String> error = new HashMap<>();
	    error.put("error", ex.getMessage());
	    return error;
	}

}
