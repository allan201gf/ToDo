package br.com.allan201gf.todo.rest.controller;

import br.com.allan201gf.todo.rest.ApiErrors;
import br.com.allan201gf.todo.domain.exception.RuleOfException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ApplicationControllerAdvice {

    @ExceptionHandler(RuleOfException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrors handleRuleOfException(RuleOfException ex) {
        String errorMessage = ex.getMessage();
        return new ApiErrors(errorMessage);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrors handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        List<String> errors = ex.getBindingResult()
                .getAllErrors()
                .stream()
                .map(error -> error.getDefaultMessage())
                .collect(Collectors.toList());
        return new ApiErrors(errors);
    }

}
