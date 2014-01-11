package com.example.wirelessdebug;

import com.stericson.RootTools.RootTools;

import android.app.Application;

public final class GlobalConfig extends Application {

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		this.init();
	}

	private void init() {
		// TODO Auto-generated method stub
		RootTools.debugMode = true;
	}
	
}
