package com.udacity.gradle.builditbigger;

import org.junit.Test;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.fail;


public class AsynkTaskActivityTest {


    @Test
    public void doInBackground() {
        String result;

        AsynkTaskActivity task = new AsynkTaskActivity(new AsynkTaskActivity.EndTaskListener() {
            @Override
            public void onTaskComplete(ArrayList<String> jokes) {

            }
        });

        try {
            task.execute();
            result = task.get().get(0);
            assertNotNull("No joke !", result);
        } catch (InterruptedException ie) {
            fail("Error !");
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}