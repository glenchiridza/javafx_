package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


/**
 * Created by glenc on Jul 2021
 **/


public class Controls extends Application {

    @Override
    public void start(Stage stage) throws Exception{

        TextField firstNameFld = new TextField();
        TextField lastNameFld = new TextField();

        Label firstNameLbl = new Label();
        Label lastNameLbl = new Label();

        firstNameLbl.setLabelFor(firstNameFld);
        firstNameLbl.setMnemonicParsing(true);

        lastNameLbl.setLabelFor(lastNameFld);
        lastNameLbl.setMnemonicParsing(true);






    }


    public static void main(String[] args) {
        launch(args);
    }
}
