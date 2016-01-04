package ch.jaunerc.prg2.mep;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jaunerc
 */
public class MessagePacketTest {
    
    public MessagePacketTest() {
    }

    @Test
    public void testProofing() {
        String from = "Me";
        String to = "Me";
        String data = "This is a simple test";
        String marker = "<!!>";
        
        MessagePacket packet = new MessagePacket(from, to, data, marker);
        MessagePacket returned = null;
        try {
            returned = MessagePacket.isCorrect(packet.toStringLine(), marker);
        } catch (CorruptMessageException ex) {
            ex.printStackTrace();
        }
        assertEquals(packet, returned);
    }
    
    @Test
    public void testEcho() {
        String echo = "ECHO_REQUEST";
        MessagePacket packet = new MessagePacket(echo);
        MessagePacket returned = null;
        try {
            returned = MessagePacket.isEcho(echo, echo);
        } catch (CorruptMessageException ex) {
            ex.printStackTrace();
        }
        assertEquals(packet, returned);
    }
    
}
