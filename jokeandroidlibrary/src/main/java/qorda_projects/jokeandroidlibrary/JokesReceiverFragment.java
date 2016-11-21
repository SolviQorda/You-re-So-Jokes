package qorda_projects.jokeandroidlibrary;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by sorengoard on 18/11/2016.
 */

public class JokesReceiverFragment extends Fragment {

    public static final String JOKE_INTENT_KEY = "jokeString";

    public JokesReceiverFragment(){};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View root = inflater.inflate(R.layout.joke_receiver, container, false);
        onReceiveIntent(root);
        return root;

    }

    public void onReceiveIntent(View view) {

    }

}
