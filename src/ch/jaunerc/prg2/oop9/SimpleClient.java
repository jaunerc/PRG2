/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.jaunerc.prg2.oop9;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 *
 * @author Cyrill Jauner
 */
public class SimpleClient {
    private String hostname;
    private int port;
    
    public static void main(String[] args) {
        SimpleClient client = new SimpleClient("localhost", 1234);
        client.talk();
    }
    
    public SimpleClient(String hostname, int port) {
        this.hostname = hostname;
        this.port = port;
    }
    
    public void talk() {
        try (
                Socket socket = new Socket(hostname, port);
                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                BufferedReader sysIn = new BufferedReader(new InputStreamReader(System.in));
                ){
            
            byte serverInput, byteOutput;
            String clientOutput;
            while(!(clientOutput = sysIn.readLine()).equals("exit")) {
                byteOutput = clientOutput.getBytes()[0];
                out.writeByte(byteOutput);
                serverInput = in.readByte();
                System.out.println("The server said: "+serverInput);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
