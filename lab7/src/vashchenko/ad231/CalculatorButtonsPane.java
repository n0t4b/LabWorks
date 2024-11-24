package vashchenko.ad231;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class CalculatorButtonsPane {

    private GridPane buttonPane;

    public CalculatorButtonsPane(ProgrammerCalculatorApp app) {
        buttonPane = new GridPane();
        buttonPane.setPadding(new Insets(10));
        buttonPane.setHgap(5);
        buttonPane.setVgap(5);

        String[] buttons = {
                "HEX", "DEC", "OCT", "BIN",
                "A", "B", "C", "D", "E", "F",
                "7", "8", "9", "AND", "OR",
                "4", "5", "6", "XOR", "NOT",
                "1", "2", "3", "LSH", "RSH",
                "0", "=", "+", "-", "*", "/"
        };

        int row = 0;
        int col = 0;
        for (String text : buttons) {
            Button button = new Button(text);
            button.setPrefSize(60, 40);
            button.setOnAction(e -> app.handleButtonPress(text));
            buttonPane.add(button, col, row);
            col++;
            if (col == 5) {
                col = 0;
                row++;
            }
        }
    }

    public GridPane getButtonPane() {
        return buttonPane;
    }
}
