package com.example.android.sync;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/**
 * Created by liu on 8/03/15.
 */
public class SyncService extends Service {

    private static SyncAdapter sSyncAdapter = null;

    static final Object sSyncAdapterLock = new Object();

    @Override
    public void onCreate() {
        super.onCreate();

        synchronized (sSyncAdapterLock){
            if (sSyncAdapter == null){
                sSyncAdapter = new SyncAdapter(getApplicationContext(), true);
            }
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return sSyncAdapter.getSyncAdapterBinder();
    }
}
