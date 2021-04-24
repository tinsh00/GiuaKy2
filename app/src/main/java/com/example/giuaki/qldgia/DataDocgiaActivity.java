package com.example.giuaki.qldgia;

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
import com.example.giuaki.qlsach.SachActivity;
import com.example.giuaki.qltthu.ThuthuActivity;

import java.util.ArrayList;

public class DataDocgiaActivity extends AppCompatActivity {

    TextView tVAvt, tVIdDG, tVNameDG, tVTTDG;
    //    Spinner spinner_quick_menu;
    Button btnBack_DGia;
    ListView lViewDSDGia;
    Dialog dialog_dgia;

    ArrayList<DGia> arr_docgia = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_docgia);

        setControl();
        Init();
        setEvent();
    }
    void setControl(){
        tVAvt = (TextView)findViewById(R.id.tVAvt);
        tVIdDG = (TextView)findViewById(R.id.tVIdDG);
        tVTTDG = (TextView)findViewById(R.id.tVTTDG);
        tVNameDG = (TextView)findViewById(R.id.tVNameDG);

//        spinner_quick_menu = (Spinner)findViewById(R.id.spinner_quick_menu);

        btnBack_DGia = (Button)findViewById(R.id.btnBacK_DGia);

        lViewDSDGia = (ListView)findViewById(R.id.listVDSDGia);
    }
    void setEvent(){
        btnBack_DGia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(DataDocgiaActivity.this, ThuthuActivity.class);
                startActivity(intent1);
            }
        });

        lViewDSDGia.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                System.out.println(arr_docgia.get(position));
                showDialog(arr_docgia.get(position));
            }
        });
    }
    void Init(){
//        String menu[] = {"menu1", "menu2", "menu3"};
//        ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, menu);
//        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
//        spinner_quick_menu.setAdapter(adapter);

        setArr();

        DGiaAdapter adapter = new DGiaAdapter(arr_docgia);
        lViewDSDGia.setAdapter(adapter);
    }

    public void showDialog(DGia item){
        Boolean check;
        dialog_dgia = new Dialog(DataDocgiaActivity.this);
//        dialog_dgia.setTitle("You win!!!");
        dialog_dgia.setContentView(R.layout.dialog_dgia);
//        ((ImageView)dialog_dgia.findViewById(R.id.img_dgia)).setImageResource(item.getIdDG());
        ((TextView)dialog_dgia.findViewById(R.id.tVHoVaTen)).setText(item.getHo()+" "+item.getTen());
        ((TextView)dialog_dgia.findViewById(R.id.tV_id)).setText(String.valueOf(item.getIdDG()));
        ((TextView)dialog_dgia.findViewById(R.id.tV_namsinh)).setText(item.getNamSinh());
        ((TextView)dialog_dgia.findViewById(R.id.tV_phai)).setText(item.getPhai());
        ((TextView)dialog_dgia.findViewById(R.id.tV_diachi)).setText(item.getDiaChi());
        ((Button)dialog_dgia.findViewById(R.id.btnOK_DGia)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog_dgia.cancel();
            }
        });
        ((Button)dialog_dgia.findViewById(R.id.btnMuon_DGia)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(DataDocgiaActivity.this, SachActivity.class);
                //intent1.putExtra("check",true);
                startActivity(intent1);
            }
        });
        dialog_dgia.show();
    }

    void setArr(){
        arr_docgia.add(new DGia("R.drawable.conan97", "Nguyen", "Minh Thien", "1999", "Nam", "Long An", "KM"));
    }
}