package maiev.trollware.com.maiev;

import android.app.Application;
import android.content.res.Configuration;

import com.squareup.otto.Bus;
import com.squareup.otto.ThreadEnforcer;

import maiev.trollware.com.maiev.connections.MainThreadBus;
import maiev.trollware.com.maiev.connections.ServerConnector;

/**
 * Created by arturskowronski on 21/02/15.
 */

public class ApplicationContext extends Application {
    public static MainThreadBus BUS = new MainThreadBus();
    public static ServerConnector serverConnector = new ServerConnector();

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public void onCreate() {
        super.onCreate();

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