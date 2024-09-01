package CodSoft.Task3;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ShowCardMenuController {

    @FXML
    private Text cardWithdraw;

    @FXML
    private Text cardDeposit;

    @FXML
    private Text cardCheckBalance;

    @FXML
    private Text cardPinChange;

    @FXML
    private void onCardWithdrawClicked() {
        Stage stage = (Stage) cardWithdraw.getScene().getWindow();
        SceneSwitcher.switchScene(stage, "withdraw-menu.fxml");
    }

    @FXML
    private void onCardDepositClicked() {
        Stage stage = (Stage) cardDeposit.getScene().getWindow();
        SceneSwitcher.switchScene(stage, "deposit-menu.fxml");
    }

    @FXML
    private void onCardCheckBalanceClicked() {
        Stage stage = (Stage) cardCheckBalance.getScene().getWindow();
        SceneSwitcher.switchScene(stage, "checkBalance-view.fxml");

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
    private void onPinChangeClicked() {
        Stage stage = (Stage) cardPinChange.getScene().getWindow();
        SceneSwitcher.switchScene(stage, "pinChange-menu.fxml");
    }
}
