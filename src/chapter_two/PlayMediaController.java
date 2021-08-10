package chapter_two;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

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
        //create mediaplayer
        final MediaPlayer player = new MediaPlayer(media);
        //auto begin playback
        player.setAutoPlay(true);

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

        //

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



        HBox controlBox = new HBox(5,playButton,stopButton);

        VBox root = new VBox(5,mediaView,controlBox);


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