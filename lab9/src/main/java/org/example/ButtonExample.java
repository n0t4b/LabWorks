package org.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ButtonExample extends Application {

    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button("Press me!");
        btn.setOnAction(e -> System.out.println("Button is used!"));

        TextField textField = new TextField();
        textField.setPromptText("Enter text here...");

        Button showTextButton = new Button("Show entered text");
        showTextButton.setOnAction(e -> System.out.println("Entered text: " + textField.getText()));

        VBox vbox = new VBox(10, btn, textField, showTextButton);
        vbox.setStyle("-fx-padding: 20px; -fx-alignment: center;");

        Scene scene = new Scene(vbox, 300, 250);

        primaryStage.setTitle("JavaFX Button and TextField");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
