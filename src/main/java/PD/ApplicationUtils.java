package PD;

import PD.DiceGameDefaults;
import PD.DiceGameException;

import java.util.Random;

public class ApplicationUtils {
    public static Integer parseInputStringToNumber(String str) {
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
