package qorda_projects.jokeandroidlibrary;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;


/**
 * Created by sorengoard on 18/11/2016.
 */

public class JokesReceiver extends AppCompatActivity{

    public static final String LOG_TAG = JokesReceiver.class.getSimpleName().toString();
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.joke_receiver);
        Intent intent = getIntent();
        String joke = intent.getStringExtra(JokesReceiverFragment.JOKE_INTENT_KEY);
        Log.v(LOG_TAG, "resultstr@JR: " + joke);
        TextView jokeText = (TextView) findViewById(R.id.joke_text);
        jokeText.setText(joke);
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }


}
