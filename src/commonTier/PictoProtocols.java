package commonTier;

public interface PictoProtocols {

    /**
     * Sent from server to tell a client when they've connected to a room
     * Includes lists the number of people in the chatroom
     * Usage: "WELCOME Connected: Room 1, Occupants: [Username01, Username03]
     */
    public static final String WELCOME = "/welcome";

    /**
     * Sent from client to tell server to add a client to a room
     * Usage: "JOIN roomName"
     */
    public static final String JOIN = "/join";

    /**
     * Sent from client to tell server to create a new room
     * will autojoin room
     * Usage: "CREATE roomName"
     */
    public static final String CREATE = "/create";

    /**
     * Disconnects a client from the server
     * Usage: "DISCONNECT"
     */
    public static final String DISCONNECT = "/disconnect";

    /**
     * Displays a list of the protocol commands
     * Usage: "HELP"
     */
    public static final String HELP = "/help";

    /**
     * Sent from client to request a list of rooms
     * Usage: "ROOMS"
     */
    public static final String ROOMS = "/rooms";

    /**
     * Indicates an error has occurred somewhere
     * Depending on the location of the error the client may be disconnected, a room closed or the server shutdown as a whole
     * Includes a string of where the error occurred
     * Usage: "ERR Client IO"
     */
    public static final String ERR = "/err";

}
