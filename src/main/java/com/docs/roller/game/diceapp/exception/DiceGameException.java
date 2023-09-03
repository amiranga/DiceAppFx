package com.docs.roller.game.diceapp.exception;

/**
 * Custom exception to handle dice game errors
 */
public class DiceGameException extends RuntimeException {
    public DiceGameException(String errorMessage) {
        super(errorMessage);
    }
}
