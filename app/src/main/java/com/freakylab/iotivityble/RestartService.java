package com.freakylab.iotivityble;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class RestartService extends BroadcastReceiver {
    public RestartService() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        if(intent.getAction().equals("ACTION.RESTART.PersistentService")) {
            Log.i("JS RestartService", "ACTION.RESTART.PersistentService");

            Intent i = new Intent(context, LEService.class);
            context.startService(i);
        }

        if(intent.getAction().equals(Intent.ACTION_BOOT_COMPLETED)) {
            Log.i("RestartService", "ACTION_BOOT_COMPLETED");
            Intent i = new Intent(context, LEService.class);
            context.startService(i);
        }
    }
}
