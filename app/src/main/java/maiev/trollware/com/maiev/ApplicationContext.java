package maiev.trollware.com.maiev;

import android.app.Application;
import android.content.res.Configuration;

import com.github.nkzawa.emitter.Emitter;
import com.squareup.otto.Bus;
import com.squareup.otto.ThreadEnforcer;

import org.json.JSONObject;

import java.net.Socket;
import java.net.URISyntaxException;

import maiev.trollware.com.maiev.connections.MainThreadBus;
import maiev.trollware.com.maiev.connections.ServerConnector;
import maiev.trollware.com.maiev.connections.SocketEvents;

/**
 * Created by arturskowronski on 21/02/15.
 */

public class ApplicationContext extends Application {
    public static MainThreadBus BUS = new MainThreadBus();
    private ServerConnector serverConnector;

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    public void onEvent(SocketEvents createGame, Emitter.Listener listener){
        serverConnector.on(createGame.getEvent(), listener);
    }

    public void emitEvent(SocketEvents createGame, JSONObject object){
        serverConnector.emit(createGame.getEvent(), object);
    }


    @Override
    public void onCreate() {
        super.onCreate();
        serverConnector = new ServerConnector();
        try {
            serverConnector.initializeConnection();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

}