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
import models.Order;
import services.OrderService;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class OrderManagementController implements Initializable {

    @FXML
    private TableView<Order> orderTable;

    @FXML
    private TableColumn<Order, Integer> orderIdColumn;

    @FXML
    private TableColumn<Order, LocalDate> orderDateColumn;

    @FXML
    private TableColumn<Order, Double> totalAmountColumn; // Assuming double, adjust if BigDecimal

    @FXML
    private TableColumn<Order, String> userColumn;

    private OrderService orderService = new OrderService();
    private ObservableList<Order> orderObservableList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        orderIdColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        orderDateColumn.setCellValueFactory(new PropertyValueFactory<>("orderDate"));
        totalAmountColumn.setCellValueFactory(new PropertyValueFactory<>("totalAmount"));
        // userColumn.setCellValueFactory(cellData -> cellData.getValue().getUser().getName()); // Removed

        loadOrders();
    }

    private void loadOrders() {
        orderObservableList.clear();
        orderObservableList.addAll(orderService.findAllOrders());
        orderTable.setItems(orderObservableList);
    }

    @FXML
    public void createOrder(ActionEvent event) throws IOException {
        showOrderDialog(null);
    }

    @FXML
    public void deleteOrder(ActionEvent event) {
        Order selectedOrder = orderTable.getSelectionModel().getSelectedItem();
        if (selectedOrder != null) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirm Deletion");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure you want to delete this order?");
            alert.showAndWait().ifPresent(response -> {
                if (response == ButtonType.OK) {
                    orderService.deleteOrder(selectedOrder);
                    loadOrders();
                }
            });
        } else {
            showAlert("No Order Selected", "Please select an order to delete.");
        }
    }

    private void showOrderDialog(Order order) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ui/OrderDialog.fxml")); // Путь к FXML
        GridPane page = loader.load();
        OrderDialogController controller = loader.getController();
        controller.setDialogStage(new Stage());
        controller.setOrder(order);
        controller.initData();

        Stage dialogStage = new Stage();
        dialogStage.setTitle(order == null ? "Create Order" : "Edit Order");
        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage.initOwner(orderTable.getScene().getWindow());
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);
        controller.setDialogStage(dialogStage);
        dialogStage.showAndWait();

        loadOrders();
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}