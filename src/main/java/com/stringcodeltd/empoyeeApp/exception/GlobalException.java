package com.stringcodeltd.empoyeeApp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice

public class GlobalException {
   @ExceptionHandler(ResourceNotFoundException.class)
   public ResponseEntity<?>resourceNotFoundException(ResourceNotFoundException rfe, WebRequest request){
       ErrorDetails errorDetails =  new ErrorDetails(rfe.getMessage(),request.getDescription(false), new Date());
       return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
   }

   @ExceptionHandler(Exception.class)
    public ResponseEntity<?> globalexceptionhandler(Exception ex, WebRequest request){
       ErrorDetails errorDetails =  new ErrorDetails(ex.getMessage(),request.getDescription(false), new Date());
       return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
   }
}
