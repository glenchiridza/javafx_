package sample;

import javafx.application.Application;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Created by glenc on Jul 2021
 **/


public class TextFieldControl extends Application {

    //create message label
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception{

        TextField firstNameFld = new TextField();
        TextField lastNameFld = new TextField();


        root.setMinSize(350, 250);

        root.setStyle(
                "-fx-padding: 10;" +
                        "-fx-border-style:solid inside;"+
                        "-fx-border-width:2;"+
                        "-fx-border-insets: 5;"+
                        "-fx-border-radius:5;"+
                        "-fx-border-color:blue;"
        );



    }


}
