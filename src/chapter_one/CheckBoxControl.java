package chapter_one;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Created by glenc on Jul 2021
 **/


public class CheckBoxControl extends Application {

    Label messageLabel = new Label("Press the Button");

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception{


        CheckBox fordChc =  new CheckBox("FORD");
        CheckBox audiChc = new CheckBox("AUDI");
        audiChc.setAllowIndeterminate(true);

        fordChc.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean value, Boolean newValue) {
                if (newValue != null && newValue){
                    printMessage("You selected Ford");
                }
            }
        });


        audiChc.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean value, Boolean newValue) {

                if (newValue != null && newValue) {
                    printMessage("Your Selection: Audi");
                }
            }
        });

        audiChc.indeterminateProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean value, Boolean newValue) {
                if (newValue != null && newValue) {
                    printMessage("Your Selection indeterminate selection: Audi");
                }
            }
        });


        VBox root =  new VBox();
        root.getChildren().addAll(messageLabel, fordChc,audiChc);

        root.setSpacing(20);

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
        stage.setTitle("Button Control");
        stage.show();
    }


    public void printMessage(String msg){
        messageLabel.setText(msg);
    }
}
