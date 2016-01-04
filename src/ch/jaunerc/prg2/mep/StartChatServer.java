package ch.jaunerc.prg2.mep;

import java.util.Scanner;

/**
 *
 * @author jaunerc
 */
public class StartChatServer {
    public static void main(String[] args) {
        try {
            ChatServer server = new ChatServer(1234);
            server.listen();
            
            Scanner scanner = new Scanner(System.in);
            while(!scanner.nextLine().equals("exit")) { }
            server.setRunning(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
