package vashchenko.ad231;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

public class MenuBarCreator {

    public static MenuBar createMenuBar(ProgrammerCalculatorApp app) {
        MenuBar menuBar = new MenuBar();

        Menu viewMenu = new Menu("Вигляд");
        Menu sheetsMenu = new Menu("Листи");

        MenuItem leasingSheet = new MenuItem("Автолізинг");
        leasingSheet.setOnAction(e -> app.openLeasingSheet());

        sheetsMenu.getItems().add(leasingSheet);
        viewMenu.getItems().add(sheetsMenu);
        menuBar.getMenus().add(viewMenu);

        return menuBar;
    }
}
