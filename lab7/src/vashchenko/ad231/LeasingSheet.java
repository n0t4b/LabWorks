package vashchenko.ad231;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class LeasingSheet extends Stage {

    public LeasingSheet() {
        setTitle("Аркуш Автолізингу");

        Label carPriceLabel = new Label("Вартість авто:");
        TextField carPriceField = new TextField();

        Label initialPaymentLabel = new Label("Початковий внесок:");
        TextField initialPaymentField = new TextField();

        Label interestRateLabel = new Label("Відсоткова ставка:");
        TextField interestRateField = new TextField();

        Label termLabel = new Label("Термін лізингу (місяці):");
        TextField termField = new TextField();

        Button calculateButton = new Button("Обчислити");
        Label resultLabel = new Label();

        calculateButton.setOnAction(e -> {
            double price = Double.parseDouble(carPriceField.getText());
            double initialPayment = Double.parseDouble(initialPaymentField.getText());
            double interestRate = Double.parseDouble(interestRateField.getText()) / 100;
            int term = Integer.parseInt(termField.getText());

            double monthlyPayment = calculateLeasing(price, initialPayment, interestRate, term);
            resultLabel.setText("Місячний платіж: " + String.format("%.2f", monthlyPayment) + " грн");
        });

        GridPane leasingPane = new GridPane();
        leasingPane.setPadding(new Insets(10));
        leasingPane.setHgap(5);
        leasingPane.setVgap(5);
        leasingPane.add(carPriceLabel, 0, 0);
        leasingPane.add(carPriceField, 1, 0);
        leasingPane.add(initialPaymentLabel, 0, 1);
        leasingPane.add(initialPaymentField, 1, 1);
        leasingPane.add(interestRateLabel, 0, 2);
        leasingPane.add(interestRateField, 1, 2);
        leasingPane.add(termLabel, 0, 3);
        leasingPane.add(termField, 1, 3);
        leasingPane.add(calculateButton, 0, 4);
        leasingPane.add(resultLabel, 1, 4);

        Scene leasingScene = new Scene(leasingPane, 300, 250);
        setScene(leasingScene);
    }

    // Метод для обчислення лізингових виплат
    private double calculateLeasing(double price, double initialPayment, double interestRate, int term) {
        double financedAmount = price - initialPayment;
        double monthlyInterest = interestRate / 12;
        return (financedAmount * monthlyInterest) / (1 - Math.pow(1 + monthlyInterest, -term));
    }
}


