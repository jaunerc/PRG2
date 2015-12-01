package ch.jaunerc.prg2.oop10;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Date;

/**
 *
 * @author jaunerc
 */
public class UDPTimeServer {

    public static void main(String[] args) {
        int port = Integer.parseInt(args[0]);
        try (DatagramSocket socket = new DatagramSocket(port)) {
            while (true) {
                DatagramPacket packet
                        = new DatagramPacket(new byte[1024], 1024);
                socket.receive(packet);
                InetAddress address = packet.getAddress();
                port = packet.getPort();
                int len = packet.getLength();
                byte[] data = packet.getData();
                data = new Date().toString().getBytes();
                // Use the length of the new data!
                packet = new DatagramPacket(data, data.length, address, port);
                socket.send(packet);
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
