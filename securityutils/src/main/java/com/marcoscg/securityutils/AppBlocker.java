package com.marcoscg.securityutils;

import android.app.Activity;
import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by @MarcosCGdev on 06/08/2017.
 */

@SuppressWarnings("all")
public class AppBlocker {

    private static Activity act;
    private AppBlockerListener appBlockerListener;
    private String url;

    public interface AppBlockerListener {
        public void onResult(boolean blockApp);
        public void onError();
    }

    public static AppBlocker with(Activity activity) {
        act = activity;
        return new AppBlocker();
    }

    public AppBlocker withFileUrl(String fileUrl) {
        url = fileUrl;
        return this;
    }

    public void withListener(AppBlockerListener listener) {
        appBlockerListener = listener;
        new DownloaderTask().execute(url);
    }

    private class DownloaderTask extends AsyncTask<String,String,String> {

        protected String doInBackground(String...urls) {
            String result = null;
            try {
                URL oracle = new URL(urls[0]);
                HttpURLConnection yc = (HttpURLConnection) oracle.openConnection();
                result = getStringFromInputStream(yc.getInputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
            return result;
        }

        protected void onPostExecute(String result) {
            if (result != null) {
                if (result.equals(""))
                    appBlockerListener.onResult(false);
                else appBlockerListener.onResult(true);
            } else {
                appBlockerListener.onResult(false);
                appBlockerListener.onError();
            }
        }
    }

    private static String getStringFromInputStream(InputStream is) {
        BufferedReader br = null;
        StringBuilder sb = new StringBuilder();
        String line;
        try {
            br = new BufferedReader(new InputStreamReader(is));
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return sb.toString();
    }

}
