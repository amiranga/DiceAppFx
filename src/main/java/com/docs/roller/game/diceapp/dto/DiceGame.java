package com.docs.roller.game.diceapp.dto;

import com.docs.roller.game.diceapp.constants.DiceGameDefaults;
import com.docs.roller.game.diceapp.enums.GameMode;
import com.docs.roller.game.diceapp.interfaces.Game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Game Model which has number of rounds
 */
public class DiceGame implements Game {
    private final List<List<Integer>> diceGameResult = new ArrayList<>();
    private final List<DiceGameRound> diceGameRoundList = new ArrayList<>();
    private final StringBuilder result = new StringBuilder();
    private int numberOfDiceVal = DiceGameDefaults.NUMBER_OF_DICES;
    private int numberOfFaceVal = DiceGameDefaults.NUMBER_OF_FACES;
    private int numberOfRoundVal = DiceGameDefaults.NUMBER_OF_ROUNDS;
    private GameMode gameMode;

    public DiceGame() {
    }

    @Override
    public void buildGame() {
        for (int i = 1; i <= numberOfRoundVal; i++) {
            diceGameRoundList.add(new DiceGameRound(numberOfDiceVal, numberOfFaceVal));
        }
    }

    /**
     * This method will call playRound() method of all rounds in game
     */
    @Override
    public void playGame() {
        for (DiceGameRound diceGameRound : diceGameRoundList) {
            diceGameRound.playRound();
            diceGameResult.add(diceGameRound.getResults());
        }
    }


    /**
     * Print the game output based on user input
     *
     * @return
     */
    @Override
    public String getGameoutput() {
        switch (gameMode) {
            case MULTI_ROUND:
                printFrequencyMap();
                break;
            case MULTI_DICE:
                printEachRoundResult();
                printEachRoundTotal();
                break;
            case SINGLE_DICE:
                printEachRoundResult();
                break;
            default:
                printFrequencyMap();
                printEachRoundResult();
                printEachRoundTotal();
        }
        return result.toString();
    }

    /**
     * Print each round each dice value comma seperated
     */
    private void printEachRoundResult() {
        for (int i = 0; i < diceGameResult.size(); i++) {
            int roundNumber = i + 1;
            List<Integer> roundResult = diceGameResult.get(i);
            result.append("Round ").append(roundNumber).append(" Result = ").append(roundResult).append("\n");
        }
    }

    /**
     * Print each round total
     *
     * @return
     */
    private void printEachRoundTotal() {
        for (int i = 0; i < diceGameResult.size(); i++) {
            int roundNumber = i + 1;
            List<Integer> roundResult = diceGameResult.get(i);
            result.append("Round ").append(roundNumber).append(" Total Value = ").append(roundResult.stream().mapToInt(r -> r).sum()).append("\n");
        }
    }


    /**
     * print frequency of each face thought the game
     *
     * @return
     */
    private void printFrequencyMap() {
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        diceGameResult.forEach(roundResult -> roundResult.forEach(diceValue -> {
            int currentFrequency = 0;
            if (frequencyMap.containsKey(diceValue)) {
                currentFrequency = frequencyMap.get(diceValue);
            }
            frequencyMap.put(diceValue, currentFrequency + 1);
        }));
        frequencyMap.forEach((key, value) -> result.append("Frequency of ").append(key).append(" = ").append(value).append("\n"));
    }


    //Getter Setter

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

    public int getNumberOfRoundVal() {
        return numberOfRoundVal;
    }

    public void setNumberOfRoundVal(int numberOfRoundVal) {
        this.numberOfRoundVal = numberOfRoundVal;
    }

    public GameMode getGameMode() {
        return gameMode;
    }

    public void setGameMode(GameMode gameMode) {
        this.gameMode = gameMode;
    }

    public List<List<Integer>> getDiceGameResult() {
        return diceGameResult;
    }

    public List<DiceGameRound> getDiceGameRoundList() {
        return diceGameRoundList;
    }


}
