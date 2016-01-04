
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
    
    public EasyProtocol(ProtocolState state) {
        this(state, state);
    }
    
    public EasyProtocol(ProtocolState stateUDP, ProtocolState stateTCP) {
        this.stateTCP = stateTCP;
        this.stateUDP = stateUDP;
    }
    
    public String processUDP() throws FalseAnswerException {
        return processUDP(null);
    }
    
    public String processUDP(String input) throws FalseAnswerException {
        String output = null;
        
        switch(stateUDP) {
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
            case WAITINGFORCLIENTS:
                if(input.equalsIgnoreCase(DISCOVER)) {
                    output = UDPSERVERRESPONSE;
                }
        }
        
        return output;
    }
    
    public MessagePacket processTCP() throws CorruptMessageException {
        return processTCP(null);
    }
    
    /**
     * 
     * @param input
     * @return
     * @throws CorruptMessageException 
     */
    public MessagePacket processTCP(String input) throws CorruptMessageException {
        MessagePacket packet = null;
        
        switch(stateTCP) {
            case LOOKINGFORSERVER:
                packet = new MessagePacket(MARKER+input+MARKER);
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
                packet = MessagePacket.isCorrect(input, MARKER);
                stateTCP = ProtocolState.SIGNINCOMPLETE;
                break;
            case SIGNINCOMPLETE:
                packet = new MessagePacket(SUCCESS);
                break;
            case SERVERCONNECTED:
                
        }
        
        return packet;
    }
}
