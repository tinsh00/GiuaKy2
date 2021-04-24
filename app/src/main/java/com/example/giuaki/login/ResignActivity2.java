package com.example.giuaki.login;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
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

import java.util.HashMap;
import java.util.Map;

public class ResignActivity2 extends AppCompatActivity {
    EditText etHo, etTen, etDiaChi;
    //RadioGroup radioGroup;
    RadioButton rbNam, rbNu;
    Button btnConfirm;
    String MaDG, Pass;
    String urlThemTK = "";
    String GT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resign2);
        Intent intent = getIntent();
        MaDG = intent.getStringExtra("MaDG");
        Pass = intent.getStringExtra("pass");
        AnhXa();
        Xuli();
    }


    private void Xuli() {


        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rbNam.isChecked()) {
                    GT = rbNam.getText().toString();
                } else GT = rbNu.getText().toString();
                String ho = etHo.getText().toString().trim();
                String ten = etTen.getText().toString().trim();
                String DC=etDiaChi.getText().toString().trim();

                if(ho.isEmpty()||ten.isEmpty()||DC.isEmpty()){
                    Toast.makeText(ResignActivity2.this, "Hãy nhập đủ thông tin !!", Toast.LENGTH_SHORT).show();
                }
                ThemTK(urlThemTK);
            }
        });

    }

    private void AnhXa() {
        etDiaChi = (EditText) findViewById(R.id.etDiaChi);
        etTen = (EditText) findViewById(R.id.etTen);
        etHo = (EditText) findViewById(R.id.etHo);
        //RadioGroup=(RadioGroup)findViewById(R.id.)
        rbNam = (RadioButton) findViewById(R.id.rbNam);
        rbNu = (RadioButton) findViewById(R.id.rbNu);
        btnConfirm = (Button) findViewById(R.id.btnConfirm);
    }

    private void ThemTK(String urlThemTK) {

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, urlThemTK,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(ResignActivity2.this, "Thêm tài khoản thành công", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(ResignActivity2.this, ActivityHomePage.class));
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }) {
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("MacuaDG", MaDG);
                params.put("hoDG", etHo.getText().toString().trim());
                params.put("tenDG", etTen.getText().toString().trim());
                params.put("PhaiDG", GT);
                params.put("DiaChiDG", etDiaChi.getText().toString().trim());
                params.put("PassDG", Pass);
                return params;
            }

            ;

        };

        requestQueue.add(stringRequest);
    }
}