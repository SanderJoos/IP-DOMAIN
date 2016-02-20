package Exceptions;

/**
 * @author Sander Joos
 */
public class DomainException extends RuntimeException {

    public DomainException(){

    }

    public DomainException(String message){
        super(message);
    }
}
