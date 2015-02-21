package maiev.trollware.com.maiev.connections.events;

/**
 * Created by arturskowronski on 21/02/15.
 */
public class ConnectedEvent {
    private String message;

    public ConnectedEvent(String message) {
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
