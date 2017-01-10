package com.pasenger.recyclerviewtest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button) findViewById(R.id.btn_1);
        button1.setOnClickListener(this);

        Button button2 = (Button) findViewById(R.id.btn_2);
        button2.setOnClickListener(this);

        Button button3 = (Button) findViewById(R.id.btn_3);
        button3.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_1:

                Intent intent1 = new Intent(MainActivity.this, VerticalRecyclerViewActivity.class);
                startActivity(intent1);

                break;
            case R.id.btn_2:

                Intent intent2 = new Intent(MainActivity.this, HorizontalRecyclerViewActivity.class);
                startActivity(intent2);

                break;
            case R.id.btn_3:

                Intent intent3 = new Intent(MainActivity.this, StaggeredActivity.class);
                startActivity(intent3);

                break;
            default:
        }
    }
}
