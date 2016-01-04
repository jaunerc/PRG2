package ch.jaunerc.prg2.mep;

/**
 * This enum provides states for the EasyProtocol.
 * @author jaunerc
 */
public enum ProtocolState {
    WAITINGFORCLIENTS, LOOKINGFORSERVER, WATINGFORSERVERRESPONSE, FOUNDSERVER, NOTCONNECTED, INFOSENT, CLIENTCONNECTED,
    SIGNINCOMPLETE, SERVERCONNECTED
}
