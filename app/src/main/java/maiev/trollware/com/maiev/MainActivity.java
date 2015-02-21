package maiev.trollware.com.maiev;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.squareup.otto.Subscribe;

import org.json.JSONException;
import org.json.JSONObject;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import maiev.trollware.com.maiev.connections.MainThreadBus;
import maiev.trollware.com.maiev.connections.events.ConnectedEvent;
import maiev.trollware.com.maiev.connections.events.GameCreatedListener;
import maiev.trollware.com.maiev.connections.events.GameCreatedResponse;
import maiev.trollware.com.maiev.connections.events.GameJoinedListener;
import maiev.trollware.com.maiev.connections.events.GameJoinedResponse;
import maiev.trollware.com.maiev.connections.events.GameNotCreatedListener;
import maiev.trollware.com.maiev.connections.events.GameNotCreatedResponse;
import maiev.trollware.com.maiev.connections.events.GameNotJoinedListener;
import maiev.trollware.com.maiev.connections.events.GameNotJoinedResponse;

import static maiev.trollware.com.maiev.connections.SocketEvents.CREATE_GAME;
import static maiev.trollware.com.maiev.connections.SocketEvents.GAME_CREATED;
import static maiev.trollware.com.maiev.connections.SocketEvents.JOIN_GAME;
import static maiev.trollware.com.maiev.connections.SocketEvents.GAME_NOT_CREATED;
import static maiev.trollware.com.maiev.connections.SocketEvents.GAME_NOT_JOINED;
import static maiev.trollware.com.maiev.connections.SocketEvents.GAME_JOINED;


public class MainActivity extends ActionBarActivity {

    MainThreadBus bus = ApplicationContext.BUS;
    ApplicationContext mApplication;

    @OnClick(R.id.join_game)
    public void joinGame() {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("gameID", gameId.getText().toString());
            mApplication.emitEvent(JOIN_GAME, jsonObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    @InjectView(R.id.game_id)
    EditText gameId;

    @OnClick(R.id.create_game)
    public void createGame() {
        mApplication.emitEvent(CREATE_GAME, new JSONObject());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        bus.register(this);

        mApplication = (ApplicationContext)getApplicationContext();

        mApplication.onEvent(GAME_CREATED, new GameCreatedListener());
        mApplication.onEvent(GAME_NOT_CREATED, new GameNotCreatedListener());
        mApplication.onEvent(GAME_JOINED, new GameJoinedListener());
        mApplication.onEvent(GAME_NOT_JOINED, new GameNotJoinedListener());

    }

    @Subscribe
    public void connectedEvent(ConnectedEvent event) {
        Toast.makeText(this, event.getMessage(), Toast.LENGTH_LONG).show();
    }

    @Subscribe
    public void gameCreatedEvent(GameCreatedResponse event) {
        gameId.setText(event.getGameID());
        Toast.makeText(this, "Game Created: " + event.getGameID(), Toast.LENGTH_LONG).show();
    }

    @Subscribe
    public void gameNotCreatedEvent(GameNotCreatedResponse event) {
        Toast.makeText(this, "Game Not Created: " + event.getError(), Toast.LENGTH_LONG).show();
    }

    @Subscribe
    public void gameNotJoinedEvent(GameNotJoinedResponse event) {
        Toast.makeText(this, "Game Not Joined: " + event.getError(), Toast.LENGTH_LONG).show();
    }

    @Subscribe
    public void gameJoinedEvent(GameJoinedResponse event) {
        Toast.makeText(this, "Game Joined", Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
