package CodSoft.Task3;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class TransactionSuccessfulViewController {

    @FXML
    private Button yes;

    @FXML
    private Button no;

    @FXML
    private void onYesButtonClicked() {
        Stage stage = (Stage) yes.getScene().getWindow();
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
    private void onNoButtonClicked() {
        Stage stage = (Stage) no.getScene().getWindow();
        SceneSwitcher.switchScene(stage, "exitScreen-view.fxml");

        new Thread(()  -> {
            try {
                Thread.sleep(3000);
            } catch (Exception e) {
                e.printStackTrace();
            }Platform.exit();
        }).start();
    }
}
