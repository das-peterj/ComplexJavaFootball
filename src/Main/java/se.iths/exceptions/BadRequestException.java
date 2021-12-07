package se.iths.exceptions;

public class BadRequestException extends RuntimeException{
    public BadRequestException(String errorMessage){
            super(errorMessage);
        }
    }
