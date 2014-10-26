package com.example.usbtest;

import android.app.Application;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.usb.UsbManager;
import android.util.Log;
import android.widget.Toast;

public class USBTestApplication extends Application {
	private final String TAG = USBTestApplication.class.getSimpleName();

	private UsbBroadcastReceiver mTestReceiver;
	private IntentFilter mIntentFilter;

	@Override
	public void onCreate() {
		Log.d(TAG, "onCreate");
		Toast.makeText(this, "USBTestApplication onCreate", Toast.LENGTH_SHORT).show();
		mTestReceiver = new UsbBroadcastReceiver();
		mIntentFilter = new IntentFilter();
		mIntentFilter.addAction(UsbManager.ACTION_USB_DEVICE_ATTACHED);
		mIntentFilter.addAction(UsbManager.ACTION_USB_DEVICE_DETACHED);
		mIntentFilter.addAction(Intent.ACTION_HEADSET_PLUG);
		mIntentFilter.addAction(Intent.ACTION_CAMERA_BUTTON);
		registerReceiver(mTestReceiver, mIntentFilter);
	}
}
