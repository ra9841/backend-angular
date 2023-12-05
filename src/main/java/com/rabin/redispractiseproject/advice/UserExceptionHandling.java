package com.rabin.redispractiseproject.advice;

import com.rabin.redispractiseproject.exception.UserAlreadyExistException;
import com.rabin.redispractiseproject.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class UserExceptionHandling {

    @ExceptionHandler(UserAlreadyExistException.class)
    public ResponseEntity<Map<String, String>> exceptionHandlingIfUserExist(UserAlreadyExistException ex) {
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("message", ex.getMessage());
        errorMap.put("status code", HttpStatus.ALREADY_REPORTED.toString());
        return ResponseEntity.ok(errorMap);
    }


    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Map<String, String>> exceptionHandlingIfUserExist(UserNotFoundException ex) {
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("message", ex.getMessage());
        errorMap.put("status code", HttpStatus.NOT_FOUND.toString());
        return ResponseEntity.ok(errorMap);
    }
}
