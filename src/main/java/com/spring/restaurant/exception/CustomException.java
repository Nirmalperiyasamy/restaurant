package com.spring.restaurant.exception;

public class CustomException extends RuntimeException{

    public CustomException(String user) {
        super(user);
    }
}
