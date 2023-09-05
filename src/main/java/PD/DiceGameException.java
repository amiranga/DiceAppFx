package PD;

/**
 * Custom exception to handle dice game errors
 */
public class DiceGameException extends RuntimeException {
    public DiceGameException(String errorMessage) {
        super(errorMessage);
    }
}
