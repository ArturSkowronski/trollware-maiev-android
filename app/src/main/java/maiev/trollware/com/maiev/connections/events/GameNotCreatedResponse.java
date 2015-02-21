package maiev.trollware.com.maiev.connections.events;

import com.github.nkzawa.emitter.Emitter;

import org.json.JSONException;
import org.json.JSONObject;

import maiev.trollware.com.maiev.ApplicationContext;
import maiev.trollware.com.maiev.connections.MainThreadBus;

/**
 * Created by arturskowronski on 21/02/15.
 */
public class GameNotCreatedResponse {
    private JSONObject obj;
    private String error;

    public GameNotCreatedResponse(JSONObject obj) {
        try {
            error = obj.getString("error");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
