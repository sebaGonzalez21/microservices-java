package com.testapi.generic.exception;

import org.springframework.http.HttpStatus;

import java.io.Serializable;


/**
 * Sebastian Gonzalez
 */
public class GenericException extends Exception implements Serializable {
    private static final long serialVersionUID = -1637192118913991331L;
    private final HttpStatus httpStatus;

    public GenericException(String message, HttpStatus httpStatus){
        super(message);
        this.httpStatus = httpStatus;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}