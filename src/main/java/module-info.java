module com.docs.roller.game.diceapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.docs.roller.game.diceapp to javafx.fxml;
    exports com.docs.roller.game.diceapp;
    exports com.docs.roller.game.diceapp.exception;
    opens com.docs.roller.game.diceapp.exception to javafx.fxml;
}