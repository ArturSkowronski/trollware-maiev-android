package maiev.trollware.com.maiev.connections;

import com.github.nkzawa.emitter.Emitter;
import com.github.nkzawa.socketio.client.IO;
import com.github.nkzawa.socketio.client.Socket;
import com.squareup.otto.Bus;

import java.net.URISyntaxException;

import maiev.trollware.com.maiev.ApplicationContext;
import maiev.trollware.com.maiev.connections.events.ConnectedEvent;

/**
 * Created by arturskowronski on 21/02/15.
 */

public class ServerConnector {
    Bus bus = ApplicationContext.BUS;
    public void initializeConnection() throws URISyntaxException {
        final Socket socket = IO.socket("http://192.168.56.1:5000/");
        socket.on(Socket.EVENT_CONNECT, new Emitter.Listener() {
            @Override
            public void call(Object... args) {
                bus.post(new ConnectedEvent("connected"));
            }
        }).on("event", new Emitter.Listener() {

            @Override
            public void call(Object... args) {}

        }).on(Socket.EVENT_DISCONNECT, new Emitter.Listener() {

            @Override
            public void call(Object... args) {}

        });
        socket.connect();
    }
}
