    package com.example.giuaki.qlphieumuon;

    import android.app.Dialog;
    import android.content.Intent;
    import android.os.Bundle;
    import android.view.View;
    import android.widget.AdapterView;
    import android.widget.Button;
    import android.widget.CheckBox;
    import android.widget.CompoundButton;
    import android.widget.EditText;
    import android.widget.ListView;

    import androidx.appcompat.app.AppCompatActivity;

    import com.example.giuaki.R;
    import com.example.giuaki.qltthu.TThu;
    import com.example.giuaki.qltthu.ThuthuActivity;
    import com.example.giuaki.qldgia.DGia;

    import java.util.ArrayList;

    public class PhieuMuonsachActivity extends AppCompatActivity {

        EditText eT_cantim;
        //    Spinner spinner_quick_menu;
        Button btnBack_Phieu, btnSearch_Phieu;
        ListView listVDSPMuon;
        Dialog dialog;
        CheckBox cb_loc_theo_gchu;

        ArrayList<PMuon> arr_phieumuon = new ArrayList<>();
        ArrayList<DGia> arr_dgia = new ArrayList<>();
        ArrayList<TThu> arr_tt = new ArrayList<>();

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_phieu_muonsach);

            setControl();
            Init();
            setEvent();
        }
        void setControl(){
            eT_cantim = (EditText) findViewById(R.id.eT_cantim);
            btnBack_Phieu = (Button)findViewById(R.id.btnBacK_Phieu);
            btnSearch_Phieu = (Button)findViewById(R.id.btnSearch_Phieu);

            listVDSPMuon = (ListView)findViewById(R.id.listVDSPMuon);

            cb_loc_theo_gchu = (CheckBox) findViewById(R.id.cb_loc_theo_gchu);
        }
        void setEvent(){
            btnBack_Phieu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent1 = new Intent(PhieuMuonsachActivity.this, ThuthuActivity.class);
                    startActivity(intent1);
                }
            });
            btnSearch_Phieu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
    //                System.out.println(eT_cantim.getText().toString());
    //                System.out.println(tim_item(eT_cantim.getText().toString()));
                    PhieuAdapter adapter = new PhieuAdapter(tim_item(eT_cantim.getText().toString()));
                    listVDSPMuon.setAdapter(adapter);
                }
            });

            cb_loc_theo_gchu.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(cb_loc_theo_gchu.isChecked()){
                        ArrayList<PMuon> arr = new ArrayList<>();
                        for(int i = 0; i< arr_phieumuon.size(); i++){
                            if(!arr_phieumuon.get(i).getGhi_chu().equals("TD")){
                                arr.add(arr_phieumuon.get(i));
                            }
                        }
                        PhieuAdapter adapter = new PhieuAdapter(arr);
                        listVDSPMuon.setAdapter(adapter);
                    }
                    else{
                        PhieuAdapter adapter = new PhieuAdapter(arr_phieumuon);
                        listVDSPMuon.setAdapter(adapter);
                    }
                }
            });

            listVDSPMuon.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent1 = new Intent(PhieuMuonsachActivity.this, ChiTietPMActivity.class);
                    for(int i = 0; i<arr_dgia.size();i++){
                        if(arr_dgia.get(i).getIdDG() == arr_phieumuon.get(position).getIdDG()){
    //                        System.out.println(arr_dgia.toString());
                            intent1.putExtra("IdDG", arr_dgia.get(i).getIdDG());
                            intent1.putExtra("HoVaTen", arr_dgia.get(i).getHo() + " " + arr_dgia.get(i).getTen());
                            intent1.putExtra("IdPhieu", arr_phieumuon.get(position).getId());
                            break;
                        }
                    }
                    startActivity(intent1);
                }
            });
        }
        void Init(){
            setArr();

            PhieuAdapter adapter = new PhieuAdapter(arr_phieumuon);
            listVDSPMuon.setAdapter(adapter);
        }
        void setArr(){
            arr_phieumuon.add(new PMuon("123", "123", "123", "2004", "TD"));
            arr_phieumuon.add(new PMuon("qwe", "222", "qwe", "1904", "TT"));
            arr_phieumuon.add(new PMuon("qwe", "222", "qwe", "1904", "CT"));
//
//            arr_tt.add(new TThu(123, "Bua", "0123456789"));

            arr_dgia.add(new DGia("222", "Nguyen", "Minh Thien", "1999", "Nam", "Long An", "KM"));
            arr_dgia.add(new DGia("qweqw", "Nguyen", "Minh Bua", "1999", "Nam", "Long An", "KM"));
        }

        ArrayList<PMuon> tim_item(String cantim){
            ArrayList<PMuon> arr_return = new ArrayList<>();
            for(int i = 0; i<arr_phieumuon.size(); i++){
                if(!arr_return.contains(arr_phieumuon.get(i))){
                    if(cantim.equals(String.valueOf(arr_phieumuon.get(i).getId()))){
                        arr_return.add(arr_phieumuon.get(i));
                    }
                    if(cantim.equals(String.valueOf(arr_phieumuon.get(i).getDate()))){
                        arr_return.add(arr_phieumuon.get(i));
                    }
                    for(int j = 0; j<arr_dgia.size(); j++){
                        if(arr_phieumuon.get(i).getIdDG() == arr_dgia.get(j).getIdDG()){
                            DGia temp = arr_dgia.get(j);
                            if(cantim.equals(temp.getIdDG()) ||
                                    cantim.equals(temp.getDiaChi())||
                                    cantim.equals(temp.getIdDG()) ||
                                    cantim.equals(temp.getHo()) ||
                                    cantim.equals(temp.getTen()) ||
                                    cantim.equals(temp.getNamSinh()) ||
                                    cantim.equals(temp.getPhai()) ||
                                    cantim.equals(temp.getTtrang())){
                                arr_return.add(arr_phieumuon.get(i));
                            }
                            break;
                        }
                    }

                    for(int j = 0; j< arr_tt.size(); j++){
                        if(arr_phieumuon.get(i).getIdTT().equals(arr_tt.get(j).getId())){
                            TThu temp1 = arr_tt.get(j);
                            if(cantim.equals(temp1.getId()) ||
                                    cantim.equals(temp1.getName())||
                                    cantim.equals(temp1.getSdt())){
                                arr_return.add(arr_phieumuon.get(i));
                            }
                        }
                        break;
                    }
                }
            }
            return arr_return;
        }
    }