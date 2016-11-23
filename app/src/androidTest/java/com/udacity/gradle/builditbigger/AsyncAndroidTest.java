package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.support.test.runner.AndroidJUnit4;
import android.support.v4.util.Pair;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertFalse;

/**
 * Created by sorengoard on 22/11/2016.
 */
@RunWith(AndroidJUnit4.class)
public class AsyncAndroidTest {
    public Context getContext() {
        return mContext;
    }
    private Context mContext = getContext();

    @Test
    public void testVerifyAsyncString() {
        try {
            EndpointsAsyncTask mEndpointsAsyncTask = new EndpointsAsyncTask();
            mEndpointsAsyncTask.execute(new Pair<Context, String>(mContext, "joke"));
            assertFalse(EndpointsAsyncTask.jokeString.isEmpty());
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
