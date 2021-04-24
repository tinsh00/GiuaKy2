package com.example.giuaki.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.giuaki.R;

public class LoginActivity extends AppCompatActivity {
    Button btnLogin,btnResign;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        AnhXa();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(LoginActivity.this, "caiqq", Toast.LENGTH_SHORT).show();

                startActivity(new Intent(LoginActivity.this,LoginActivity2.class));
            }
        });
    }

    private void AnhXa() {
        btnLogin=(Button)findViewById(R.id.btnLogin);
        btnResign=(Button)findViewById(R.id.btnResigner);
    }
}