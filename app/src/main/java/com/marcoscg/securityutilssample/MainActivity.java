package com.marcoscg.securityutilssample;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.marcoscg.securityutils.AntiAdBlocker;
import com.marcoscg.securityutils.AppBlocker;
import com.marcoscg.securityutils.RootDetector;

@SuppressWarnings("all")
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        ((TextView) findViewById(R.id.root_tv)).setText("Root present: " + RootDetector.isRootPresent());

        ((TextView) findViewById(R.id.adblock_tv)).setText("AdBlock present: " + AntiAdBlocker.isAdBlockerPresent(true));

        AppBlocker.with(this)
                .withFileUrl("https://raw.githubusercontent.com/marcoscgdev/marcoscgdev.github.io/master/assets/sc_block.txt")
                .withListener(new AppBlocker.AppBlockerListener() {
                    @Override
                    public void onResult(boolean blockApp) {
                        ((TextView) findViewById(R.id.appblock_tv)).setText("Block app: " + blockApp);
                        progressDialog.dismiss();
                    }

                    @Override
                    public void onError() {
                        // TODO
                    }
                });
    }
}