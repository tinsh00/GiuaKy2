package com.example.giuaki.qlphieumuon;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.giuaki.R;
import com.example.giuaki.qldgia.DGia;

import java.util.ArrayList;
import java.util.Objects;

public class PhieuAdapter extends BaseAdapter {
    ArrayList<PMuon> arr_phieumuon;
    ArrayList<DGia> arr_dgia;
    Objects present;

    PhieuAdapter(ArrayList<PMuon> arr_phieumuon){
        this.arr_dgia = arr_dgia;
        this.arr_phieumuon = arr_phieumuon;
    }
    
    @Override
    public int getCount() {
        return arr_phieumuon.size();
    }

    @Override
    public Object getItem(int position) {
        return arr_phieumuon.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View viewPMuon;
        if(convertView == null){
            viewPMuon = View.inflate(parent.getContext(), R.layout.layout_pmuon, null);
        }else{
            viewPMuon = convertView;
        }
        PMuon item = (PMuon)getItem(position);
        ((TextView) viewPMuon.findViewById(R.id.tV_id_phieu)).setText(String.valueOf(item.getId()));
        ((TextView) viewPMuon.findViewById(R.id.tV_id_dg_muon)).setText(String.valueOf(item.getIdDG()));
        ((TextView) viewPMuon.findViewById(R.id.tV_id_tt_qli)).setText(String.valueOf(item.getIdTT()));
        ((TextView) viewPMuon.findViewById(R.id.tV_ngay_muon)).setText(item.getDate());
        ((TextView) viewPMuon.findViewById(R.id.tV_ghi_chu)).setText(item.getGhi_chu());

        return viewPMuon;
    }
}
