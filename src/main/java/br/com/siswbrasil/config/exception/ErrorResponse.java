package br.com.siswbrasil.config.exception;

import java.util.Map;

public class ErrorResponse {
	private int status;
	private String message;
	private Map<String, Object> body;

	public ErrorResponse() {
		super();
	}

	public ErrorResponse(int status, String message) {
		super();
		this.status = status;
		this.message = message;
	}

	public ErrorResponse(int status, String message, Map<String, Object> body) {
		super();
		this.status = status;
		this.message = message;
		this.setBody(body);
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Map<String, Object> getBody() {
		return body;
	}

	public void setBody(Map<String, Object> body) {
		this.body = body;
	}

	@Override
	public String toString() {
		return "ErrorResponse [status=" + status + ", message=" + message + "]";
	}
}