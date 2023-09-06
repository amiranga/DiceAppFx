package PD;

import java.util.ArrayList;
import java.util.List;

/**
 * Game Model which has number of rounds
 */
public class DiceGame implements Game {
    private final StringBuilder result = new StringBuilder();
    private List<Dice> dices = new ArrayList<>();
    private List<Integer> results;
    private int numberOfDiceVal;
    private int numberOfFaceVal;

    public DiceGame() {
    }

    @Override
    public void buildGame() {
        for (int i = 1; i <= numberOfDiceVal; i++) {
            dices.add(new Dice(numberOfFaceVal));
        }
    }

    /**
     * Print the game output based on user input
     */
    @Override
    public String getGameoutput() {
        for (int i = 0; i < results.size(); i++) {
            int roundNumber = i + 1;
            Integer val = results.get(i);
            result.append("Dice ").append(roundNumber).append(" Value = ").append(val).append("\n");
        }
        result.append("\nTotal = ").append(results.stream().mapToInt(r -> r).sum()).append("\n");
        return result.toString();
    }

    public int getNumberOfDiceVal() {
        return numberOfDiceVal;
    }

    public void setNumberOfDiceVal(int numberOfDiceVal) {
        this.numberOfDiceVal = numberOfDiceVal;
    }

    public int getNumberOfFaceVal() {
        return numberOfFaceVal;
    }

    public void setNumberOfFaceVal(int numberOfFaceVal) {
        this.numberOfFaceVal = numberOfFaceVal;
    }


    @Override
    public void playGame() {
        setResults(new ArrayList<>());
        dices.forEach(dice -> {
            int value = dice.roleDice();
            getResults().add(value);
        });
    }

    public List<Dice> getDices() {
        return dices;
    }

    public void setDices(List<Dice> dices) {
        this.dices = dices;
    }

    public List<Integer> getResults() {
        return results;
    }

    public void setResults(List<Integer> results) {
        this.results = results;
    }


}
