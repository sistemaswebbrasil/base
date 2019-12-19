package br.com.siswbrasil.config;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.siswbrasil.config.exception.ErrorResponse;

@RestControllerAdvice
public class ErrorHandler {

	@ExceptionHandler(value = { HttpMessageNotReadableException.class })
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorResponse httpMessageNotReadableException(Exception ex) {
		return new ErrorResponse(400, "Requisição inválida");
	}

	@ExceptionHandler(value = { MethodArgumentNotValidException.class })
	@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
	public ErrorResponse methodArgumentNotValidException(MethodArgumentNotValidException ex) {

		Map<String, Object> body = new LinkedHashMap<>();

		// Get all errors
		List<String> errors = ex.getBindingResult().getFieldErrors().stream()
				.map(x -> x.getField() + " : " + x.getDefaultMessage()).collect(Collectors.toList());

		body.put("errors", errors);

		return new ErrorResponse(422, "Requisição inválida", body);
	}

	@ExceptionHandler(value = { IOException.class })
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorResponse iOException(Exception ex) {
		return new ErrorResponse(500, "Erro no servidor");
	}

	@ExceptionHandler(value = { Exception.class })
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorResponse exception(Exception ex) {
		return new ErrorResponse(500, "Erro desconhecido");
	}
}
