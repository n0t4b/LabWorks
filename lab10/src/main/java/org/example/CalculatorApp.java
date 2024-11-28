package org.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CalculatorApp extends Application {
    private Calculator calculator = new Calculator();
    private TextField resultField;
    private String operator = "";
    private double firstOperand = 0;

    @Override
    public void start(Stage stage) {
        resultField = new TextField();
        resultField.setEditable(false);
        resultField.setId("resultField");

        Button button1 = new Button("1");
        button1.setId("button1");
        button1.setOnAction(e -> appendToResult("1"));

        Button button2 = new Button("2");
        button2.setId("button2");
        button2.setOnAction(e -> appendToResult("2"));

        Button button3 = new Button("3");
        button3.setId("button3");
        button3.setOnAction(e -> appendToResult("3"));

        Button button4 = new Button("4");
        button4.setId("button4");
        button4.setOnAction(e -> appendToResult("4"));

        Button buttonPlus = new Button("+");
        buttonPlus.setId("buttonPlus");
        buttonPlus.setOnAction(e -> setOperator("+"));

        Button buttonMultiply = new Button("*");
        buttonMultiply.setId("buttonMultiply");
        buttonMultiply.setOnAction(e -> setOperator("*"));

        Button buttonEquals = new Button("=");
        buttonEquals.setId("buttonEquals");
        buttonEquals.setOnAction(e -> calculateResult());

        VBox layout = new VBox(10);
        layout.getChildren().addAll(resultField, button1, button2, button3, button4, buttonPlus, buttonMultiply, buttonEquals);

        Scene scene = new Scene(layout, 200, 300);
        stage.setScene(scene);
        stage.setTitle("Calculator");
        stage.show();
    }

    private void appendToResult(String value) {
        resultField.appendText(value);
    }

    private void setOperator(String op) {
        firstOperand = Double.parseDouble(resultField.getText());
        operator = op;
        resultField.clear();
    }

    private void calculateResult() {
        double secondOperand = Double.parseDouble(resultField.getText());
        double result;

        switch (operator) {
            case "+":
                result = calculator.add(firstOperand, secondOperand);
                break;
            case "*":
                result = calculator.multiply(firstOperand, secondOperand);
                break;
            default:
                throw new UnsupportedOperationException("Unsupported operation: " + operator);
        }

        if (result % 1 == 0) {
            resultField.setText(String.valueOf((int) result));
        } else {
            resultField.setText(String.valueOf(result));
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}