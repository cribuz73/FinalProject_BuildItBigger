package com.udacity.gradle.builditbigger.backend;

import java.util.ArrayList;

/** The object model for the data we are sending through endpoints */
public class MyBean {

    private ArrayList<String> myData;

    public ArrayList<String> getData() {
        return myData;
    }

    public void setData(ArrayList<String> data) {
        myData = data;
    }
}