package Exceptions;

public class InvalidRole extends RuntimeException {
    public InvalidRole(String message) {
        super(message);
    }
}
