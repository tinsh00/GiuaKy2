package com.example.giuaki.qltthu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.giuaki.R;
import com.example.giuaki.qldgia.DataDocgiaActivity;
import com.example.giuaki.qlphieumuon.PhieuMuonsachActivity;
import com.example.giuaki.qlsach.SachActivity;

public class ThuthuActivity extends AppCompatActivity {

    ImageView img_avt_tt;
    TextView tV_MaTT, tVNameTT, tVSdtTT, tV1, tV2, tV3;
    Button btnDSSach, btnDSDGia, btnDSPhieu, btnBack, btnLogOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thuthu);

        setControl();
        setInit();
        setEvent();
    }
    void setControl(){
        img_avt_tt = (ImageView)findViewById(R.id.img_avt_tt);

        tV1 = (TextView)findViewById(R.id.textView1);
        tV2 = (TextView)findViewById(R.id.textView3);
        tV3 = (TextView)findViewById(R.id.textView33);
        tV_MaTT = (TextView)findViewById(R.id.tV_MaTT);
        tVNameTT = (TextView)findViewById(R.id.tV_NameTT);
        tVSdtTT = (TextView)findViewById(R.id.tV_SdtTT);

        btnDSSach = (Button)findViewById(R.id.btnDSSach);
        btnDSDGia = (Button)findViewById(R.id.btnDSDGia);
        btnDSPhieu = (Button)findViewById(R.id.btnDSPhieu);
        btnBack = (Button)findViewById(R.id.btnBack);
        btnLogOut = (Button)findViewById(R.id.btnLogOut);
    }
    void setEvent(){
        btnDSSach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(ThuthuActivity.this, SachActivity.class);
                startActivity(intent1);
            }
        });

        btnDSDGia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(ThuthuActivity.this, DataDocgiaActivity.class);
                startActivity(intent1);
            }
        });

        btnDSPhieu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(ThuthuActivity.this, PhieuMuonsachActivity.class);
                startActivity(intent1);
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent1 = new Intent(ThuthuActivity.this, PhieuMuonsachActivity.class);
//                startActivity(intent1);
            }
        });

        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    void setInit(){
        Intent intent = getIntent();
//        tV_MaTT.setText(intent.getStringExtra("MATT"));
//        tVNameTT.setText(intent.getStringExtra("NameTT"));
//        tVSdtTT.setText(intent.getStringExtra("SDT_TT"));
//        img_avt_tt.setImageResource(intent.getIntExtra("Id_img", R.drawable.ic_launcher_background));
    }
}