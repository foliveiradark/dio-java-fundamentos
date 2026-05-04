package excecoes.v1.exception;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(final String message){
        super(message);
    }
}
