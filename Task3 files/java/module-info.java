module CodSoft.Task3 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires java.sql;
    requires mysql.connector.j;


    opens CodSoft.Task3 to javafx.fxml;
    exports CodSoft.Task3;
}