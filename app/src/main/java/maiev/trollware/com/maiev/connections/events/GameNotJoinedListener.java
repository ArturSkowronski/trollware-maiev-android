package maiev.trollware.com.maiev.connections.events;

import com.github.nkzawa.emitter.Emitter;

import org.json.JSONObject;

import maiev.trollware.com.maiev.ApplicationContext;
import maiev.trollware.com.maiev.connections.MainThreadBus;

/**
 * Created by arturskowronski on 21/02/15.
 */
public class GameNotJoinedListener implements Emitter.Listener {
    MainThreadBus bus = ApplicationContext.BUS;

    @Override
    public void call(Object... args) {
        JSONObject obj = (JSONObject)args[0];
        bus.post(new GameNotJoinedResponse(obj));
    }
}
