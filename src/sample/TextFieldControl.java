package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Created by glenc on Jul 2021
 **/


public class TextFieldControl extends Application {

    //create message label
    Label messageLabel = new Label("ENter you Name in to Field");

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception{

        TextField firstNameFld = new TextField();
        TextField lastNameFld = new TextField();

        firstNameFld.setPrefColumnCount(15);
        lastNameFld.setPrefColumnCount(15);

        firstNameFld.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                printMessage("You Have changed your First Name");
            }
        });

        lastNameFld.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                printMessage("You have change your surname");
            }
        });

        GridPane root = new GridPane();

        root.setHgap(10);
        root.setVgap(5);

        root.addRow(0, messageLabel);
        root.addRow(1, new Label("First Name"), firstNameFld);
        root.addRow(2, new Label("Last Name"), lastNameFld);

        root.setMinSize(350, 250);


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

        stage.setTitle("Text Area Practice");

        stage.show();


    }

    private void printMessage(String msg) {

        messageLabel.setText(msg);
    }


}
