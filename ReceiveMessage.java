/*
 * Author Name: Solomon
 * File-Name: ReceiveMessage.java
 * Copy Right: No Copy Right
 * Creation Date: 3/6/2024
 * Last Modification Date: 5/6/2024
 * Version: 1.3 -- Add in Documentary Comment
 */

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;

public class ReceiveMessage {
    static Socket socket = ChatClient1.socket;
    static Scanner reader = null;

    public static void receiveMessage() {

        //Check Client Connection, if Client connected, Use as Server, use as Client otherwise
        if (Server.clientSocket1 != null) {
            socket = Server.clientSocket1;
        } else {
            socket = ChatClient1.socket;
        }

        try {
            reader = new Scanner(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            String message;

            //if their exist new message, print it out
            while ((message = reader.nextLine()) != null) {
                System.out.println(message);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
