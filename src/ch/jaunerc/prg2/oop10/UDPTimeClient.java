package ch.jaunerc.prg2.oop10;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 *
 * @author jaunerc
 */
public class UDPTimeClient {

    public static void main(String[] args) {
        int port = Integer.parseInt(args[0]);
        String hostname = args[1];
        try (DatagramSocket socket = new DatagramSocket()) {
            InetAddress address = InetAddress.getByName(hostname);
            byte[] raw = new byte[1024];
            DatagramPacket packet = new DatagramPacket(
                    raw, raw.length, address, port);
            socket.send(packet);
            socket.receive(packet);
            int len = packet.getLength();
            byte[] data = packet.getData();
            System.out.println(new String(data, 0, len));
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
