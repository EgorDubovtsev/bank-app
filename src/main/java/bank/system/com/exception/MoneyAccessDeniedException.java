package bank.system.com.exception;

public class MoneyAccessDeniedException extends RuntimeException {
    public MoneyAccessDeniedException(String message) {
        super(message);
    }
}
