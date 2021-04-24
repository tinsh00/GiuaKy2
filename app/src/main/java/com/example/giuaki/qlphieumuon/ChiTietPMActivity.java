package com.example.giuaki.qlphieumuon;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.giuaki.R;
import com.example.giuaki.qlsach.Sach;
import com.example.giuaki.qlsach.SachAdapter;

import java.util.ArrayList;

public class ChiTietPMActivity extends AppCompatActivity {
    TextView tVHoVaTen_DGMS;
    ImageView imgAvt_DG_MuonSach;
    Button btnBack_chitiet;
    ListView lViewDSSach_damuon;
    Dialog dialog;

    ArrayList<Sach> arr_sach_damuon = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_p_m);

        setControl();
        Init();
        setEvent();
    }

    void setControl(){
        imgAvt_DG_MuonSach = (ImageView)findViewById(R.id.imgAvt_DG_MuonSach);

        tVHoVaTen_DGMS = (TextView)findViewById(R.id.tVHoVaTen_DGMS);

        btnBack_chitiet = (Button)findViewById(R.id.btnBack_chitiet);

        lViewDSSach_damuon = (ListView)findViewById(R.id.lVDSSach_damuon);
    }

    void setEvent(){
        btnBack_chitiet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(ChiTietPMActivity.this, PhieuMuonsachActivity.class);
                startActivity(intent1);
            }
        });

        lViewDSSach_damuon.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                showDialog(arr_sach_damuon.get(position));
            }
        });
    }

    void Init(){
        Intent intent = getIntent();

//        System.out.println(intent.getIntExtra("IdDG", 0));

        imgAvt_DG_MuonSach.setImageResource(intent.getIntExtra("IdDG", 0));
        tVHoVaTen_DGMS.setText(intent.getStringExtra("HoVaTen"));

        setArr();

        SachAdapter adapter = new SachAdapter(arr_sach_damuon);
        lViewDSSach_damuon.setAdapter(adapter);
    }

    public void showDialog(Sach item){
        dialog = new Dialog(ChiTietPMActivity.this);
//        dialog.setTitle("You win!!!");
        dialog.setContentView(R.layout.dialog_sach);
//        ((ImageView)dialog.findViewById(R.id.img_sach)).setImageResource(item.getMasach());
        ((TextView)dialog.findViewById(R.id.tV_NameSach_1)).setText(item.getName());
        ((TextView)dialog.findViewById(R.id.tV_noidung_sach)).setText(item.getNoidung());
        ((Button)dialog.findViewById(R.id.btnOK_sach)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
            }
        });
        dialog.show();
    }

    void setArr(){
        arr_sach_damuon.add(new Sach("sach1",10000, "R.drawable.conan97", 10, "sach1"));
        arr_sach_damuon.add(new Sach("sach2",20000, "R.drawable.conan97", 9,"sach2"));
        arr_sach_damuon.add(new Sach("sach3",50000, "R.drawable.conan97", 22,"sach3"));
    }
}