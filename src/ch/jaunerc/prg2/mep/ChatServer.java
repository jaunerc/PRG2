package ch.jaunerc.prg2.mep;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Scanner;

/**
 * This class provides a simple chat server. It uses the EasyProtocol to communicate.
 * @author jaunerc
 */
public class ChatServer {
    private int port;
    private boolean running;
    private InetAddress address;
    private List<ClientHandler> clients;
    private EasyProtocol protocol;
    
    /**
     * Creates a new ChatServer object.
     * @param port The port to listen on with udp and tcp.
     */
    public ChatServer(int port) {
        this.port = port;
        clients = new ArrayList<>();
        protocol = new EasyProtocol(ProtocolState.WAITINGFORCLIENTS);
        
        try {
            chooseInetAddress();
        } catch (SocketException ex) {
            System.err.println("Could not choose an ip address.");
        }
    }

    public void setRunning(boolean running) {
        this.running = running;
    }
    
    /**
     * Choose one ip address of the available addresses.
     * @throws SocketException There is a problem with the local networtk interfaces
     */
    private void chooseInetAddress() throws SocketException {
        Enumeration<NetworkInterface> enumerator = NetworkInterface.getNetworkInterfaces();
        List<InetAddress> chooseableAddresses = new ArrayList<>();
        int addrCounter = 0;
        
        System.out.println("Choose an ip address with the index number\nAvailable addresses: ");
        while(enumerator.hasMoreElements()) {
            NetworkInterface interf = enumerator.nextElement();
            
            Enumeration<InetAddress> addresses = interf.getInetAddresses();
            while(addresses.hasMoreElements()) {
                InetAddress addr = addresses.nextElement();
                if(addr.isSiteLocalAddress() || addr.isLoopbackAddress()) {
                    chooseableAddresses.add(addr);
                    System.out.println("[ "+addrCounter+" ] - "+ addr.getHostAddress());
                    addrCounter++;
                }
            }
        }
        
        System.out.println("\nYour input: ");
        Scanner scanner = new Scanner(System.in);
        
        int index = Integer.parseInt(scanner.nextLine());
        if(index < chooseableAddresses.size()) {
            address = chooseableAddresses.get(index);
        } else {
            System.err.println("False index");
        }
    }
    
    /**
     * Starts threads to listen on the serverport with udp and tcp.
     */
    public void listen() {
        Thread tcpThread = new Thread(new tcpListener());
        Thread udpThread = new Thread(new udpListener());
        running = true;
        
        // Start both listeners
        udpThread.start();
        tcpThread.start();
    }
    
    /**
     * Class to provide a tcp listener.
     */
    private class tcpListener implements Runnable {

        @Override
        public void run() {
            try (ServerSocket socket = new ServerSocket(port, 5, address)){
                while(running) {
                    Socket client = socket.accept();
                    ClientHandler handler = new ClientHandler(client);
                    clients.add(handler);
                    
                    Thread handlerThread = new Thread(handler);
                    handlerThread.start();
                }
                
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    private class ClientHandler implements Runnable {
        Socket client;
        String username;
        EasyProtocol handlerProtocol;
        PrintWriter writer;
        boolean connected;
        
        public ClientHandler(Socket client) {
            this.client = client;
            handlerProtocol = new EasyProtocol(ProtocolState.NOTCONNECTED);
        }
        
        @Override
        public void run() {
               try (
                    BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
                ){
                writer = new PrintWriter(client.getOutputStream(), true);
                String received = reader.readLine();
                MessagePacket packet = handlerProtocol.processTCP(received);
                username = packet.getData();
                System.out.println("Got username from client: "+packet.toString()+", from: "+packet.getFrom()+", to: "+packet.getTo()+", data: "+packet.getData());
                MessagePacket send = handlerProtocol.processTCP();
                writer.println(send.toString());
                connected = true;
                
                
                while (connected) {
                    String input = reader.readLine();
                    System.out.println("Got some input: "+input);
                    
                    MessagePacket userMsg = handlerProtocol.processTCP(input);
                    for(ClientHandler handler : clients) {
                        System.out.println("handler: "+handler.username+" , MsgTo: "+userMsg.getTo());
                        if(userMsg.getTo().equals(handler.username)) {
                            System.out.println("User found: "+username);
                            handler.send(userMsg.toString());
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
               writer.close();
        }
        
        public void send(String msg) {
            writer.println(msg);
        }
        
    }
    
    /**
     * Class to provide a udp listener.
     */
    private class udpListener implements Runnable {

        @Override
        public void run() {
            try (DatagramSocket socket = new DatagramSocket(port, InetAddress.getByName("0.0.0.0"))){
                socket.setBroadcast(true);
                DatagramPacket packet = new DatagramPacket(new byte[1024], 1024); // 
                
                while(running) {
                    socket.receive(packet);
                    String answer = new String(packet.getData()).trim();
                    System.out.println("Get a udp message: "+answer);
                    
                    byte[] replyMsg = (protocol.processUDP(answer)).getBytes();
                    DatagramPacket reply = new DatagramPacket(replyMsg, replyMsg.length, packet.getAddress(), packet.getPort());
                    socket.send(reply);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
    }
}
