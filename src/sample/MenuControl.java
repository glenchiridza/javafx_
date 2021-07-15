package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Created by glenc on Jul 2021
 **/


public class MenuControl extends Application {

    Label messageLabel = new Label("Press the Button");

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception{

        MenuItem ford =  new MenuItem("FORD");

        ford.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                printMessage("You chose ford");
            }
        });

        MenuItem audi =  new MenuItem("AUDI");
        audi.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                printMessage("You selected Audi");
            }
        });

        MenuItem ferrari =  new MenuItem("Ferrari");
        ferrari.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                printMessage("You have selected ferrari");
            }
        });

        MenuButton  cars = new MenuButton("Select");
        cars.getItems().addAll(ford,audi,ferrari);

        VBox root =  new VBox();
        root.getChildren().addAll(messageLabel,cars);
        root.setMinSize(350,350);




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
        stage.setTitle("Menu Control");
        stage.show();
    }


    public void printMessage(String msg){
        messageLabel.setText(msg);
    }
}
