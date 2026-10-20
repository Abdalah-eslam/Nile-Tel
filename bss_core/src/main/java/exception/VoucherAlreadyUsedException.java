package exception;

public class VoucherAlreadyUsedException extends RuntimeException {
    public VoucherAlreadyUsedException(String message) {
        super(message);
    }
}
