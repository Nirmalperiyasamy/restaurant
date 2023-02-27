package com.spring.restaurant.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.List;
@Getter
@Setter
public class ErrorResponse {
    private HttpStatus code;
    private String message;
    private List<String> errors;

    public ErrorResponse(HttpStatus code, String message) {
        this.code = code;
        this.message = message;
    }

    public ErrorResponse(HttpStatus code, String message, List<String> errors) {
        this.code = code;
        this.message = message;
        this.errors = errors;
    }
}
