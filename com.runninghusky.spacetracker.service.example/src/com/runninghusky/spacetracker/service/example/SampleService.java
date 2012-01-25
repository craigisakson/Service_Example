package com.runninghusky.spacetracker.service.example;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Binder;
import android.os.IBinder;
import android.widget.Toast;

public class SampleService extends Service {
	private NotificationManager mNM;
	public Context ctx = this;
	public LocationManager fullLocManager;
	public LocationListener fullLocListener;

	// Unique Identification Number for the Notification.
	// We use it on Notification start, and to cancel it.
	private int NOTIFICATION = 1;

	/**
	 * Class for clients to access. Because we know this service always runs in
	 * the same process as its clients, we don't need to deal with IPC.
	 */
	public class LocalBinder extends Binder {
		SampleService getService() {
			return SampleService.this;
		}
	}

	@Override
	public void onCreate() {
		mNM = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

		// Display a notification about us starting. We put an icon in the
		// status bar.
		showNotification();
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		// We want this service to continue running until it is explicitly
		// stopped, so return sticky.

		// This is the method we would put the code that does the work

		return START_STICKY;
	}

	@Override
	public void onDestroy() {
		// Cancel the persistent notification.
		mNM.cancel(NOTIFICATION);

		// Tell the user we stopped.
		Toast.makeText(this, "The Service has Stopped", Toast.LENGTH_SHORT)
				.show();
	}

	@Override
	public IBinder onBind(Intent intent) {
		return mBinder;
	}

	// This is the object that receives interactions from clients. See
	// RemoteService for a more complete example.
	private final IBinder mBinder = new LocalBinder();

	/**
	 * Show a notification while this service is running.
	 */
	private void showNotification() {
		CharSequence text = "Service has started...";
		Notification notification = new Notification(R.drawable.ic_launcher,
				text, System.currentTimeMillis());
		// This is the intent that is fired off after the user clicks the
		// notification
		PendingIntent contentIntent = PendingIntent.getActivity(this, 0,
				new Intent(this, StopServiceActivity.class), 0);
		notification.setLatestEventInfo(this, text,
				"Click to stop the service...", contentIntent);

		mNM.notify(NOTIFICATION, notification);
	}

}
