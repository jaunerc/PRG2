
package ch.jaunerc.prg2.mep;

/**
 * This class provides a simple chat protocol.
 * @author jaunerc
 */
public class EasyProtocol {
    private final String DISCOVER = "DISCOVER_CHATSERVER";
    private final String UDPSERVERRESPONSE = "HELLO_CLIENT";
    private final String MARKER = "<!!>";
    private final String ECHO = "ECHO_REQUEST";
    private final String SUCCESS = "SUCCESS";
    
    private ProtocolState stateUDP;
    private ProtocolState stateTCP;
    
    /**
     * Creates a new EasyProtocol object.
     * @param state default value for tcp and udp state.
     */
    public EasyProtocol(ProtocolState state) {
        this(state, state);
    }
    
    /**
     * Creates a new EasyProtocol object.
     * @param stateUDP default value for udp state.
     * @param stateTCP default value for tcp state.
     */
    public EasyProtocol(ProtocolState stateUDP, ProtocolState stateTCP) {
        this.stateTCP = stateTCP;
        this.stateUDP = stateUDP;
    }
    
    /**
     * Process the current udp protocol step. This method is only for the initial communication.
     * @return String to send.
     * @throws FalseAnswerException the null input was unexpected.
     */
    public String processUDP() throws FalseAnswerException {
        return processUDP(null);
    }
    
    /**
     * Process the current udp protocol step.
     * @param input value to proove.
     * @return String to send.
     * @throws FalseAnswerException the input value was unexpected.
     */
    public String processUDP(String input) throws FalseAnswerException {
        String output = null;
        
        switch(stateUDP) {
            // Client state
            case LOOKINGFORSERVER:
                output = DISCOVER;
                stateUDP = ProtocolState.WATINGFORSERVERRESPONSE;
                break;
            case WATINGFORSERVERRESPONSE:
                if(input.equalsIgnoreCase(UDPSERVERRESPONSE)) {
                    stateUDP = ProtocolState.FOUNDSERVER;
                } else {
                    throw new FalseAnswerException(UDPSERVERRESPONSE, input);
                }
                break;
                
            // Server state
            case WAITINGFORCLIENTS:
                if(input.equalsIgnoreCase(DISCOVER)) {
                    output = UDPSERVERRESPONSE;
                }
        }
        
        return output;
    }
    
    /**
     * Process the current tcp protocol step. This method is only for the initial communication.
     * @return a MessagePacket object to send.
     * @throws CorruptMessageException the null input was unexpected or false.
     */
    public MessagePacket processTCP() throws CorruptMessageException {
        return processTCP(null);
    }
    
    /**
     * Process the current tcp protocol step.
     * @param input value to proove.
     * @return a MessagePacket object to send.
     * @throws CorruptMessageException input value was unexpected or false.
     */
    public MessagePacket processTCP(String input) throws CorruptMessageException {
        MessagePacket packet = null;
        
        switch(stateTCP) {
            // Client states
            case LOOKINGFORSERVER:
                packet = new MessagePacket(input);
                stateTCP = ProtocolState.INFOSENT;
                break;
            case INFOSENT:
                if(input.equals(SUCCESS)) {
                    stateTCP = ProtocolState.CLIENTCONNECTED;
                } else {
                    throw new CorruptMessageException("Server is not ready for communication");
                }
                break;
            case CLIENTCONNECTED:
                packet = MessagePacket.isCorrect(input, MARKER);
                break;
                
            // Server states
            case WAITINGFORCLIENTS:
                switch(input) {
                    case ECHO:
                        packet = MessagePacket.isEcho(input, ECHO);
                        break;
                    default:
                        packet = MessagePacket.isCorrect(input, MARKER);
                }
                break;
            case NOTCONNECTED:
                packet = new MessagePacket(input);
                stateTCP = ProtocolState.SIGNINCOMPLETE;
                break;
            case SIGNINCOMPLETE:
                packet = new MessagePacket(SUCCESS);
                stateTCP = ProtocolState.SERVERCONNECTED;
                break;
            case SERVERCONNECTED:
                packet = MessagePacket.isCorrect(input, MARKER);
        }
        
        return packet;
    }
    
    /**
     * Creates a MessagePacket object with the given parameters and the protocol marker.
     * @param sender
     * @param recipient
     * @param data
     * @return MessagePacket object.
     * @throws CorruptMessageException the parameters are not correct.
     */
    public MessagePacket formatUserMessage(String sender, String recipient, String data) throws CorruptMessageException {
        MessagePacket packet = null;
        
        if(stateTCP == ProtocolState.CLIENTCONNECTED) {
            packet = MessagePacket.isCorrect(sender+MARKER+recipient+MARKER+data, MARKER);
        }
        
        return packet;
    }
}
