package ui.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import models.Auto;
import models.CarPart;
import services.CarPartService;
import services.AutoService;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.util.ResourceBundle;

public class CarPartManagementController implements Initializable {

    @FXML
    private TableView<CarPart> carPartTable;

    @FXML
    private TableColumn<CarPart, Integer> carPartIdColumn;

    @FXML
    private TableColumn<CarPart, String> carPartNameColumn;

    @FXML
    private TableColumn<CarPart, BigDecimal> carPartPriceColumn;

    @FXML
    private TableColumn<CarPart, String> autoColumn;

    private CarPartService carPartService = new CarPartService();
    private AutoService autoService = new AutoService();
    private ObservableList<CarPart> carPartObservableList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        carPartIdColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        carPartNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        carPartPriceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        // autoColumn.setCellValueFactory(cellData -> cellData.getValue().getAuto().getModel()); // Removed

        loadCarParts();
    }

    private void loadCarParts() {
        carPartObservableList.clear();
        carPartObservableList.addAll(carPartService.findAllCarParts());
        carPartTable.setItems(carPartObservableList);
    }

    @FXML
    public void createCarPart(ActionEvent event) throws IOException {
        showCarPartDialog(null);
    }

    @FXML
    public void deleteCarPart(ActionEvent event) {
        CarPart selectedCarPart = carPartTable.getSelectionModel().getSelectedItem();
        if (selectedCarPart != null) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirm Deletion");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure you want to delete this car part?");
            alert.showAndWait().ifPresent(response -> {
                if (response == ButtonType.OK) {
                    carPartService.deleteCarPart(selectedCarPart);
                    loadCarParts();
                }
            });
        } else {
            showAlert("No Car Part Selected", "Please select a car part to delete.");
        }
    }

    private void showCarPartDialog(CarPart carPart) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ui/CarPartDialog.fxml")); // Путь к FXML
        GridPane page = loader.load();
        CarPartDialogController controller = loader.getController();
        controller.setDialogStage(new Stage());
        controller.setCarPart(carPart);
        controller.initData();

        Stage dialogStage = new Stage();
        dialogStage.setTitle(carPart == null ? "Create Car Part" : "Edit Car Part");
        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage.initOwner(carPartTable.getScene().getWindow());
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);
        controller.setDialogStage(dialogStage);
        dialogStage.showAndWait();

        loadCarParts();
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}