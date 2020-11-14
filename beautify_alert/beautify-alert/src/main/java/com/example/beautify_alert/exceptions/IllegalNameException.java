package com.example.beautify_alert.exceptions;

public class IllegalNameException extends RuntimeException {

    private static final long serialVersionUID = -5889682267247086200L;

    public IllegalNameException(String message) {
        super(message);
    }

    public IllegalNameException(){
    }
}
