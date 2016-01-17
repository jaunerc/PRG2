package ch.jaunerc.prg2.mep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.Socket;
import java.util.Enumeration;
import java.util.Scanner;

/**
 * This class provides a simple ChatClient.
 * @author jaunerc
 */
public class ChatClient {
    private int destPort;
    private boolean running;
    private String name;
    private Socket socket;
    private EasyProtocol protocol;
    
    /**
     * Creates a new ChatClient object.
     * @param destPort Server port.
     * @param name Communicationname of this client.
     */
    public ChatClient(int destPort, String name) {
        this.destPort = destPort;
        this.name = name;
        protocol = new EasyProtocol(ProtocolState.LOOKINGFORSERVER);
        InetAddress serverAddress = discoverServer();
        
        try {
            startChat(serverAddress);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    /**
     * Looking for servers in all available subnets. The loopback interface will be skipped.
     * to discober the networks, this method sends udp broadcasts.
     */
    private InetAddress discoverServer() {
        InetAddress serverAddress = null;
        try (DatagramSocket dSocket = new DatagramSocket()){
            dSocket.setBroadcast(true);
            byte[] broadcastMsg = (protocol.processUDP()).getBytes(); // Get the discover message from the protocol
            
            Enumeration<NetworkInterface> eInterfaces = NetworkInterface.getNetworkInterfaces();
            while(eInterfaces.hasMoreElements()) {
                NetworkInterface interf = eInterfaces.nextElement();
                if(interf.isUp() && !interf.isLoopback()) {
                    for(InterfaceAddress addr : interf.getInterfaceAddresses()) {
                        InetAddress broadcastAdr = addr.getBroadcast(); // Get the broadcast address of the subnet
                        if(broadcastAdr != null) {
                            DatagramPacket packet = new DatagramPacket(broadcastMsg, broadcastMsg.length, broadcastAdr, destPort);
                            dSocket.send(packet);
                            System.out.println("Packet sent to "+broadcastAdr.getHostName());
                        }
                    }
                }
            }
            
            System.out.println("Waiting for a reply");
            byte[] received = new byte[1024]; // Creates a buffer for the incoming message
            DatagramPacket packet = new DatagramPacket(received, received.length);
            dSocket.receive(packet);
            
            System.out.println("Response from computer "+packet.getAddress().getHostAddress());
            if(prooveServerResponse(new String(packet.getData()).trim())) {
                System.out.println("Yes it is a chat server. Try to connect with...");
                serverAddress = packet.getAddress();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return serverAddress;
    }
    
    /**
     * Proove the data of a udp answer packet with the protocol. It returns true, if the data is correct
     * otherwise false.
     * @param msg data of the udp packet.
     * @return wheter the data is correct or not.
     */
    private boolean prooveServerResponse(String msg) {
        boolean correct = false;
        try {
            protocol.processUDP(msg);
            correct = true;
        } catch (FalseAnswerException e) {
            e.printStackTrace();
        }
        return correct;
    }
    
    /**
     * Start routine for the chat client to create a session with the given serveraddress. This method creates and starts two
     * runnable-objects UserInputHandler and Listener.
     * @param serverAddress to connect with.
     * @throws IOException the stream could not be opened.
     * @throws CorruptMessageException the signIn was not successfull.
     */
    private void startChat(InetAddress serverAddress) throws IOException, CorruptMessageException {
        socket = new Socket(serverAddress, destPort);
        signIn();
        Thread inputHandler = new Thread(new UserInputHandler());
        Thread listener = new Thread(new Listener());
        running = true;
        
        inputHandler.start();
        listener.start();
    }
    
    /**
     * Try to signin to the server that is connected with the socket field.
     * @throws IOException the stream could not be opened.
     * @throws CorruptMessageException the signIn was not successfull.
     */
    private void signIn() throws IOException, CorruptMessageException {
        PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        
        MessagePacket send = protocol.processTCP(name);
        writer.println(send.toString());
        System.out.println("Sent username to server.");
        
        String received = reader.readLine();
        protocol.processTCP(received);
        System.out.println("Successfully connected with server.");
    }
    
    /**
     * This class provides a thread to read user input. It creates a PrintWriter to write to the socket field stream.
     */
    private class UserInputHandler implements Runnable {
        PrintWriter writer;
        @Override
        public void run() {
            Scanner scanner = new Scanner(System.in);
            try {
                System.out.println("\nWrite the name of the recipient first and after that your message:");
                writer = new PrintWriter(socket.getOutputStream(), true);
                while (running) {
                    String recipient = scanner.nextLine();
                    String message = scanner.nextLine();
                    
                    try {
                        MessagePacket packet = protocol.formatUserMessage(name, recipient, message);
                        writer.println(packet.toString());
                    } catch (CorruptMessageException cme) {
                        System.out.println("Your message is not in the correct format. Try again!");
                    }
                }
                writer.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    /**
     * This class provides a thread to read the socket field input stream. It writes the readed data to the console
     * output stream.
     */
    private class Listener implements Runnable {
        BufferedReader reader;
        
        @Override
        public void run() {
            try {
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                
                while(running) {
                    String input = reader.readLine();
                    MessagePacket packet = protocol.processTCP(input);
                    System.out.println("Message from: "+packet.getFrom()+": \n"+packet.getData());
                }
                reader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
