package ch.jaunerc.prg2.oop9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author jaunerc
 */
public class PrimTestClient {

    public static void main(String[] args) throws IOException {
        int port = 1234;
        String host = "10.3.102.45";
        BufferedReader keyStream
                = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            Socket client = new Socket(host, port);
            PrintWriter outStream
                    = new PrintWriter(client.getOutputStream());
            BufferedReader inStream
                    = new BufferedReader(
                            new InputStreamReader(client.getInputStream()));
            String line = inStream.readLine();
            System.out.println(line);
            line = keyStream.readLine();
            outStream.println(line);
            outStream.flush();
            line = inStream.readLine();
            System.out.println(line);
            client.close();
        }
    }
}
