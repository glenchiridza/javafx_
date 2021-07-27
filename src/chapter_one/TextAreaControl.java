package chapter_one;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/**
 * Created by glenc on Jul 2021
 **/
public class TextAreaControl extends Application {

    TextArea messageArea = new TextArea();
    public static void main(String[] args) {

        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {

        TextField input =  new TextField();
        input.setPromptText("Input you message here");

        messageArea.setPromptText("You message...");
        messageArea.setPrefRowCount(20);
        messageArea.setPrefColumnCount(10);


        Button printBtn = new Button("Print Message");

        printBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                messageArea.appendText(input.getText()+"\n");
            }
        });


        VBox root = new VBox();

        root.getChildren().addAll(new Label("Input: "),
                input,new Label("Messages: "),messageArea,
                printBtn);
        root.setMinSize(300,300);

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
