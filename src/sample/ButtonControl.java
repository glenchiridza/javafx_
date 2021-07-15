package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Created by glenc on Jul 2021
 **/

public class ButtonControl extends Application {

    Label messageLabel = new Label("Press the Button");

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception{

        Button saveBtn = new Button("_Save");
        saveBtn.setDefaultButton(true);

        saveBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                printMessage("You have successfully saved");
            }
        });

        Button cancelBtn = new Button("_Cancel");
        cancelBtn.setCancelButton(true);
        cancelBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                printMessage("You have pressed cancel");
            }
        });

        HBox buttonBox = new HBox();
        buttonBox.getChildren().addAll(saveBtn,cancelBtn);
        buttonBox.setSpacing(15);

        VBox root = new VBox();
        root.getChildren().addAll(messageLabel, buttonBox);

        root.setSpacing(15);

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
