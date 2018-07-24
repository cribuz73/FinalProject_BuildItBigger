package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import com.example.android.androidlib.Delivery;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
   ProgressBar mProgresBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mProgresBar = findViewById(R.id.progress_bar);
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


    @SuppressWarnings("unchecked")

    public void tellJoke(View view) {
        mProgresBar.setVisibility(View.VISIBLE);
        new AsynkTaskActivity(new AsynkTaskActivity.EndTaskListener() {

            @Override
            public void onTaskComplete(ArrayList<String> jokes) {
                mProgresBar.setVisibility(View.INVISIBLE);
                if (jokes != null){
                    Intent intent = new Intent(MainActivity.this, Delivery.class);
                    intent.putExtra("joke_intent",jokes);
                    startActivity(intent);            }
                    else {
                    Log.d(TAG, "error !!!");
                }
            }
        }).execute();
    }

}
