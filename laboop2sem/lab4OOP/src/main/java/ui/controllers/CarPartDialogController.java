package ui.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.Auto;
import models.CarPart;
import services.AutoService;
import services.CarPartService;

import java.math.BigDecimal;
import java.util.List;

public class CarPartDialogController {

    @FXML
    private TextField carPartNameTextField;

    @FXML
    private TextField carPartPriceTextField;

    @FXML
    private ComboBox<Auto> autoComboBox;

    private Stage dialogStage;
    private CarPart carPart;
    private boolean okClicked = false;
    private CarPartService carPartService = new CarPartService();
    private AutoService autoService = new AutoService();

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public void setCarPart(CarPart carPart) {
        this.carPart = carPart;
    }

    public void initData() {
        List<Auto> autoList = autoService.findAllAutos();
        ObservableList<Auto> autos = FXCollections.observableArrayList(autoList);
        autoComboBox.setItems(autos);

        if (carPart != null) {
            carPartNameTextField.setText(carPart.getName());
            carPartPriceTextField.setText(carPart.getPrice().toString());
            autoComboBox.setValue(carPart.getAuto());
        }
    }

    @FXML
    private void handleOk(ActionEvent event) {
        if (isInputValid()) {
            if (carPart == null) {
                carPart = new CarPart();
            }
            carPart.setName(carPartNameTextField.getText());
            carPart.setPrice(new BigDecimal(carPartPriceTextField.getText()));
            carPart.setAuto(autoComboBox.getValue());

            carPartService.saveCarPart(carPart);
            okClicked = true;
            dialogStage.close();
        }
    }

    @FXML
    private void handleCancel(ActionEvent event) {
        dialogStage.close();
    }

    private boolean isInputValid() {
        String errorMessage = "";
        if (carPartNameTextField.getText() == null || carPartNameTextField.getText().isEmpty()) {
            errorMessage += "No valid car part name!\n";
        }
        if (carPartPriceTextField.getText() == null || carPartPriceTextField.getText().isEmpty()) {
            errorMessage += "No valid car part price!\n";
        } else {
            try {
                new BigDecimal(carPartPriceTextField.getText());
            } catch (NumberFormatException e) {
                errorMessage += "Invalid car part price (must be a number)!\n";
            }
        }
        if (autoComboBox.getValue() == null) {
            errorMessage += "No auto selected!\n";
        }
        if (errorMessage.isEmpty()) {
            return true;
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);
            alert.showAndWait();
            return false;
        }
    }
}