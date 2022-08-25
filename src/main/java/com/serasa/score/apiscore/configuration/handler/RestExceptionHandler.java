package com.serasa.score.apiscore.configuration.handler;

import com.serasa.score.apiscore.configuration.exception.NoContentException;
import com.serasa.score.apiscore.configuration.exception.NotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

@RestControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Object> tratarExceptionGeral(Exception exception){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro interno ! Fale com o administrador!");
    }
    @ExceptionHandler(value = NoContentException.class)
    public ResponseEntity<Object> tratarNoContentException(NoContentException exception){
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(exception.getMessage());
    }
    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity<Object> tratarNoContentException(NotFoundException exception){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }
    @ExceptionHandler(value = {DataIntegrityViolationException.class, HttpMessageNotReadableException.class})
    public ResponseEntity<Object> tratarBadRequestException(Exception exception){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Dados invalidos");
    }
    @ExceptionHandler(value = BindException.class)
    public ResponseEntity<Object> tratarDadosInvalidosException(BindException exception){
        var campos = exception.getFieldErrors().stream().map(err->err.getField()).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Dados invalidos "+campos);
    }
}
