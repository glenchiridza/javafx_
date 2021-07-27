package chapter_one;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


/**
 * Created by glenc on Jul 2021
 **/


public class Controls extends Application {

    @Override
    public void start(Stage stage) throws Exception{

        TextField firstNameFld = new TextField();
        TextField lastNameFld = new TextField();

        Label firstNameLbl = new Label("_First Name");
        Label lastNameLbl = new Label("_Last Name");

        firstNameLbl.setLabelFor(firstNameFld);
        firstNameLbl.setMnemonicParsing(true);

        lastNameLbl.setLabelFor(lastNameFld);
        lastNameLbl.setMnemonicParsing(true);

        GridPane root = new GridPane();
        root.addRow(0, firstNameLbl, firstNameFld);
        root.addRow(1, lastNameLbl, lastNameFld);

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
        stage.setTitle("Label Example");
        stage.show();




    }


    public static void main(String[] args) {
        launch(args);
    }
}
