package CodSoft.Task3;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class DepositMenuController {

    @FXML
    private TextField depositAmountField;

    @FXML
    private Button depositValidationButton;

    @FXML
    private Button depositClearButton;

    @FXML
    private Button depositCancelButton;

    private String accountNumber = "123412341234";

    public void initialize() {

        depositAmountField.addEventFilter(KeyEvent.KEY_TYPED, this::numericOnly);

        depositValidationButton.setDisable(true);

        // Disables the validation button until the entered amount is divisible by 100.
        depositAmountField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.isEmpty()) {
                depositValidationButton.setDisable(true);
            }
            try {
                int amount = Integer.parseInt(newValue);
               depositValidationButton.setDisable(amount <= 0 || amount % 100 != 0);
            } catch (NumberFormatException e) {
                depositValidationButton.setDisable(true);
            }
        });
    }

    private void numericOnly(KeyEvent event) {
        // allow only to enter digit
        if (!event.getCharacter().matches("\\d")) {
            event.consume();
        }
    }

    @FXML
    private void depositValidationButtonClicked() {
        double depositAmount = Double.parseDouble(depositAmountField.getText());

        UserDetails.deposit(accountNumber, depositAmount);

        Stage stage = (Stage) depositValidationButton.getScene().getWindow();
        SceneSwitcher.switchScene(stage, "transactionSuccessful-view.fxml");
    }

    @FXML
    private void depositClearButtonClicked() {
        depositAmountField.clear();
    }

    @FXML
    private void depositCancelButtonClicked() {
        Stage stage = (Stage) depositCancelButton.getScene().getWindow();
        SceneSwitcher.switchScene(stage, "exitScreen-view.fxml");

        new Thread(() -> {
            try {
                Thread.sleep(3000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            Platform.exit();
        }).start();
    }
}
