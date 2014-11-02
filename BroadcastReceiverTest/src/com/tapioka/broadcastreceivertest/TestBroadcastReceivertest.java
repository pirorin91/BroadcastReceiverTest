package com.tapioka.broadcastreceivertest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class TestBroadcastReceivertest extends BroadcastReceiver {

	private final String TAG = TestBroadcastReceivertest.class.getSimpleName();

	@Override
	public void onReceive(Context context, Intent intent) {
		Log.v(TAG, "onReceive() Tapioka");
		String action = intent.getAction();
		if (Intent.ACTION_BOOT_COMPLETED.equals(action)) {
			Toast.makeText(context, "Boot completed", Toast.LENGTH_SHORT)
					.show();
		} else if (Intent.ACTION_POWER_CONNECTED.equals(action)) {
			Toast.makeText(context, "Power Connected", Toast.LENGTH_SHORT)
					.show();
		}
	}

}
