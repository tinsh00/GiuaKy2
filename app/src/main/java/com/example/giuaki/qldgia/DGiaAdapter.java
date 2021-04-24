package com.example.giuaki.qldgia;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.giuaki.R;

import java.util.ArrayList;

public class DGiaAdapter extends BaseAdapter {
    ArrayList<DGia> arr_docgia;

    DGiaAdapter(ArrayList<DGia> arr_docgia){
        this.arr_docgia = arr_docgia;
    }

    @Override
    public int getCount() {
        return arr_docgia.size();
    }

    @Override
    public Object getItem(int position) {
        return arr_docgia.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View viewDGia;
        if(convertView == null){
            viewDGia = View.inflate(parent.getContext(), R.layout.layout_docgia, null);
        }else{
            viewDGia = convertView;
        }
        DGia item = (DGia)getItem(position);
//        ((ImageView) viewDGia.findViewById(R.id.img_avt_dgia)).setImageResource(item.getIdDG());
        ((TextView) viewDGia.findViewById(R.id.tV_name_docgia)).setText(item.getHo() + item.getTen());
        ((TextView) viewDGia.findViewById(R.id.tV_Id_docgia)).setText(String.valueOf(item.getIdDG()));
        ((TextView) viewDGia.findViewById(R.id.tV_tinh_trang)).setText(String.valueOf(item.getTtrang()));

        return viewDGia;
    }
}
