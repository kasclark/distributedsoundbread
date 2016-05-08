/*
 * An object to play music. Cuz we like objects!
 */
package soundbreadserver;

import java.nio.file.Paths;
import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 *
 * @author kasclark
 */
public class AudioPlayer {
    
    // set some values
    public AudioPlayer() { 
        
    }
    
    // open and play file
    public void playAudio(String audio){
        System.out.println("Received request for: " + audio);
        String mp3 = (getClass().getResource("resources/" + audio).getPath());
        JFXPanel jp = new JFXPanel();
        Media m = new Media(Paths.get(mp3).toUri().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(m);
        mediaPlayer.play();
    }
    
}
