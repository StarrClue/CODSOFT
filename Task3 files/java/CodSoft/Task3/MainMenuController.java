package CodSoft.Task3;

import javafx.fxml.FXML;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MainMenuController {

    @FXML
    private Text insertCard;

    @FXML
    private Text cardlessTransaction;


    @FXML
    private void onInsertCardClicked() {
        Stage stage = (Stage) insertCard.getScene().getWindow();
        SceneSwitcher.switchScene(stage, "insertCard-menu.fxml");
    }

    @FXML
    private void onCardlessTransactionClicked() {
        Stage stage = (Stage) cardlessTransaction.getScene().getWindow();
        SceneSwitcher.switchScene(stage, "cardless-menu.fxml");
    }
}
