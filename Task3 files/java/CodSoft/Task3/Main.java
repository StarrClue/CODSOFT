package CodSoft.Task3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        primaryStage.setTitle("ATM Interface");

        FXMLLoader mainScreenLoader = new FXMLLoader(getClass().getResource("main-menu.fxml"));
        Parent mainScreenRoot = mainScreenLoader.load();
        Scene mainScreenScene = new Scene(mainScreenRoot, 600, 400);


        primaryStage.setResizable(false);
        primaryStage.setScene(mainScreenScene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
