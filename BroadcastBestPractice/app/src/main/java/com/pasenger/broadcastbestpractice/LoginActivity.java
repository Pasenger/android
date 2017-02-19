package com.pasenger.broadcastbestpractice;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by pasen on 2017/2/19.
 */

public class LoginActivity extends BaseActivity {

    private EditText accountEdit;

    private EditText passwordEdit;

    private Button loginButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

        accountEdit = (EditText) findViewById(R.id.account);
        passwordEdit = (EditText) findViewById(R.id.password);
        loginButton = (Button) findViewById(R.id.login);

        loginButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                String account = accountEdit.getText().toString();
                String password = passwordEdit.getText().toString();

                if("admin".equals(account) && "123456".equals(password)){
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);

                    startActivity(intent);

                    finish();
                }else{
                    Toast.makeText(LoginActivity.this, "account or password is invalid!",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
