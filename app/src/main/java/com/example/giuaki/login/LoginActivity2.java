package com.example.giuaki.login;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.giuaki.ActivityHomePage;
import com.example.giuaki.R;
import com.example.giuaki.qltthu.ThuthuActivity;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity2 extends AppCompatActivity {
    EditText etlogin,etpass;
    Button btnLogin;
    //nếu trafic thì nhớ thêm manifest android:usesCleartextTraffic="true"
    String urlLogin="http://192.168.43.104/giuaki/login.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
        AnhXa();
        XuLi();
    }

    private void XuLi() {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etlogin==null||etpass==null){
                    Toast.makeText(LoginActivity2.this, "Hãy nhập đủ thông tin!!", Toast.LENGTH_SHORT).show();

                }
                else {
                    Login(etlogin.getText().toString(),etpass.getText().toString());
                }
            }
        });
    }


    private void AnhXa() {
        etlogin=(EditText)findViewById(R.id.txtLogin);
        etpass=(EditText)findViewById(R.id.txtPass);
        btnLogin=(Button) findViewById(R.id.btnLogin2);
    }
    private void Login(String tk,String mk){
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, urlLogin,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if(response.equals("success")){
                            Toast.makeText(LoginActivity2.this, "Đăng nhập thành công CLIENT!!", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(LoginActivity2.this, ActivityHomePage.class));
                        }else if(response.equals("success2")){
                            Toast.makeText(LoginActivity2.this, "Đăng nhập thành công ADMIN!!", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(LoginActivity2.this, ThuthuActivity.class));
                        }
                        else
                            Toast.makeText(LoginActivity2.this, "Đăng nhập thất bại!!", Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(LoginActivity2.this, "Lỗi "+error.toString(), Toast.LENGTH_SHORT).show();
            }
        }){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params= new HashMap<>();
                params.put("taikhoan",tk);
                params.put("matkhau",mk);
                return params;
            }
        };
        requestQueue.add(stringRequest);
    }
}