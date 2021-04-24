package com.example.giuaki.qlsach;

import android.app.Activity;
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
import com.example.giuaki.qltthu.ThuthuActivity;

import java.util.ArrayList;

public class SachActivity extends AppCompatActivity {

    TextView tVBia, tVName, tVSl, tVGia;
//    Spinner spinner_quick_menu;
    Button btnBack_Sach, btnAdd_Sach, btnDel_Sach, btnEdit_Sach, btn_MuonSach, btn_addAnh;
    ListView lViewDSSach;
    Dialog dialog;
    Boolean check;

    ArrayList<Sach> arr_sach = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sach);

        setControl();
        Init();
        setEvent();
    }

    void setControl(){
        tVBia = (TextView)findViewById(R.id.tVBia);
        tVName = (TextView)findViewById(R.id.tVName);
        tVSl = (TextView)findViewById(R.id.tVSl);
        tVGia = (TextView)findViewById(R.id.tVGia);

//        spinner_quick_menu = (Spinner)findViewById(R.id.spinner_quick_menu);

        btnBack_Sach = (Button)findViewById(R.id.btnBacK_Sach);
        btnAdd_Sach = (Button)findViewById(R.id.btnAdd_Sach);
        btnDel_Sach = (Button)findViewById(R.id.btnDel_Sach);
        btnEdit_Sach = (Button)findViewById(R.id.btnEdit_Sach);
        btn_addAnh=(Button)findViewById(R.id.btn_AddImage);

        lViewDSSach = (ListView)findViewById(R.id.listVDSSach);
    }
    void setEvent(){
        btnBack_Sach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(SachActivity.this, ThuthuActivity.class);
                startActivity(intent1);
            }
        });

        lViewDSSach.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                showDialog(arr_sach.get(position));
            }
        });

        btnAdd_Sach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog = new Dialog(SachActivity.this);
                dialog.setContentView(R.layout.dialog_addsach);
                Button btnAddSach = (Button)dialog.findViewById(R.id.btnThemSachMoi);
                Button btnThoat = (Button)dialog.findViewById(R.id.btnThoatSachMoi);
                btnThoat.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.cancel();
                    }
                });
                dialog.show();
            }
        });

        btnEdit_Sach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog = new Dialog(SachActivity.this);
                dialog.setContentView(R.layout.dialog_suasach);
                Button btnEditSach = (Button)dialog.findViewById(R.id.btnCaphatsach);
                Button btnThoat = (Button)dialog.findViewById(R.id.btnThoatsuasach);
                btnThoat.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.cancel();
                    }
                });
                dialog.show();
            }
        });



    }
    void Init(){
//        String menu[] = {"menu1", "menu2", "menu3"};
//        ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, menu);
//        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
//        spinner_quick_menu.setAdapter(adapter);

        setArr();
        Intent intent = getIntent();
        check=intent.getBooleanExtra("check",false);
        if(check==true){
            btn_MuonSach.setEnabled(true);
        }
        SachAdapter adapter = new SachAdapter(arr_sach);
        lViewDSSach.setAdapter(adapter);
    }

    public void showDialog(Sach item){
        dialog = new Dialog(SachActivity.this);
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
        arr_sach.add(new Sach("sach1",10000, "R.drawable.conan97", 10, "sach1"));
        arr_sach.add(new Sach("sach2",20000, "R.drawable.conan97", 9,"sach2"));
        arr_sach.add(new Sach("sach3",50000, "R.drawable.conan97", 22,"sach3"));
        arr_sach.add(new Sach("sach4",12000, "R.drawable.conan97", 11,"sach4"));
        arr_sach.add(new Sach("sach5",45000, "R.drawable.conan97", 100,"sach5"));
        arr_sach.add(new Sach("sach6",25000, "R.drawable.conan97", 200,"sach6"));
        arr_sach.add(new Sach("sach7",15000, "R.drawable.conan97", 500,"sach7"));
        arr_sach.add(new Sach("sach8",35000, "R.drawable.conan97", 1000,"sach8"));
        arr_sach.add(new Sach("sach9",5000, "R.drawable.conan97", 300,"sach9"));
    }
}