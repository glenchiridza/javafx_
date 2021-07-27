package chapter_one;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Created by glenc on Jul 2021
 **/
public class RadioButtonControl extends Application {

    Label selectLabel = new Label("You selection: None");
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {


        RadioButton fordButton = new RadioButton("Ford");
        RadioButton audiButton = new RadioButton("Audi");
        RadioButton porcheButton = new RadioButton("Porche");

        ToggleGroup group = new ToggleGroup();
        group.getToggles().addAll(fordButton,audiButton,porcheButton);

        group.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observableValue, Toggle t1, Toggle t2) {
                String toggleText = ((ToggleButton)t2).getText();
                selectLabel.setText(toggleText);
            }
        });

        porcheButton.setSelected(true);

        Label msg  = new Label("Select your choice Car: ");

        HBox buttonBox = new HBox();
        buttonBox.getChildren().addAll(fordButton,audiButton,porcheButton);
        buttonBox.setSpacing(15);

        VBox root = new VBox();
        root.getChildren().addAll(selectLabel,msg,buttonBox);
        root.setSpacing(15);
        root.setMinSize(350,250);

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
        stage.setTitle("RadioButton");
        stage.show();

    }

}
