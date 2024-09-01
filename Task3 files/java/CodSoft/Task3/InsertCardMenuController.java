package CodSoft.Task3;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class InsertCardMenuController {

    @FXML
    private PasswordField pinField;

    @FXML
    private Button pinValidationButton;

    @FXML
    private Button pinClearButton;

    @FXML
    private Button pinCancelButton;

    private final String accountNumber = "123412341234";

    public void initialize() {

        pinField.addEventFilter(KeyEvent.KEY_TYPED, this::numericOnly);

        // setting button disable
        pinValidationButton.setDisable(true);

        // setting button disable until the text length reaches 4
        pinField.textProperty().addListener((observable, oldValue, newValue) -> {
            pinValidationButton.setDisable(newValue.length() != 4);
        });
    }

    private void numericOnly(KeyEvent event) {

        // limiting to numeric digit only
        if (!event.getCharacter().matches("\\d")) {
            event.consume();
        }

        // limiting the digit to 4 unit
        if (pinField.getText().length() >= 4) {
            event.consume();
        }
    }

    @FXML
    private void onPinValidationButtonClicked() {
        String enterPin = pinField.getText();
        if (UserDetails.pinValidation(accountNumber, enterPin)) {
            Stage stage = (Stage) pinValidationButton.getScene().getWindow();
            SceneSwitcher.switchScene(stage, "showCard-menu.fxml");
        }
        else {
            Stage stage = (Stage) pinValidationButton.getScene().getWindow();
            SceneSwitcher.switchScene(stage, "invalidPin-view.fxml");
        }
    }

    @FXML
    private void onPinClearButtonClicked() {
        // Clears the pinField on clicking clear
        pinField.clear();
    }

    @FXML
    private void onPinCancelButtonClicked() {
        Stage stage = (Stage) pinCancelButton.getScene().getWindow();
        SceneSwitcher.switchScene(stage, "exitScreen-view.fxml");

        new Thread (() -> {
            try {
                Thread.sleep(3000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            Platform.exit();
        }).start();
    }
}
