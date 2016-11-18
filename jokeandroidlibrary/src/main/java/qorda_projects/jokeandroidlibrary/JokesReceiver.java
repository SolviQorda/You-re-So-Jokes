package qorda_projects.jokeandroidlibrary;

import android.content.Intent;

/**
 * Created by sorengoard on 18/11/2016.
 */

public class JokesReceiver {

    public JokesReceiver() {}

    public void onReceiveIntent(Intent intent) {
        intent.getBundleExtra("jokeString");
    }
}
