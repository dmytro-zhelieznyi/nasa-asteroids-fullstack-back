package com.example.nasaasteroidsfullstackback.exception.model;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ExceptionDto {
    private final String message;
    private final String status;
    private final Integer code;

    public ExceptionDto(String message, HttpStatus status) {
        this.message = message;
        this.status = status.getReasonPhrase();
        this.code = status.value();
    }
}
