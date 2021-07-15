package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Created by glenc on Jul 2021
 **/

public class ButtonControl extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception{



        root.setStyle(
                "-fx-padding: 10;" +
                        "-fx-border-style:solid inside;"+
                        "-fx-border-width:2;"+
                        "-fx-border-insets: 5;"+
                        "-fx-border-radius:5;"+
                        "-fx-border-color:blue;"
        );
    }


    public static void main(String[] args) {
        launch(args);
    }
}
