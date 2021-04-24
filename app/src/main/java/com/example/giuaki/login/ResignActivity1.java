package com.example.giuaki.login;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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
import com.example.giuaki.R;

import java.util.HashMap;
import java.util.Map;

public class ResignActivity1 extends AppCompatActivity {
    EditText etTKResign,etPassResign,etPassConfirm;
    Button btnResign;
    String urlResgn="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resign1);
        AnhXa();
        XuLi();


    }

    private void XuLi() {
        String tk = etTKResign.getText().toString().trim();
        String pass=etPassResign.getText().toString().trim();
        String pass2=etPassConfirm.getText().toString().trim();
        btnResign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tk.isEmpty()||pass.isEmpty()||pass2.isEmpty()){
                    Toast.makeText(ResignActivity1.this, "Hãy điền đủ thông tin", Toast.LENGTH_SHORT).show();
                }else{
                    if(pass2.equals(pass)){
                        KTResign(urlResgn);
                    }else {
                        Toast.makeText(ResignActivity1.this, "Pass nhập lại chưa chính xác , hãy kiểm tra lại !!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }

    private void AnhXa() {
        etTKResign=(EditText)findViewById(R.id.txtLogin);
        etPassResign=(EditText)findViewById(R.id.txtPass);
        etPassConfirm=(EditText)findViewById(R.id.txtPassConfirm);
        btnResign=(Button) findViewById(R.id.btnLogin2);
    }

    private void KTResign(String MaDG){
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest= new StringRequest(Request.Method.POST, urlResgn,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if(response.trim().equals("error")){
                            Intent intent = new Intent(ResignActivity1.this,ResignActivity2.class);
                            intent.putExtra("MaDG",MaDG);
                            intent.putExtra("pass",etPassResign.getText().toString().trim());
                            startActivity(intent);
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<>();
                params.put("MaCuaDG",MaDG);
                return params;
            }
        };
        requestQueue.add(stringRequest);
    }
}