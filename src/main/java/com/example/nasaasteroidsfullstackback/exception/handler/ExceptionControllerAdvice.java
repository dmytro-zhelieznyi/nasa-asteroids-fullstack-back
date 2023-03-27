package com.example.nasaasteroidsfullstackback.exception.handler;

import com.example.nasaasteroidsfullstackback.exception.model.ExceptionDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
@RequiredArgsConstructor
public class ExceptionControllerAdvice {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionDto> handleException(Exception e) {
        log.error(e.getMessage(), e);
        ExceptionDto exceptionDto = new ExceptionDto(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        return ResponseEntity
                .status(exceptionDto.getCode())
                .body(exceptionDto);
    }

    @ExceptionHandler(JsonProcessingException.class)
    public ResponseEntity<ExceptionDto> handleException(JsonProcessingException e) {
        log.error(e.getMessage(), e);
        ExceptionDto exceptionDto = new ExceptionDto(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        return ResponseEntity
                .status(exceptionDto.getCode())
                .body(exceptionDto);
    }

}
