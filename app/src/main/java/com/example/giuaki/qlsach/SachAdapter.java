package com.example.giuaki.qlsach;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.giuaki.R;
import com.example.giuaki.login.LoginActivity2;

import java.util.ArrayList;

public class SachAdapter extends BaseAdapter {
    ArrayList<Sach> arr_sach;

    public SachAdapter(ArrayList<Sach> arr_sach){
        this.arr_sach = arr_sach;
    }

    @Override
    public int getCount() {
        return arr_sach.size();
    }

    @Override
    public Object getItem(int position) {
        return arr_sach.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View viewSach;
        if(convertView == null){
            viewSach = View.inflate(parent.getContext(), R.layout.layout_sach, null);
        }else{
            viewSach = convertView;
        }
        Sach item = (Sach)getItem(position);
//        ((ImageView) viewSach.findViewById(R.id.img_avt_sach)).setImageResource(item.getMasach());
        ((TextView) viewSach.findViewById(R.id.tV_NameSach)).setText(item.getName());
        ((TextView) viewSach.findViewById(R.id.tV_GiaSach)).setText(String.valueOf(item.getGia()));
        ((TextView) viewSach.findViewById(R.id.tV_SoLuongSach)).setText(String.valueOf(item.getSoluong()));
        viewSach.findViewById(R.id.btn_MuonSach).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        return viewSach;
    }
}
