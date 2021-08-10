package chapter_two;

import javafx.application.Application;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.ObservableMap;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.net.URL;

/**
 * Created by glenc on Jul 2021
 **/
public class PlayMediaController extends Application {

    private TextArea messageArea = new TextArea();
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        //create sliders
        final Slider cycleslider = new Slider(1,5,1);
        cycleslider.setMajorTickUnit(1);
        cycleslider.setShowTickLabels(true);

        final Slider volumeSlider  = new Slider(0.0,1.0,0.5);
        volumeSlider.setMajorTickUnit(0.1);
        volumeSlider.setShowTickLabels(true);

        final Slider rateSlider = new Slider(0,8,4);
        rateSlider.setMajorTickUnit(1);
        rateSlider.setShowTickLabels(true);

        final Slider balanceSlider = new Slider(-1.0,1.0,0.0);
        balanceSlider.setMajorTickUnit(0.2);
        balanceSlider.setShowTickLabels(true);

        URL mediaUrl = getClass().getResource("bill.mp4");
        String mediaStringUrl = mediaUrl.toExternalForm();

        //create a media
        Media media = new Media(mediaStringUrl);

//        create marker positions
        ObservableMap<String,Duration> markers = media.getMarkers();
        markers.put("Start",Duration.ZERO);
        markers.put("Interval",media.getDuration().divide(2.0));
        markers.put("End",media.getDuration());


        //create mediaplayer
        final MediaPlayer player = new MediaPlayer(media);
        //auto begin playback
        player.setAutoPlay(true);

//          when needing to set start and end time of video duration
//        player.setStartTime(Duration.minutes(1));
//        player.setStopTime(Duration.minutes(2));

        MediaView mediaView = new MediaView(player);
        mediaView.setFitWidth(400);
        mediaView.setFitHeight(400);
        mediaView.setSmooth(true);

        //create drop shadow effect
        DropShadow dropShadow = new DropShadow();
        dropShadow.setOffsetY(5.0);
        dropShadow.setOffsetX(5.0);
        dropShadow.setColor(Color.WHITE);

        mediaView.setEffect(dropShadow);

//        create buttons

        Button playButton = new Button("Play");
        Button stopButton = new Button("Stop");

        playButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(player.getStatus() == MediaPlayer.Status.PLAYING){
                    player.stop();
                    player.play();
                }else{
                    player.play();
                }
            }
        });

        stopButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                player.stop();
            }
        });

        //create the slider listeners
        cycleslider.valueProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                if (cycleslider.isValueChanging()){
                    messageArea.appendText("Cycle count change to " +
                            (int)cycleslider.getValue());
                    player.setCycleCount((int)cycleslider.getValue());
                }
            }
        });

        volumeSlider.valueProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                if (volumeSlider.isValueChanging()){
                    messageArea.appendText("Volume count change to " +
                            (int)volumeSlider.getValue());
                    player.setCycleCount((int)volumeSlider.getValue());

                }
            }
        });

        rateSlider.valueProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                if(rateSlider.isValueChanging()){
                    messageArea.appendText("rateSlider count change to " +
                            (int)rateSlider.getValue());
                    player.setCycleCount((int)rateSlider.getValue());

                }
            }
        });

        balanceSlider.valueProperty().addListener(new InvalidationListener()
        {
            @Override
            public void invalidated(Observable ov)
            {
                if (balanceSlider.isValueChanging())
                {
                    messageArea.appendText("\nBalance changed to: " +
                            balanceSlider.getValue());
                    player.setVolume(balanceSlider.getValue());
                }
            }
        });

        // add handlers for end and repeat
        player.setOnEndOfMedia(new Runnable() {
            @Override
            public void run() {
                messageArea.appendText("\nEnd of media");
            }
        });

        player.setOnRepeat(new Runnable() {
            @Override
            public void run() {
                messageArea.appendText("\n Repeating media");
            }
        });

        //create handlers for error
        player.setOnError(() -> {
//            handle asynchronous error in player
            printMessage(player.getError());
        });

        media.setOnError(() ->{
            printMessage(media.getError());
        });

        mediaView.setOnError(mediaErrorEvent -> {
            printMessage(mediaErrorEvent.getMediaError());
        });



        //create grid grid frame for sliders
        GridPane gridSliderPane = new GridPane();
        gridSliderPane.setHgap(5);
        gridSliderPane.setVgap(10);

        //add details to the pane
        gridSliderPane.addRow(0, new Label("CycleCount"),cycleslider);
        gridSliderPane.addRow(1, new Label("Volume"),volumeSlider);
        gridSliderPane.addRow(2,new Label("Rate:"),rateSlider);
        gridSliderPane.addRow(3,new Label("Balance",balanceSlider));


        HBox controlBox = new HBox(5,playButton,stopButton);

        VBox root = new VBox(5,mediaView,controlBox,gridSliderPane,messageArea);


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

    private void printMessage(MediaException error) {
        MediaException.Type errorType = error.getType();
        String errorMessage = error.getMessage();
        messageArea.setText(errorMessage);
    }
}
