package com.banking.exception;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.banking.model.ErrorResponse;



@ControllerAdvice
public class AccountExceptionHandler extends ResponseEntityExceptionHandler {

//	public String dateTimeString ;
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	String dateTimeString = LocalDateTime.now().format(formatter);

	@ExceptionHandler(AccountNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleAccountNotFoundException(WebRequest request, Exception ex)
	{
		ErrorResponse errorResponse = new ErrorResponse();
		//errorResponse.setName(ex.getMessage());
		errorResponse.setDescription("Account Not found. Please Enter correct Account number");
		errorResponse.setStatusCode(400);
		errorResponse.setTimeStamp(dateTimeString);
		
		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(insufficientBalanceException.class)
	public ResponseEntity<ErrorResponse> handleInssuficientBalanceException(WebRequest request, Exception ex)
	{
		ErrorResponse errorResponse = new ErrorResponse();
		//errorResponse.setName(ex.getMessage());
		errorResponse.setDescription("Insufficient Balance. Please check balance");
		errorResponse.setStatusCode(400);
		errorResponse.setTimeStamp(dateTimeString);
		
		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.BAD_REQUEST);
	}

}
