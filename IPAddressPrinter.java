/*
 * Author Name: Solomon
 * File-Name: IPAddressPrinter.java
 * Copy Right: No Copy Right
 * Creation Date: 3/6/2024
 * Last Modification Date: 5/6/2024
 * Version: 1.3 -- Add in Documentary Comment
 */

import java.net.*;
import java.util.Enumeration;

public class IPAddressPrinter {
    public static String host;
    public static void main(String[] args) {
        try {
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
            while (interfaces.hasMoreElements()) {
                NetworkInterface networkInterface = interfaces.nextElement();
                if (!networkInterface.isLoopback() && networkInterface.isUp()) {
                    Enumeration<InetAddress> addresses = networkInterface.getInetAddresses();
                    while (addresses.hasMoreElements()) {
                        InetAddress address = addresses.nextElement();
                        if (address instanceof Inet4Address) {
                            host = address.getHostAddress();
                            System.out.println("IP Address: " + address.getHostAddress());
                        }
                    }
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }
}