package vashchenko.ad231;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ProgrammerCalculatorApp extends Application {

    private TextField display;
    private MenuBar menuBar;
    private CalculatorButtonsPane buttonPane;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Програмістський Калькулятор");

        // Створюємо основні елементи інтерфейсу
        display = new TextField();
        display.setEditable(false);
        display.setPrefHeight(50);

        menuBar = MenuBarCreator.createMenuBar(this);
        buttonPane = new CalculatorButtonsPane(this);

        // Основне розташування
        VBox mainLayout = new VBox(menuBar, display, buttonPane.getButtonPane());
        Scene scene = new Scene(mainLayout, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Метод для обробки натискань кнопок калькулятора
    public void handleButtonPress(String text) {
        display.appendText(text + " ");
    }

    // Метод для відкриття аркуша «Автолізинг»
    public void openLeasingSheet() {
        LeasingSheet leasingSheet = new LeasingSheet();
        leasingSheet.show();
    }
}
