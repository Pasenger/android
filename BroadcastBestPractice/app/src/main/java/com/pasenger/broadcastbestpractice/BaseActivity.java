package com.pasenger.broadcastbestpractice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.preference.DialogPreference;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.TintContextWrapper;
import android.widget.Toast;

/**
 * Created by pasen on 2017/2/19.
 */

public class BaseActivity extends AppCompatActivity {

    private ForceOfflineReceiver receiver;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityConllector.addActivity(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.pasenger.bbp.FORCE_OFFLINE");

        receiver = new ForceOfflineReceiver();
        registerReceiver(receiver, intentFilter);
    }

    @Override
    protected void onPause() {
        super.onPause();

        if(receiver != null){
            unregisterReceiver(receiver);

            receiver = null;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        ActivityConllector.removeActivity(this);
    }

    /**
     * 强制下线广播接收器
     */
    class ForceOfflineReceiver extends BroadcastReceiver{
        @Override
        public void onReceive(final Context context, Intent intent) {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setTitle("Warning");
            builder.setMessage("You are forced to be offline. Please try to login again.");
            builder.setCancelable(false);

            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    ActivityConllector.finishAll(); //销毁所有活动

                    Intent intent1 = new Intent(context, LoginActivity.class);
                    context.startActivity(intent1);
                }
            });

            builder.show();


//            Toast.makeText(context, "You are forced to be offline. Please try to login again.", Toast.LENGTH_SHORT).show();
//
//            ActivityConllector.finishAll(); //销毁所有活动
//            Intent intent1 = new Intent(context, LoginActivity.class);
//            context.startActivity(intent1);


        }
    }
}
