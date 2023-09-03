package com.docs.roller.game.diceapp.dto;

import com.docs.roller.game.diceapp.utils.ApplicationUtils;


public class Dice {
    private Integer numberOfFaces;
    private Integer faceValueAfterRolling;

    public Dice(Integer numberOfFaces) {
        this.numberOfFaces = numberOfFaces;
    }

    public int roleDice() {
        return ApplicationUtils.getRandomNumber(numberOfFaces);
    }

    public Integer getNumberOfFaces() {
        return numberOfFaces;
    }

    public void setNumberOfFaces(Integer numberOfFaces) {
        this.numberOfFaces = numberOfFaces;
    }

    public Integer getResult() {
        return faceValueAfterRolling;
    }

    public void setResult(Integer faceValueAfterRolling) {
        this.faceValueAfterRolling = faceValueAfterRolling;
    }
}
