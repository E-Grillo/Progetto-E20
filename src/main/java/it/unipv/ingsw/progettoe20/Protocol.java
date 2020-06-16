package it.unipv.ingsw.progettoe20;

/**
 * Definisce il protocollo a livello applicazione utilizzato. Consiste in una semplice stringa formata da comando:ID.
 * In questa classe sono definiti i comandi utilizzabili e le possibili risposte.
 */
public class Protocol {
    public static final String SEPARATOR = ":";

    // Requests
    public static final String REQUEST_GENERATE_ID = "genid";
    public static final String REQUEST_PAY_AMOUNT = "payamount";
    public static final String REQUEST_DELETE_ID = "delete";
    public static final String REQUEST_END = "end";
    public static final String REQUEST_CHECK_ID = "id"; //restituisce id:found , id:not found
    public static final String REQUEST_PAYMENT_CHECK = "paid"; //restituisce paid:true , paid:false , paid:expired
    public static final String REQUEST_PAYMENT_ACCEPTED = "acceptpay";
    public static final String REQUEST_NEWLEVEL = "newlevel"; //Todo la usiamo??
    public static final String REQUEST_TOTAL_AVAILABILITY = "totava";
    // Responses
    public static final String RESPONSE_OK = "done";
    public static final String RESPONSE_NO_LEVEL = "?";
    public static final String RESPONSE_ERROR = "error";
    public static final String RESPONSE_ID_FOUND = "id:found";
    public static final String RESPONSE_ID_NOT_FOUND = "id:not found";
    public static final String RESPONSE_PAID_TRUE = "paid:true";
    public static final String RESPONSE_PAID_FALSE = "paid:false";
    public static final String RESPONSE_PAID_TIME_EXPIRED = "paid:expired";

    // Ping
    public static final String PING = "ping";
    public static final String PONG = "pong";
}
