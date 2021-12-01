package se.iths.exceptions;

public class BeenDeletedException extends RuntimeException{
    public BeenDeletedException(String errorMessage, Throwable err){
        super(errorMessage, err);
    }
}
