package com.pasenger.activitytest;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity {
    public static final String TAG = "FirstActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.first_layout);

        Button button1 = (Button) findViewById(R.id.button_1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(FirstActivity.this, "You click button 1", Toast.LENGTH_SHORT).show();

                //销毁活动
                //finish();

                //显示启动活动
                //Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                //startActivity(intent);

                //隐式启动活动
                //需要现在AndroidManifest.xml中配置
                Intent intent = new Intent("com.pasenger.activitytest.SECONDACTIVITY");

                //默认category为：android.intent.category.DEFAULT， 可以不设置
                intent.addCategory("com.pasenger.activitytest.SECONDACTIVITYCATEGORY");

                //startActivity(intent);

                //传递数据
                intent.putExtra("extra_data", "Hello SecondActivity");

                //需要返回
                startActivityForResult(intent, 1);
            }
        });

        Button button2 = (Button) findViewById(R.id.button_2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.baidu.com"));
                startActivity(intent);
            }
        });

        Button button3 = (Button) findViewById(R.id.button_3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:10086"));
                startActivity(intent);
            }
        });
    }

    /**
     * 加载菜单
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);

        return true;
    }

    /**
     * 选中菜单事件
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.add_item:
                Toast.makeText(FirstActivity.this, "You select Add menu", Toast.LENGTH_SHORT).show();

                break;
            case R.id.remove_item:
                Toast.makeText(FirstActivity.this, "You select Remove menu", Toast.LENGTH_SHORT).show();

                break;
            default:
        }

        return true;
    }

    //取得startActivityForResult的返回值
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode){
            case 1:
                String returnData = data.getStringExtra("data_return");
                Log.d(TAG, "onActivityResult: " + returnData);
                break;
            default:
        }
    }


}
