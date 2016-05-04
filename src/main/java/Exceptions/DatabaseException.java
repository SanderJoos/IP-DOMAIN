package Exceptions;

/**
 * @author Sander Joos
 *
 * //not yet used, logic behind usage is pendig development
 */
public class DatabaseException extends RuntimeException{

    public DatabaseException(){

    }

    public DatabaseException(String message){
        super(message);
    }
}
