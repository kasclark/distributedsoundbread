/*
 * Because every soundbread needs a client/server architecture!
 * The server listens for and processes requests from the clients. Sounds are 
 * played locally at the serverside. Only requests are sent across the wire.
 */
package soundbreadserver;

import java.io.ObjectInputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 
 * @author kasclark
 */
public class SoundbreadServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        AudioPlayer ap = new AudioPlayer();
        
         // open a port (default 8080)
        try {
            InetAddress host = InetAddress.getLocalHost();
            ServerSocket serverSocket = new ServerSocket(8080);
            Socket socket;
            String audio = new String();
            while (true) {
                System.out.println("Listening...");
                socket = serverSocket.accept();
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                int message = (int) ois.readObject();
                System.out.println("User requested: " + message);
                switch (message) {
                    case 1:
                        audio = "crickets.mp3";
                        break;
                    case 2:
                        audio = "downer.mp3";
                        break;
                    case 3:
                        audio = "rimshot.mp3";
                        break;
                    case 4:
                        audio = "gaaay.mp3";
                        break;
                    case 5:
                        audio = "shame.mp3";
                        break;
                    default:
                        // this should never happen
                        System.out.println("Uhh... Sorry don't know number: " + message);
                        break;
                }
                
                // play that tune
                System.out.println("playing: " + audio);
                ap.playAudio(audio);
            }
        } catch (Exception ex) {
            System.out.println("ERROR: " + ex);
        }
        
        
    }
    
}
