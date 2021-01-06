package com.example.travelpage;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class MyBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("MyBroadcastReceiver","接收到了广播");
        Log.i("MyBroadcastReceiver",intent.getAction());
    }
}
