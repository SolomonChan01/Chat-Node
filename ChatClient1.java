/*
 * Author Name: Solomon
 * File-Name: ChatClient2.java
 * Copy Right: No Copy Right
 * Creation Date: 3/6/2024
 * Last Modification Date: 5/6/2024
 * Version: 1.3 -- Add in Documentary Comment
 */

import java.io.IOException;
import java.net.Socket;

public class ChatClient1 {
    public static Socket socket;
    public static String name = "Someone";
    public static String host = IPAddressPrinter.host;
    public static int targetPort = 12345;
    public static int ownPort = 12344;
    static Thread thread1 = new Thread(() -> {
        try {
            SendMessage.sendMessage();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    });
    static Thread thread2 = new Thread(ReceiveMessage::receiveMessage);

    public static void main(String[] args) {

        new Thread(() -> {
            try {
                Server.startServer();
                thread1.start();
                thread2.start();
                thread1.join();
                thread2.join();
            } catch (Exception e) {

            }
        }).start();
        new Thread(() -> {
            try {
                socket = new Socket(host, targetPort);
                thread1.start();
                thread2.start();
                thread1.join();
                thread2.join();

            } catch (Exception e) {
            }
        }).start();
    }
}
