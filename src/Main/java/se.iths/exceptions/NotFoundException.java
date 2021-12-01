package se.iths.exceptions;

public class NotFoundException extends RuntimeException{
    public NotFoundException(String errorMessage){
        super(errorMessage);
    }
}
