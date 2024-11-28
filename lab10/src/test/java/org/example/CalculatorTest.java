package org.example;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import io.qameta.allure.*;
import javafx.stage.Stage;
import org.testfx.framework.junit.ApplicationTest;
import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.matcher.control.TextInputControlMatchers.hasText;

public class CalculatorTest extends ApplicationTest {

    private Calculator calculator;

    @Override
    public void start(Stage stage) throws Exception {
        new CalculatorApp().start(stage);
    }

    @Before
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    @Description("Test for addition")
    @Severity(SeverityLevel.CRITICAL)
    @Feature("Arithmetic Operations")
    @Story("Addition")
    @Step("Performing addition test")
    public void testAdd() {
        double result = calculator.add(2.0, 3.0);
        assertEquals(5.0, result, 0.001);
    }

    @Test
    @Description("Test for subtraction")
    @Severity(SeverityLevel.NORMAL)
    @Feature("Arithmetic Operations")
    @Story("Subtraction")
    @Step("Performing subtraction test")
    public void testSubtract() {
        double result = calculator.subtract(3.0, 2.0);
        assertEquals(1.0, result, 0.001);
    }

    @Test
    @Description("Test for multiplication")
    @Severity(SeverityLevel.MINOR)
    @Feature("Arithmetic Operations")
    @Story("Multiplication")
    @Step("Performing multiplication test")
    public void testMultiply() {
        double result = calculator.multiply(2.0, 3.0);
        assertEquals(6.0, result, 0.001);
    }

    @Test
    @Description("Test for division")
    @Severity(SeverityLevel.CRITICAL)
    @Feature("Arithmetic Operations")
    @Story("Division")
    @Step("Performing division test")
    public void testDivide() {
        double result = calculator.divide(6.0, 3.0);
        assertEquals(2.0, result, 0.001);
    }

    @Test
    @Description("Test for square root")
    @Severity(SeverityLevel.NORMAL)
    @Feature("Advanced Operations")
    @Story("Square Root")
    @Step("Performing square root test")
    public void testSqrt() {
        double result = calculator.sqrt(16.0);
        assertEquals(4.0, result, 0.001);
    }

    @Test
    @Description("Test for power operation")
    @Severity(SeverityLevel.NORMAL)
    @Feature("Advanced Operations")
    @Story("Power")
    @Step("Performing power operation test")
    public void testPower() {
        double result = calculator.power(2.0, 3.0);
        assertEquals(8.0, result, 0.001);
    }


    @Test(expected = IllegalArgumentException.class)
    @Description("Test for division by zero")
    @Severity(SeverityLevel.BLOCKER)
    @Feature("Arithmetic Operations")
    @Story("Division")
    public void testDivideByZero() {
        calculator.divide(5.0, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    @Description("Test for square root of negative number")
    @Severity(SeverityLevel.BLOCKER)
    @Feature("Advanced Operations")
    @Story("Square Root")
    public void testSqrtOfNegative() {
        calculator.sqrt(-1.0);
    }


    @Test
    @Description("Test GUI addition")
    @Severity(SeverityLevel.CRITICAL)
    @Feature("GUI Testing")
    @Story("Addition")
    public void testGUIAddition() {
        clickOn("#button1");
        clickOn("#buttonPlus");
        clickOn("#button2");
        clickOn("#buttonEquals");

        verifyThat("#resultField", hasText("3"));
    }

    @Test
    @Description("Test GUI multiplication")
    @Severity(SeverityLevel.CRITICAL)
    @Feature("GUI Testing")
    @Story("Multiplication")
    public void testGUIMultiplication() {
        clickOn("#button3");
        clickOn("#buttonMultiply");
        clickOn("#button4");
        clickOn("#buttonEquals");

        verifyThat("#resultField", hasText("12"));
    }
}

