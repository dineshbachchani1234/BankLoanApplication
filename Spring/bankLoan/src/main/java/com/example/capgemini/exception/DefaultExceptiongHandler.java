package com.example.capgemini.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class DefaultExceptiongHandler extends ResponseEntityExceptionHandler{
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ErrorMessage> someError(Exception e)
	{
		ErrorMessage exceptionResponse=new ErrorMessage("An exception has occured. Please resolve the issue.!",e.getLocalizedMessage());
		return new ResponseEntity<ErrorMessage>(exceptionResponse,new HttpHeaders(),HttpStatus.FORBIDDEN);
	}

}
class ErrorMessage
{
	private String message;
	private String details;
	public ErrorMessage(String message,String details)
	{
		super();
		this.message=message;
		this.details=details;
	}
	public String getMessage()
	{
		return message;
	}
	public void setMessage(String message)
	{
		this.message=message;
	}
	public String getDetails()
	{
		return details;
	}
	public void setDetails(String details)
	{
		this.details=details;
	}
}