package se.iths.exceptions;

public class BeenDeletedException extends RuntimeException{
    public BeenDeletedException(String errorMessage){
        super(errorMessage);
    }
}
