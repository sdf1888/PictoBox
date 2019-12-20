package serverTier.model;

public interface PictoProtocols {

    /**
     * Sent from server to tell a client when they've connected to a room
     * Includes lists the number of people in the chatroom
     * Usage: "WELCOME Connected: Room 1, Occupants: [Username01, Username03]
     */
    public static final String WELCOME = "WELCOME";

    /**
     * Sent from client to tell clienthandler the client's username
     * Usage: "JOIN Username01"
     */
    public static final String JOIN = "JOIN";

    /**
     * Sent from server to announce a client joining the chatroom
     * Includes the clients name
     * Usage: "JOINED Username02"
     */
    public static final String JOINED = "JOINED";

    /**
     * Disconnects a client from the chatroom
     * Announces to users in room that the client has disconnected
     * Usage: "DISCONNECT Username01"
     */
    public static final String DISCONNECT = "DISCONNECT";

    /**
     * Denotes a message being sent/revieced
     * Usage: "MSG Hello World"
     */
    public static final String MSG = "MSG";

    /**
     * Indicates an error has occurred somewhere
     * Depending on the location of the error the client may be disconnected, a room closed or the server shutdown as a whole
     * Includes a string of where the error occurred
     * Usage: "ERR Client IO
     */
    public static final String ERR = "ERR";

}
