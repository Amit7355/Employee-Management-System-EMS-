package com.sampark.employeeManagement.dto;

import java.time.LocalDateTime;


public class ExceptionResponseDto {

	private LocalDateTime datetime;
	private int status;
	private String error;
	private String message;
	private String path;
	public ExceptionResponseDto(LocalDateTime datetime, int status, String error, String message, String path) {
		//super();
		this.datetime = datetime;
		this.status = status;
		this.error = error;
		this.message = message;
		this.path = path;
	}
	public LocalDateTime getDatetime() {
		return datetime;
	}
	public void setDatetime(LocalDateTime datetime) {
		this.datetime = datetime;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getTrace() {
		return path;
	}
	public void setTrace(String trace) {
		this.path = trace;
	}
	
	
}
