package com.example.ex2;

import android.app.Application;
import android.content.res.Configuration;
import android.util.Log;

public class MyApp extends Application {
	final static String  MY_TAG = "MyApp";

	@Override
	public void onCreate() {
    	Log.d(MY_TAG, "App:onCreate() event"); 
		super.onCreate();
	}

	@Override
	public void onTerminate() {
    	Log.d(MY_TAG, "App:onTerminate() event"); 
		super.onTerminate();
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
    	Log.d(MY_TAG, "App:onConfigurationChanged() event"); 
		super.onConfigurationChanged(newConfig);
	}

}
