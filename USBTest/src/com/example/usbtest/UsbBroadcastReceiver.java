//debug
package com.example.usbtest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.hardware.usb.UsbManager;
import android.util.Log;
import android.widget.Toast;

public class UsbBroadcastReceiver extends BroadcastReceiver {

	private final String TAG = UsbBroadcastReceiver.class.getSimpleName();
	private static final String ACTION_USB_PERMISSION = "com.tapioka.android.USB_PERMISSION";

	@Override
	public void onReceive(Context context, Intent intent) {
		Log.v(TAG, "onReceive()####");
		String action = intent.getAction();
		if (UsbManager.ACTION_USB_DEVICE_ATTACHED.equals(action)) {
			Toast.makeText(context, "USB is connected", Toast.LENGTH_SHORT)
					.show();
		} else if (ACTION_USB_PERMISSION.equals(action)) {
			Toast.makeText(context, "Permission granted ", Toast.LENGTH_SHORT)
					.show();
		} else if (UsbManager.ACTION_USB_DEVICE_DETACHED.equals(action)) {
			Toast.makeText(context, "USB is disconnected", Toast.LENGTH_SHORT)
					.show();
		} else if (Intent.ACTION_HEADSET_PLUG.equals(action)) {
			int state = intent.getIntExtra("state", -1);
			switch (state) {
			case 0:
				Log.d(TAG, "Headset is unplugged");
				Toast.makeText(context, "Headset is unplugged",
						Toast.LENGTH_SHORT).show();

				break;
			case 1:
				Log.d(TAG, "Headset is plugged");
				Toast.makeText(context, "Headset is plugged",
						Toast.LENGTH_SHORT).show();
				break;
			default:
				Log.d(TAG, "I have no idea what the headset state is");
				Toast.makeText(context,
						"I have no idea what the headset state is",
						Toast.LENGTH_SHORT).show();
			}
		} else if (Intent.ACTION_BATTERY_LOW.equals(action)) {
			Log.d(TAG, "Battery Low tapioka");
			Toast.makeText(context, "Battery Low tapioka", Toast.LENGTH_SHORT)
					.show();
		} else if (Intent.ACTION_CAMERA_BUTTON.equals(action)) {
			Log.d(TAG, "Camera Button tapioka");
			Toast.makeText(context, "Camera Button tapioka", Toast.LENGTH_SHORT)
					.show();
		} else if (Intent.ACTION_BOOT_COMPLETED.equals(action)) {
			Log.d(TAG, "Boot complete tapioka");
			Toast.makeText(context, "Boot complete tapioka", Toast.LENGTH_SHORT)
					.show();
		}

	}

}
