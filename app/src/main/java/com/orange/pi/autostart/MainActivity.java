package com.orange.pi.autostart;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {
    private static final String PLAYER_PACKAGE = "com.softwinner.TvdVideo";
    private static final String PLAYER_ACTIVITY = "com.softwinner.TvdVideo.TvdVideoActivity";
    private static final String VIDEO = "file:///sdcard/Movies/Punto_TV.mp4";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setPadding(32, 48, 32, 32);
        TextView title = new TextView(this);
        title.setText("Orange Pi — запуск видео\n\nФайл: Punto_TV.mp4");
        title.setTextSize(22);
        layout.addView(title);
        Button start = new Button(this);
        start.setText("ЗАПУСТИТЬ ВИДЕО");
        start.setTextSize(20);
        start.setOnClickListener(v -> launchPlayer());
        layout.addView(start);
        setContentView(layout);
    }

    private void launchPlayer() {
        Intent launch = new Intent();
        launch.setComponent(new ComponentName(PLAYER_PACKAGE, PLAYER_ACTIVITY));
        launch.setDataAndType(Uri.parse(VIDEO), "video/mp4");
        launch.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(launch);
    }
}
