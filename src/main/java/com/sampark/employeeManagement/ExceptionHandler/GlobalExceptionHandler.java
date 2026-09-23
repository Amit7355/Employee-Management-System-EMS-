package com.sampark.employeeManagement.ExceptionHandler;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.sampark.employeeManagement.dto.ExceptionResponseDto;
import com.sampark.employeeManagement.service.ResourceNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ExceptionResponseDto> handleIllegalArgumentException(IllegalArgumentException e, HttpServletRequest request) {

    	ExceptionResponseDto ex=new ExceptionResponseDto(
    			LocalDateTime.now(), 
    			HttpStatus.BAD_REQUEST.value(),
    			HttpStatus.BAD_REQUEST.getReasonPhrase(),
    			e.getMessage(),
    			request.getRequestURI()); // to take path from servlet because servlet have that path
    	
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(ex);
    }
    
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ExceptionResponseDto> handleRuntimeException(RuntimeException r,HttpServletRequest request)
    {
    	ExceptionResponseDto ex=new ExceptionResponseDto(
    			LocalDateTime.now(), 
    			HttpStatus.NOT_FOUND.value(),
    			HttpStatus.NOT_FOUND.getReasonPhrase(),
    			r.getMessage(),
    			request.getRequestURI()); 
    	return ResponseEntity
    			.status(HttpStatus.NOT_FOUND)
    			.body(ex);
    }
    
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ExceptionResponseDto> handleResourceNotFound(ResourceNotFoundException r,HttpServletRequest request)
    {
    	ExceptionResponseDto ex=new ExceptionResponseDto(
    			LocalDateTime.now(),
    			HttpStatus.NOT_FOUND.value(),
    			HttpStatus.NOT_FOUND.getReasonPhrase(),
    			r.getMessage(),
    			request.getRequestURI());
    	
    	return ResponseEntity
    			.status(HttpStatus.NOT_FOUND)
    			.body(ex);
    }
    
   
}