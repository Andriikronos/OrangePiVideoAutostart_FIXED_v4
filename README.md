# Orange Pi Video Autostart v4

This revision uses the same explicit component launch as the verified ADB command, both from the button and the boot receiver. It also includes a launcher activity. Open the app once after installation to clear Android's newly-installed/stopped state. The activity has a button that launches `com.softwinner.TvdVideo/.TvdVideoActivity` with `/sdcard/Movies/Punto_TV.mp4`.

The boot receiver still requests the same player launch 15 seconds after BOOT_COMPLETED. Android 10+ firmware may restrict background activity launches; this APK cannot override firmware policy. The first-launch activation and boot-launch behavior must be tested on the Orange Pi.

Build with `gradle :app:assembleDebug` (Android SDK 35, Java 17, Gradle 8.7).
