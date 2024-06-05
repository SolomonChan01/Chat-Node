/*
 * Author Name: Solomon
 * File-Name: SendMessage.java
 * Copy Right: No Copy Right
 * Creation Date: 3/6/2024
 * Last Modification Date: 5/6/2024
 * Version: 1.3 -- Add in Documentary Comment
 */

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class SendMessage {
    static Socket socket = ChatClient1.socket;
    static PrintWriter writer = null;
    static String message;
    public static void sendMessage() throws IOException {

        //Check Client Connection, if Client connected, Use as Server, use as Client otherwise
        if (Server.clientSocket1 != null) {
            socket = Server.clientSocket1;
        } else {
            socket = ChatClient1.socket;
        }

        writer = new PrintWriter(socket.getOutputStream(), true);
        try {
            Scanner consoleReader = new Scanner(new InputStreamReader(System.in));

            //read input from the console, print it to the socket
            while (true) {
                message =  consoleReader.nextLine();
                writer.println(message);
            }
        } catch (Exception e) {

        }

    }
}
