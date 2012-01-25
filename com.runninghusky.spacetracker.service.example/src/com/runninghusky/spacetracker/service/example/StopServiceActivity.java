package com.runninghusky.spacetracker.service.example;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningServiceInfo;
import android.content.Intent;
import android.os.Bundle;

public class StopServiceActivity extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// Check to see if the service is running
		// If the service is running, stop it and finish
		if (myServiceIsRunning()) {
			stopService(new Intent(this, SampleService.class));
		}
		finish();
	}

	private boolean myServiceIsRunning() {
		ActivityManager manager = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
		for (RunningServiceInfo service : manager
				.getRunningServices(Integer.MAX_VALUE)) {
			if ("com.runninghusky.spacetracker.service.example.SampleService"
					.equalsIgnoreCase(service.service.getClassName())) {
				return true;
			}
		}
		return false;
	}
}
