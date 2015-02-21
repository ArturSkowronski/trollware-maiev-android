package maiev.trollware.com.maiev.connections.events;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by arturskowronski on 21/02/15.
 */
public class GameNotJoinedResponse {
    private JSONObject obj;
    private String error;

    public GameNotJoinedResponse(JSONObject obj) {
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
