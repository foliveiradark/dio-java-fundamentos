package excecoes.v1.exception;

public class CustomExeption extends RuntimeException {
    public CustomExeption(final String message, final Throwable cause) {
        super(message, cause);
    }
}
