package com.docs.roller.game.diceapp.utils;

import com.docs.roller.game.diceapp.exception.DiceGameException;
import com.docs.roller.game.diceapp.constants.DiceGameDefaults;

import java.util.Random;

public class ApplicationUtils {
    public static Integer parseInputStringToNumber(String str) {
        if (str == null || "".equals(str.trim())) {
            return null;
        }
        try {
            int parsed = Integer.parseInt(str);
            if (parsed < 1) {
                throw new DiceGameException(DiceGameDefaults.INVALID_INPUT_ERROR);
            }
            return parsed;
        } catch (Exception e) {
            throw new DiceGameException(DiceGameDefaults.INVALID_INPUT_ERROR);
        }
    }

    public static int getRandomNumber(int input) {
        return new Random().nextInt(input) + 1;
    }
}
