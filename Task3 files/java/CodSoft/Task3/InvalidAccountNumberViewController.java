package CodSoft.Task3;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class InvalidAccountNumberViewController {

    @FXML
    private Button yes;

    @FXML
    private Button no;

    @FXML
    private void onYesButtonClicked() {
        Stage stage = (Stage) yes.getScene().getWindow();
        SceneSwitcher.switchScene(stage, "cardless-menu.fxml");
    }

    @FXML
    private void onNoButtonClicked() {
        Stage stage = (Stage) no.getScene().getWindow();
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
