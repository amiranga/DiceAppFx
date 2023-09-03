package com.docs.roller.game.diceapp;

import com.docs.roller.game.diceapp.constants.DiceGameDefaults;
import com.docs.roller.game.diceapp.dto.DiceGame;
import com.docs.roller.game.diceapp.enums.GameMode;
import com.docs.roller.game.diceapp.exception.DiceGameException;
import com.docs.roller.game.diceapp.utils.ApplicationUtils;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class HomePageController {
    @FXML
    public Text result;
    @FXML
    private TextField numberOfDicesInput;
    @FXML
    private TextField numberOfFacesInput;
    @FXML
    private TextField numberOfRoundsInput;

    @FXML
    protected void onClear() {
        result.setText(DiceGameDefaults.INPUT_VALUE);
        numberOfDicesInput.setText(DiceGameDefaults.INPUT_VALUE);
        numberOfFacesInput.setText(DiceGameDefaults.INPUT_VALUE);
        numberOfRoundsInput.setText(DiceGameDefaults.INPUT_VALUE);
    }

    @FXML
    protected void onRollDice() {
        try {
            DiceGame diceGame = new DiceGame();
            Integer numberOfDices = getNumberOfDicesValue();
            Integer numberOfFaces = getNumberOfFacesValue();
            Integer numberOfRounds = getNumberOfRoundsValue();
            if (numberOfFaces != null) {
                diceGame.setNumberOfFaceVal(numberOfFaces);
                diceGame.setGameMode(GameMode.SINGLE_DICE);
            }
            if (numberOfDices != null) {
                diceGame.setNumberOfDiceVal(numberOfDices);
                diceGame.setGameMode(GameMode.MULTI_DICE);
            }
            if (numberOfRounds != null) {
                diceGame.setNumberOfRoundVal(numberOfRounds);
                diceGame.setGameMode(GameMode.MULTI_ROUND);
            }

            diceGame.buildGame();
            diceGame.playGame();
            result.setText(diceGame.getGameoutput());
        } catch (DiceGameException e) {
            showErrorOutput(e.getMessage());
        } catch (Exception e) {
            showErrorOutput(DiceGameDefaults.INVALID_INPUT_ERROR);
        }
    }

    public Integer getNumberOfDicesValue() {
        return ApplicationUtils.parseInputStringToNumber(numberOfDicesInput.getText());
    }

    public Integer getNumberOfFacesValue() {
        return ApplicationUtils.parseInputStringToNumber(numberOfFacesInput.getText());
    }

    public Integer getNumberOfRoundsValue() {
        return ApplicationUtils.parseInputStringToNumber(numberOfRoundsInput.getText());
    }

    public void showErrorOutput(String msg) {
        result.setText(msg + "\n" + "Total -> 0");
    }
}