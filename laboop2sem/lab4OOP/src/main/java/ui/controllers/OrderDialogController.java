package ui.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.Order;
import models.User;
import services.OrderService;
import services.UserService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class OrderDialogController {

    @FXML
    private DatePicker orderDatePicker;

    @FXML
    private TextField totalAmountTextField;

    @FXML
    private ComboBox<User> userComboBox;

    private Stage dialogStage;
    private Order order;
    private boolean okClicked = false;
    private OrderService orderService = new OrderService();
    private UserService userService = new UserService();

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public void initData() {
        List<User> userList = userService.findAllUsers();
        ObservableList<User> users = FXCollections.observableArrayList(userList);
        userComboBox.setItems(users);

        if (order != null) {
            orderDatePicker.setValue(order.getOrderDate());
            totalAmountTextField.setText(order.getTotalAmount().toString());
            userComboBox.setValue(order.getUser());
        }
    }

    @FXML
    private void handleOk(ActionEvent event) {
        if (isInputValid()) {
            if (order == null) {
                order = new Order();
            }
            order.setOrderDate(orderDatePicker.getValue());
            order.setTotalAmount(new BigDecimal(totalAmountTextField.getText()));
            order.setUser(userComboBox.getValue());

            orderService.saveOrder(order);
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
        if (orderDatePicker.getValue() == null) {
            errorMessage += "No valid order date!\n";
        }
        if (totalAmountTextField.getText() == null || totalAmountTextField.getText().isEmpty()) {
            errorMessage += "No valid total amount!\n";
        } else {
            try {
                new BigDecimal(totalAmountTextField.getText());
            } catch (NumberFormatException e) {
                errorMessage += "Invalid total amount (must be a number)!\n";
            }
        }
        if (userComboBox.getValue() == null) {
            errorMessage += "No user selected!\n";
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