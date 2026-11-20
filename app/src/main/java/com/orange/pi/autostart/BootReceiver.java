package com.orange.pi.autostart;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

public class BootReceiver extends BroadcastReceiver {
    private static final String TAG = "OrangePiAutoStart";

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent == null ? null : intent.getAction();
        if (Intent.ACTION_BOOT_COMPLETED.equals(action)
                || Intent.ACTION_MY_PACKAGE_REPLACED.equals(action)) {
            new Handler(Looper.getMainLooper()).postDelayed(() -> {
                try {
                    Intent launch = new Intent();
                    launch.setComponent(new ComponentName(
                            "com.softwinner.TvdVideo",
                            "com.softwinner.TvdVideo.TvdVideoActivity"));
                    launch.setDataAndType(
                            Uri.parse("file:///sdcard/Movies/Punto_TV.mp4"), "video/mp4");
                    launch.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    context.startActivity(launch);
                    Log.i(TAG, "TvdVideo launch requested after " + action);
                } catch (Exception e) {
                    Log.e(TAG, "Could not launch TvdVideo after " + action, e);
                }
            }, 15000);
        }
    }
}
