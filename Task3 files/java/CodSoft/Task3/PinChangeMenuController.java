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

public class PinChangeMenuController {

    @FXML
    private TextField pinField;

    @FXML
    private Button pinValidationButton;

    @FXML
    private Button pinClearButton;

    @FXML
    private Button pinCancelButton;

    private String accountNumber = "123412341234";

    public void initialize() {

        pinField.addEventFilter(KeyEvent.KEY_TYPED, this::numericOnly);

        pinValidationButton.setDisable(true);

        pinField.textProperty().addListener((observable, oldValue, newValue) -> {
           pinValidationButton.setDisable(newValue.length() != 4);
        });
    }

    private void numericOnly(KeyEvent event) {

        if (!event.getCharacter().matches("\\d")) {
            event.consume();
        }

        if (pinField.getText().length() >= 4) {
            event.consume();
        }
    }

    @FXML
    private void onPinValidationButtonClicked() {
        String enterPin = pinField.getText();
        UserDetails.pinUpdate(accountNumber, enterPin);

        Stage stage = (Stage) pinValidationButton.getScene().getWindow();
        SceneSwitcher.switchScene(stage, "pinChangedSuccessfully-view.fxml");

        new Thread(() -> {
            try {
                Thread.sleep(3000);
                Platform.runLater(() -> {
                    try {
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("exitScreen-view.fxml"));
                        Parent root = loader.load();
                        Scene scene = new Scene(root, 600, 400);
                        stage.setScene(scene);
                        Thread.sleep(3000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }Platform.exit();
        }).start();
    }

    @FXML
    private void onPinClearButtonClicked() {
        pinField.clear();
    }

    @FXML
    private void onPinCancelButtonClicked() {
        Stage stage = (Stage) pinCancelButton.getScene().getWindow();
        SceneSwitcher.switchScene(stage, "exitScreen-view.fxml");

        new Thread(() -> {
            try {
                Thread.sleep(3000);
            } catch (Exception e) {
                e.printStackTrace();
            }Platform.exit();
        }).start();
    }
}
