package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.sorengoard.myapplication.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;

import qorda_projects.jokeandroidlibrary.JokesReceiver;

import static android.R.attr.name;
import static com.udacity.gradle.builditbigger.EndpointsAsyncTask.jokeString;
import static qorda_projects.jokeandroidlibrary.JokesReceiverFragment.JOKE_INTENT_KEY;

class EndpointsAsyncTask extends AsyncTask<Pair<Context, String>, Void, String> {
    private static MyApi myApiService = null;
    private Context context;
    public static String jokeString;

    private static final String LOG_TAG = EndpointsAsyncTask.class.getSimpleName().toString();

    @Override
    protected String doInBackground(Pair<Context, String>... params) {
        if(myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    .setRootUrl("http://192.168.1.169:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            // end options for devappserver

            myApiService = builder.build();
        }

        context = params[0].first;
        String joke = params[0].second;

        try {
            return myApiService.makeJoke(joke).execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {

        Log.v(LOG_TAG, "resultstr:" + result);
        jokeString = result;
    }

}


public class MainActivity extends AppCompatActivity {

    public final String JOKE_INTENT_KEY = "jokeString";
    public final String LOG_TAG = MainActivity.class.getSimpleName().toString();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


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

//    JokesJavaLibrary mJokesJavaLibrary = new JokesJavaLibrary();
//    String jokeString = mJokesJavaLibrary.jokeOne;
//    String jokeStringTwo = mJokesJavaLibrary.jokeTwo;

    //what is called when the button is pressed.

    public void tellJoke(View view) {
//        Toast.makeText(this, jokeString, Toast.LENGTH_SHORT).show();
        new EndpointsAsyncTask().execute(new Pair<Context, String>(this, "joke"));

        if (jokeString != null)
        {
            Intent jokeIntent = new Intent(this, JokesReceiver.class);
            jokeIntent.putExtra(JOKE_INTENT_KEY, jokeString);
            Log.v(LOG_TAG, "resultsstr@tellJoke:" + jokeString);
            startActivity(jokeIntent);
        }

    }


}
