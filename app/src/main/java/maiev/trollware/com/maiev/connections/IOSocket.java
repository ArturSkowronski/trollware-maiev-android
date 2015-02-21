package maiev.trollware.com.maiev.connections;

import com.github.nkzawa.emitter.Emitter;
import com.github.nkzawa.socketio.client.Manager;
import com.github.nkzawa.socketio.client.Socket;

/**
 * Created by arturskowronski on 21/02/15.
 */
public class IOSocket extends Socket {

    public IOSocket(Manager io, String nsp) {
        super(io, nsp);
    }

    public IOSocket on(SocketEvents events, Emitter.Listener listener){
        on(events.getEvent(), listener);
        return this;
    }
}
