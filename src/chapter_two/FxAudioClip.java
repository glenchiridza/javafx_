package chapter_two;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;

import java.net.URL;

/**
 * Created by glenc on Jul 2021
 **/
public class FxAudioClip extends Application {

    private AudioClip audioClip;

    public static void main(String[] args) {

        launch(args);
    }

    @Override
    public void init() throws Exception {
        //create audio clip which loads the audio data synchronously
        final URL resource = getClass().getResource("test.mp3");
        audioClip = new AudioClip(resource.toExternalForm());

    }

    @Override
    public void start(Stage stage) throws Exception {

        Button playButton  = new Button("Play");
        Button stopButton  = new Button("Stop");

        final Slider cyclerSlider = new Slider(1,5,1);
        cyclerSlider.setMajorTickUnit(1);
        cyclerSlider.setShowTickLabels(true);

        final Slider volumeSlider = new Slider(0.0,1.0,0.5);
        volumeSlider.setMajorTickUnit(0.1);
        volumeSlider.setShowTickLabels(true);

        final Slider rateSlider = new Slider(0,8,4);
        rateSlider.setMajorTickUnit(1);
        rateSlider.setShowTickLabels(true);

        final Slider balanceSlider = new Slider(-0.1,1.0,0.0);
        balanceSlider.setMajorTickUnit(0.2);
        balanceSlider.setShowTickLabels(true);

        final Slider paneSlider = new Slider(-0.1,1.0,0.0);
        paneSlider.setMajorTickUnit(0.2);
        paneSlider.setShowTickLabels(true);

        final Slider prioritySlider = new Slider(0.0,10.0,0.0);
        prioritySlider.setMajorTickUnit(1);
        prioritySlider.setShowTickLabels(true);

        playButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                audioClip.play();
            }
        });

        stopButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                audioClip.stop();
            }
        });

        //bind the properties
        audioClip.cycleCountProperty().bind(cyclerSlider.valueProperty());
        audioClip.volumeProperty().bind(volumeSlider.valueProperty());
        audioClip.rateProperty().bind(rateSlider.valueProperty());
        audioClip.balanceProperty().bind(balanceSlider.valueProperty());
        audioClip.panProperty().bind(paneSlider.valueProperty());
        audioClip.priorityProperty().bind(prioritySlider.valueProperty());

        GridPane sliderPane = new GridPane();
        sliderPane.setHgap(5);
        sliderPane.setVgap(10);

        //add the details to the grid pane



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
