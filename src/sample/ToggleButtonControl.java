package sample;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Created by glenc on Jul 2021
 **/
public class ToggleButtonControl extends Application {

    Label messageLabel = new Label("Your selection: None");

    public static void main(String[] args) {

        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {

        ToggleButton fordBtn = new ToggleButton("Ford");
        ToggleButton audiBtn = new ToggleButton("Audi");
        ToggleButton porcheBtn = new ToggleButton("Porsche");

        final ToggleGroup group = new ToggleGroup();
        group.getToggles().addAll(fordBtn,audiBtn,porcheBtn);

        group.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observableValue, Toggle t1, Toggle t2) {
                String toggleBtn = ((ToggleButton)t2).getText();
                messageLabel.setText("Your Selection: "+ toggleBtn);
            }
        });


        Label selectLabel = new Label("Select choice car");

        HBox buttonBox = new HBox();
        buttonBox.getChildren().addAll(fordBtn,audiBtn,porcheBtn);
        buttonBox.setSpacing(15);

        VBox root = new VBox();
        root.getChildren().addAll(messageLabel,selectLabel,buttonBox);
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
        stage.setTitle("ToggleButton");
        stage.show();
    }

    public void printMessage(String msg){
        System.out.println(msg);
    }
}
