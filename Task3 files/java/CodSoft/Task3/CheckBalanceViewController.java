package CodSoft.Task3;

import javafx.fxml.FXML;
import javafx.scene.text.Text;


public class CheckBalanceViewController {

    @FXML
    private Text checkBalanceField;

    private String accountNumber = "123412341234";

    @FXML
    public void initialize() {
        double currentAmount = UserDetails.getBalance(accountNumber);
        checkBalanceField.setText(String.valueOf(currentAmount));
    }
}
