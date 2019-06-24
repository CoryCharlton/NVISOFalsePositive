package com.ccswe.nvisofalsepositive;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.os.Bundle;
import android.provider.Settings;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final String deviceId = Settings.Secure.getString(getContentResolver(), Settings.Secure.ANDROID_ID);
        showDialogFragment(AlertDialogFragment.newInstance(22309409, "This is some dialog text...", getString(R.string.app_name), getString(android.R.string.ok), null, null, false), false);
    }

    public void showDialogFragment(DialogFragment dialogFragment, boolean cancelable) {
        dialogFragment.setCancelable(cancelable);
        dialogFragment.setShowsDialog(true);
        dialogFragment.show(getSupportFragmentManager(), "dialog_fragment");
    }
}
