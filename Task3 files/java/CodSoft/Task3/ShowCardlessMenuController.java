package CodSoft.Task3;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ShowCardlessMenuController {

    @FXML
    private Text cardlessWithdraw;

    @FXML
    private Text cardlessDeposit;

    @FXML
    private Text cardlessCheckBalance;

    @FXML
    private void onCardlessWithdrawClicked() {
        Stage stage = (Stage) cardlessWithdraw.getScene().getWindow();
        SceneSwitcher.switchScene(stage, "withdraw-menu.fxml");
    }

    @FXML
    private void onCardlessDepositClicked() {
        Stage stage = (Stage) cardlessDeposit.getScene().getWindow();
        SceneSwitcher.switchScene(stage, "deposit-menu.fxml");
    }

    @FXML
    private void onCardlessCheckBalanceClicked() {
        Stage stage = (Stage) cardlessCheckBalance.getScene().getWindow();
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
}
