package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

/**
 * Created by glenc on Jul 2021
 **/
public class ListViewControl extends Application {

    Label selectionLabel = new Label("Your selection: None");
    public static void main(String[] args) {

        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {

        ListView<String> cars = new ListView<>();

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
