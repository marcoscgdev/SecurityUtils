package com.marcoscg.securityutils;

import java.io.File;

/**
 * Created by @MarcosCGdev on 06/08/2017.
 */

@SuppressWarnings("all")
public class RootDetector {

    public static boolean isRootPresent() {
        return checkRootMethod1() || checkRootMethod2();
    }

    private static boolean checkRootMethod1() {
        String buildTags = android.os.Build.TAGS;
        return buildTags != null && buildTags.contains("test-keys");
    }

    private static boolean checkRootMethod2() {
        String[] paths = { "/system/app/Superuser.apk", "/sbin/su", "/system/bin/su", "/system/xbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/system/sd/xbin/su",
                "/system/bin/failsafe/su", "/data/local/su", "/su/bin/su"};
        for (String path : paths) {
            if (new File(path).exists()) return true;
        }
        return false;
    }

}
