package com.pieropan.githubsearch.exception;

import com.pieropan.githubsearch.dto.ExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(HttpClientErrorException.NotFound.class)
    public ResponseEntity<ExceptionDto> NotFoundException(HttpClientErrorException.NotFound e) {

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ExceptionDto(HttpStatus.NOT_FOUND, "Usuário não encontrado."));
    }

    @ExceptionHandler(HttpClientErrorException.Forbidden.class)
    public ResponseEntity<ExceptionDto> NotFoundException(HttpClientErrorException.Forbidden e) {

        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(
                new ExceptionDto(HttpStatus.FORBIDDEN, "Serviço indisponível."));
    }
}