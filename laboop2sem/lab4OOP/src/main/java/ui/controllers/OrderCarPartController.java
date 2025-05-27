package ui.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class OrderCarPartController {

    @FXML
    public void showOrderWindow(ActionEvent event) throws IOException {
        showManageWindow("Order Management", "/ui/OrderManagement.fxml"); // Путь к FXML
    }

    @FXML
    public void showCarPartWindow(ActionEvent event) throws IOException {
        showManageWindow("Car Part Management", "/ui/CarPartManagement.fxml"); // Путь к FXML
    }

    private void showManageWindow(String title, String fxmlFile) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
        VBox root = loader.load();
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle(title);
        stage.setScene(new Scene(root, 600, 400));
        stage.showAndWait();
    }
}