package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        //create Text
        Text text = new Text("Hello JAVAFX");

        //create the VBOX
        VBox root = new VBox();
        //add the text to the VBOx
        root.getChildren().add(text);
        //set the size of VBOX
        root.setMinSize(350,750);

        //create the scene
        Scene scene = new Scene(root);

//        set the stage properties
        primaryStage.setX(100);
        primaryStage.setY(200);
        primaryStage.setMinHeight(300);
        primaryStage.setMinWidth(400);

        //add the scene to the stage
        primaryStage.setScene(scene);

        primaryStage.setTitle("The Initial start FX app");

        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
