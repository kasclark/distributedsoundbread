/*
 * Because every soundbread needs a client/server architecture!
 * The client prompts the user for input, validates it and sends it to the 
 * specified server. Sounds are played locally at the serverside. Only requests 
 * are sent across the wire.
 */
package soundbreadclient;

import java.io.ObjectOutputStream;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author kasclark
 */
public class SoundbreadClient {
        
     /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // User needs to specify the server
       if(args.length == 0) {
            System.out.println("Why you no give server address? "
                    + "Or at least: 127.0.0.1");
            System.exit(0);
       }
       
       // is you a real addy?
       String server = args[0];
       try {
            Object res = InetAddress.getByName(server);
            if (!(res instanceof Inet4Address)) {
                System.out.println("Why you no give me good server address? "
                        + "Or at least 127.0.0.1");
                System.exit(0);
            }
                        
            // prompt the user for some input
            while (true) {
                Scanner reader = new Scanner(System.in);
                System.out.println("MENU:\n 0: EXIT\n 1: Crickets\n "
                    + "2: Sad trombone\n 3: Badumtss\n 4: Gayyyy!\n 5: Shame");
                System.out.println("Make your choice: ");

                // ignore non ints
                while(!reader.hasNextInt()) {
                    reader.next();
                }
                int choice = reader.nextInt();
                if (choice == 0) {
                    System.exit(0);
                } else if (choice > 5) {
                    System.out.println("You choose bad number. "
                            + "You disappoint me...");
                } else {
                    // send that shizzle to the server
                    int port = 8080;
                    InetAddress address = InetAddress.getByName(server);
                    Socket socket = new Socket(address, port); 
                    ObjectOutputStream oo = new ObjectOutputStream(socket.getOutputStream());
                    oo.writeObject(choice);
                    oo.flush();
                    oo.close();
                    System.out.println("Message sent to the server : " + choice);
                }
            }
        } catch (Exception ex) {
            System.out.println("ERROR: " + ex);
        }           
    }
}
