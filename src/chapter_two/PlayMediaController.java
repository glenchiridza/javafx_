package chapter_two;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
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

        //create drop shadow

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
