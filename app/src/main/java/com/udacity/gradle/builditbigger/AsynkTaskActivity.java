package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.example.android.jokes_java_lib.Joke;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

import java.io.IOException;
import java.util.ArrayList;

public class AsynkTaskActivity extends AsyncTask <Joke, Void, ArrayList<String>> {

    private static final String TAG = AsynkTaskActivity.class.getSimpleName();
    private static MyApi myApiService = null;
    private EndTaskListener mEndTaskListener;
    private Context mContext;
    private Joke mJoke;

    public interface EndTaskListener {

        void onTaskComplete(ArrayList<String> jokes);
    }

    public AsynkTaskActivity(EndTaskListener listener) {
        mEndTaskListener = listener;
    }

    @Override
    protected ArrayList<String> doInBackground(Joke...jokes) {


        if (myApiService == null) {
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl("http://10.0.3.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });

            myApiService = builder.build();
        }


        try {
            return (new ArrayList<>(myApiService.getJoke().execute().getData()));
        } catch (IOException e) {
            Log.d(TAG, e.getMessage());
            return null;
        }
    }




    @Override
    protected void onPostExecute(ArrayList<String> s) {
        if(s != null){
            mEndTaskListener.onTaskComplete(s);
        }else{
            Log.d(TAG, "Errorr !!!");
        }
    }
}