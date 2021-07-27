package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Created by glenc on Jul 2021
 **/
public class MenuExampleControl extends Application {

    Label messageLbl = new Label("Press any menu item to see message");
    public static void main(String[] args) {

        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {

        //create the menus
        Menu fileMenu = new Menu("File");
        Menu editMenu = new Menu("Edit");

        //create the MenuItem New
        MenuItem newItem = new MenuItem("New");
        newItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                printMessage("You pressed the new Menu Item");
            }
        });

        MenuItem openItem = new MenuItem("Open");
        openItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                printMessage("You pressed the open Menu Item");
            }
        });

        fileMenu.getItems().addAll(newItem,openItem);

        //create menu item copy
        MenuItem copyItem = new MenuItem("Copy");
        copyItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                printMessage("You press the copy menu item");
            }
        });

        MenuItem pasteItem = new MenuItem("Paste");
        pasteItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                printMessage("You pressed the paste menu item");
            }
        });

        //add the menu items to the menu
        editMenu.getItems().addAll(copyItem,pasteItem);


        //Now create the Menu Bar
        MenuBar menuBar  = new MenuBar();
        //add menus to it
        menuBar.getMenus().addAll(fileMenu,editMenu);

        //create the menu Box
        HBox menu = new HBox();
        menu.getChildren().add(menuBar);

        //create the vertical box
        VBox root = new VBox();
        root.getChildren().addAll(menu,messageLbl);
        root.setMinSize(450,450);

        //set the styling
        root.setStyle(
                "-fx-padding: 10;" +
                        "-fx-border-style:solid inside;"+
                        "-fx-border-width:2;"+
                        "-fx-border-insets: 5;"+
                        "-fx-border-radius:5;"+
                        "-fx-border-color:blue;"
        );
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("ListView");
        stage.show();

    }

    private void printMessage(String s) {
        messageLbl.setText(s);
    }
}
