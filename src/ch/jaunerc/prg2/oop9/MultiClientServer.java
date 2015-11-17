/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.jaunerc.prg2.oop9;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Cyrill Jauner
 */
public class MultiClientServer {
    private ServerSocket server;
    private int port;
    private int numClient;
    
    public static void main(String[] args) {
        try {
            MultiClientServer server = new MultiClientServer(1234);
            server.listen();
        } catch (Exception e) {
            System.err.println("Error while executing server.");
            System.exit(1);
        }
    }
    
    public MultiClientServer(int port) throws IOException {
        server = new ServerSocket(port);
        this.port = port;
        numClient = 0;
    }
    
    public void listen() {
        while(true) {
            try {
                Socket client = server.accept();
                handle(client);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    private void handle(Socket client) {
        int myNumber = ++numClient;
        Thread handleClient = new Thread(() -> {
            try (
                    DataInputStream in = new DataInputStream(client.getInputStream());
                    DataOutputStream out = new DataOutputStream(client.getOutputStream());
                ){
                byte clientInput;
                while((clientInput = in.readByte()) != -1) {
                    out.writeByte(clientInput);
                    System.out.println("Client"+myNumber+" writed:"+clientInput);
                    System.out.println("Server answered: "+clientInput);
                }
                
            } catch (IOException e) {
            }
            
        });
        handleClient.start();
    }
}
