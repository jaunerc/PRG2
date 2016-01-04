package ch.jaunerc.prg2.mep;

import java.util.Objects;

/**
 * This class provides a message packet for the chat communication. This type of message
 * is written for tcp request. A message packet is builded by:
 * FROM_MARKER_TO_MARKER_DATA
 * @author jaunerc
 * @version X1.0.0
 */
public class MessagePacket {
    private String from, to, data, marker;
    
    /**
     * Creates a new MessagePacket. This constructor sets the values of from, to and marker to "".
     * @param data Value of the packet.
     */
    public MessagePacket(String data) {
        this("", "", data, "");
    }
    
    /**
     * Creates a new MessagePacket.
     * @param from  Value of the packet.
     * @param to Value of the packet.
     * @param data Value of the packet.
     * @param marker Value of the packet.
     */
    public MessagePacket(String from, String to, String data, String marker) {
        this.from = from;
        this.to = to;
        this.data = data;
        this.marker = marker;
    }
    
    /**
     * Prooves if the given String is in the correct format. If it is correct this method returns
     * the given data as a message packet. Otherwise it throws an exception.
     * @param input String to check.
     * @param marker Value to separate the input.
     * @return A new MessagePacket.
     * @throws CorruptMessageException The input String is not in a correct format.
     */
    public static MessagePacket isCorrect(String input, String marker) throws CorruptMessageException {
        MessagePacket packet = null;
        int firstMarker = input.indexOf(marker);
        int secondMarker = input.indexOf(marker, firstMarker+marker.length());
        
        if(firstMarker != -1 && secondMarker != -1) {
            String from = input.substring(0, firstMarker);
            String to = input.substring(firstMarker+marker.length(), secondMarker);
            String data = input.substring(secondMarker+marker.length(), input.length());
            packet = new MessagePacket(from, to, data, marker);
        } else {
            throw new CorruptMessageException("Your request was "+input);
        }
        
        return packet;
    }
    
    /**
     * Prooves if the given String is a correct echo request. If it is correct this method returns
     * the given data as a echo message packet. Otherwise it throws an exception.
     * @param input String to check.
     * @param echo Value to check for.
     * @return A new echo MessagePacket.
     * @throws CorruptMessageException The input String is not in a correct format.
     */
    public static MessagePacket isEcho(String input, String echo) throws CorruptMessageException {
        MessagePacket packet = new MessagePacket(input);
        if(!packet.toString().equals(echo)) {
            throw new CorruptMessageException("False echo request "+input);
        }
        return packet;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public String getData() {
        return data;
    }

    public String getMarker() {
        return marker;
    }
    
    /**
     * Gets a String that contains the whole message. The resulted String can be used to send.
     * @return The MessagePacket concatinated into one String.
     */
    @Override
    public String toString() {
        return from+marker+to+marker+data;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.from);
        hash = 31 * hash + Objects.hashCode(this.to);
        hash = 31 * hash + Objects.hashCode(this.data);
        hash = 31 * hash + Objects.hashCode(this.marker);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MessagePacket other = (MessagePacket) obj;
        if (!Objects.equals(this.from, other.from)) {
            return false;
        }
        if (!Objects.equals(this.to, other.to)) {
            return false;
        }
        if (!Objects.equals(this.data, other.data)) {
            return false;
        }
        if (!Objects.equals(this.marker, other.marker)) {
            return false;
        }
        return true;
    }
}
