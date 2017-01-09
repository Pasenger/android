package com.pasenger.activitytest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {

    public static final String TAG = "SecondActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        Log.d(TAG, "extra_data: " + intent.getStringExtra("extra_data"));

        Button button = (Button) findViewById(R.id.button_21);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("data_return", "Hello FirstActivity");

                //返回数据给上一个活动
                setResult(RESULT_OK, intent);

                finish();
            }
        });
    }

    /**
     * 按下Back键时返回值
     */
    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("data_return", "Hello FirstActivity");

        //返回数据给上一个活动
        setResult(RESULT_OK, intent);

        finish();

    }
}
