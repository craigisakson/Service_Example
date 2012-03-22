package com.runninghusky.spacetracker.service.example;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * The Class StartActivity.
 */
public class StartActivity extends Activity {
	
	/** The ctx. */
	private Context ctx = this;

	/**
	 * Called when the activity is first created.
	 *
	 * @param savedInstanceState the saved instance state
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		Button btn = (Button) findViewById(R.id.ButtonStartService);
		btn.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				startService(new Intent(ctx, SampleService.class));
				finish();
			}
		});

	}
}