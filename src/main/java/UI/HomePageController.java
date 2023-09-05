package UI;

import PD.ApplicationUtils;
import PD.DiceGame;
import PD.DiceGameDefaults;
import PD.DiceGameException;
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
    protected void onClear() {
        result.setText(DiceGameDefaults.INPUT_VALUE);
        numberOfDicesInput.setText(DiceGameDefaults.INPUT_VALUE);
        numberOfFacesInput.setText(DiceGameDefaults.INPUT_VALUE);
    }

    @FXML
    protected void onRollDice() {
        try {
            DiceGame diceGame = new DiceGame();
            Integer numberOfDices = getNumberOfDicesValue();
            Integer numberOfFaces = getNumberOfFacesValue();
            if (numberOfFaces != null) {
                diceGame.setNumberOfFaceVal(numberOfFaces);
            }
            if (numberOfDices != null) {
                diceGame.setNumberOfDiceVal(numberOfDices);
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

    public void showErrorOutput(String msg) {
        result.setText(msg + "\n" + "Total -> 0");
    }
}