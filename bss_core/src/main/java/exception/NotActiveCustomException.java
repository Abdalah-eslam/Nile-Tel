package exception;

public class NotActiveCustomException extends RuntimeException {
    public NotActiveCustomException(String massage) {
        super(massage);
    }
}
