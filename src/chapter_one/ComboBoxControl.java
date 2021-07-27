package chapter_one;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Created by glenc on Jul 2021
 **/
public class ComboBoxControl extends Application {

    Label selectionLbl = new Label("Your selection: None");
    public static void main(String[] args) {

        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {


        Label carLabel = new Label("Car:");

        ComboBox<String> cars = new ComboBox<>();
        cars.getItems().addAll("FOrd","Audi","Porsche");

        cars.getSelectionModel().selectFirst();

        cars.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String oldValue, String newValue) {
                selectionLbl.setText("Your Selection: "+newValue);
            }
        });

        HBox carBox = new HBox();
        carBox.getChildren().addAll(carLabel,cars);
        carBox.setSpacing(10);

        VBox root = new VBox();
        root.getChildren().addAll(carBox,selectionLbl);
        root.setMinSize(350,350);

        root.setStyle(
                "-fx-padding: 10;" +
                        "-fx-border-style:solid inside;"+
                        "-fx-border-width:2;"+
                        "-fx-border-insets: 5;"+
                        "-fx-border-radius:5;"+
                        "-fx-border-color:blue;"
        );

        Scene scene= new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Combox Box Selection");
        stage.show();
    }
}
