package maiev.trollware.com.maiev.connections;

/**
 * Created by arturskowronski on 21/02/15.
 */
public enum SocketEvents {

    CREATE_GAME("createGame"),
    GAME_CREATED("gameCreated"),
    JOIN_GAME("joinGame"),
    GAME_NOT_CREATED("gameNotCreated"),
    GAME_NOT_JOINED("gameNotJoined"),
    GAME_JOINED("gameJoined");

    private String event;

    SocketEvents(String event) {
        this.event = event;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }
}
