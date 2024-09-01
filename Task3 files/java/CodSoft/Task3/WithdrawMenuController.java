package CodSoft.Task3;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class WithdrawMenuController {

    @FXML
    private TextField withdrawAmountField;

    @FXML
    private Button withdrawValidationButton;

    @FXML
    private Button withdrawClearButton;

    @FXML
    private Button withdrawCancelButton;

    private String accountNumber = "123412341234";

    public void initialize() {

        withdrawAmountField.addEventFilter(KeyEvent.KEY_TYPED, this::numericOnly);

        withdrawValidationButton.setDisable(true);

        // Disables the validation button until the entered amount is divisible by 100.
        withdrawAmountField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.isEmpty()) {
                withdrawValidationButton.setDisable(true);
            }
            try {
                int amount = Integer.parseInt(newValue);
                withdrawValidationButton.setDisable(amount <= 0 || amount % 100 != 0);
            } catch (NumberFormatException e) {
                withdrawValidationButton.setDisable(true);
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
    private void onWithdrawValidationButtonClicked() {
        double withdrawAmount = Double.parseDouble(withdrawAmountField.getText());
        double currentAmount = UserDetails.getBalance(accountNumber);

        if (withdrawAmount > currentAmount) {
            Stage stage = (Stage) withdrawValidationButton.getScene().getWindow();
            SceneSwitcher.switchScene(stage, "insufficientFunds-view.fxml");
        }
        
        else {
            UserDetails.withdraw(accountNumber, withdrawAmount);
            Stage stage = (Stage) withdrawValidationButton.getScene().getWindow();
            SceneSwitcher.switchScene(stage, "transactionSuccessful-view.fxml");
        }
    }
    @FXML
    private void onWithdrawClearButtonClicked() {
        withdrawAmountField.clear();
    }

    @FXML
    private void onWithdrawCancelButtonClicked() {
        Stage stage = (Stage) withdrawCancelButton.getScene().getWindow();
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
