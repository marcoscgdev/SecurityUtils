package com.marcoscg.securityutils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by @MarcosCGdev on 06/08/2017.
 */

@SuppressWarnings("all")
public class AntiAdBlocker {
    public static boolean isAdBlockerPresent(boolean showAd) {
        if (showAd){
            BufferedReader in = null;
            try {
                in = new BufferedReader(new InputStreamReader(
                        new FileInputStream("/etc/hosts")));
                String line;

                while ((line = in.readLine()) != null) {
                    if (line.contains("admob") && !line.matches("^ *#")) {
                        return true;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (in != null) {
                    try {
                        in.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return false;
    }
}