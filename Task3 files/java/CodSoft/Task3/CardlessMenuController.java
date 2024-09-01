package CodSoft.Task3;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class CardlessMenuController {

    @FXML
    private TextField accountNumberField;

    @FXML
    private Button accountValidationButton;

    @FXML
    private Button accountClearButton;

    @FXML
    private Button accountCancelButton;

    public void initialize() {

        accountNumberField.addEventFilter(KeyEvent.KEY_TYPED, this::numericOnly);

        accountValidationButton.setDisable(true);

        accountNumberField.textProperty().addListener((observable, oldValue, newValue) -> {
            accountValidationButton.setDisable(newValue.length() != 12);
        });
    }

    private void numericOnly(KeyEvent event) {
        // limiting to numeric only input
        if (!event.getCharacter().matches("\\d")){
            event.consume();
        }

        // limiting to only 12 digit input
        if (accountNumberField.getText().length() >= 12) {
            event.consume();
        }
    }

    @FXML
    private void onAccountValidationButtonClicked() {
        if (UserDetails.accountValidation(accountNumberField.getText())) {
            Stage stage = (Stage) accountValidationButton.getScene().getWindow();
            SceneSwitcher.switchScene(stage, "showCardless-menu.fxml");
        }
        else {
            Stage stage = (Stage) accountValidationButton.getScene().getWindow();
            SceneSwitcher.switchScene(stage, "invalidAccountNumber-view.fxml");
        }
    }

    @FXML
    private void onAccountClearButtonClicked() {
        accountNumberField.clear();
    }

    @FXML
    private void onAccountCancelButtonClicked() {
        Stage stage = (Stage) accountCancelButton.getScene().getWindow();
        SceneSwitcher.switchScene(stage, "exitScreen-view.fxml");
        new Thread (()-> {
            try {
                Thread.sleep(3000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            Platform.exit();
        }).start();
    }
}
