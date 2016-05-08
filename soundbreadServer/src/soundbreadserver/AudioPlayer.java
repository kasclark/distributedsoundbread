/*
 * An object to play music. Cuz we like objects!
 */
package soundbreadserver;

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
        String path = getClass().getResource("resources/" + audio).toString();
        JFXPanel jp = new JFXPanel();
        Media m = new Media(path);
        MediaPlayer mp = new MediaPlayer(m);
        mp.play();
    }
    
}
