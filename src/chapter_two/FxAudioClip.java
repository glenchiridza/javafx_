package chapter_two;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by glenc on Jul 2021
 **/
public class FxAudioClip extends Application {

    public static void main(String[] args) {

        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {


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
}