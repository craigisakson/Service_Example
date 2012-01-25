package com.runninghusky.spacetracker.service.example;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StartActivity extends Activity {
	private Context ctx = this;

	/** Called when the activity is first created. */
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