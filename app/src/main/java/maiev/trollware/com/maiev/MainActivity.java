package maiev.trollware.com.maiev;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.crashlytics.android.Crashlytics;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;

import java.net.URISyntaxException;

import maiev.trollware.com.maiev.connections.MainThreadBus;
import maiev.trollware.com.maiev.connections.ServerConnector;
import maiev.trollware.com.maiev.connections.events.ConnectedEvent;


public class MainActivity extends ActionBarActivity {

    MainThreadBus bus = ApplicationContext.BUS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ApplicationContext mApplication = (ApplicationContext)getApplicationContext();
        bus.register(this);
        ServerConnector serverConnector = new ServerConnector();
        try {
            serverConnector.initializeConnection();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    @Subscribe
    public void answerAvailable(ConnectedEvent event) {
        Toast.makeText(this,event.getMessage(), Toast.LENGTH_LONG).show();
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
