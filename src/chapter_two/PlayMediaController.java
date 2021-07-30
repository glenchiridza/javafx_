package chapter_two;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.net.URL;

/**
 * Created by glenc on Jul 2021
 **/
public class PlayMediaController extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        URL mediaUrl = getClass().getResource("Test.mp4");
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
}
