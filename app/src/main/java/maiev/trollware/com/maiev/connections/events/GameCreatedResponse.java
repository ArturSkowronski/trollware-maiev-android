package maiev.trollware.com.maiev.connections.events;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by arturskowronski on 21/02/15.
 */
public class GameCreatedResponse {
    private JSONObject obj;
    private String gameID;

    public GameCreatedResponse(JSONObject obj) {
        try {
            gameID = obj.getString("gameID");
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

    public String getGameID() {
        return gameID;
    }

    public void setGameID(String gameID) {
        this.gameID = gameID;
    }
}
