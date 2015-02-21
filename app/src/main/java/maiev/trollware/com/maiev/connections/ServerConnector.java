package maiev.trollware.com.maiev.connections;

import com.github.nkzawa.emitter.Emitter;
import com.github.nkzawa.socketio.client.IO;
import com.github.nkzawa.socketio.client.Socket;
import com.squareup.otto.Bus;

import org.json.JSONObject;

import java.net.URISyntaxException;

import maiev.trollware.com.maiev.ApplicationContext;
import maiev.trollware.com.maiev.connections.events.ConnectedEvent;

/**
 * Created by arturskowronski on 21/02/15.
 */

public class ServerConnector {
    Bus bus = ApplicationContext.BUS;
    private Socket socket;

    public void on(String event, Emitter.Listener listener){
        socket.on(event, listener);
    }

    public void emit(String event, JSONObject object){
        socket.emit(event, object);
    }

    public void initializeConnection() throws URISyntaxException {
        socket = IO.socket("http://192.168.56.1:5000/");
        socket.connect();
    }
}
