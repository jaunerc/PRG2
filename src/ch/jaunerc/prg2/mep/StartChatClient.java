package ch.jaunerc.prg2.mep;

/**
 *
 * @author jaunerc
 */
public class StartChatClient {
    public static void main(String[] args) {
        if(args.length != 0) {
            ChatClient client = new ChatClient(1234, args[0]);
        } else {
            System.err.println("Usage java StartChatClient <username>");
        }
    }
}
