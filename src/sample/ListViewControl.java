package sample;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
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
        cars.getItems().addAll("Ford","Ferrari","Porsche");

        cars.getSelectionModel().selectFirst();

        cars.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String t1, String t2) {
                selectionLabel.setText("You selected: "+t2);
            }
        });

        GridPane root =  new GridPane();
        root.setVgap(10);
        root.setHgap(10);
        root.addRow(0,cars);
        root.addRow(1,selectionLabel);
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
        stage.setTitle("ListView");
        stage.show();

    }
}
