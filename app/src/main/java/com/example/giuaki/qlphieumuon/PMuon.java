package com.example.giuaki.qlphieumuon;

public class PMuon {
    String Id;
    String IdDG;
    String IdTT;
    String date;
    String ghi_chu;

    public PMuon(String id, String idDG, String idTT, String date, String ghi_chu) {
        Id = id;
        IdDG = idDG;
        IdTT = idTT;
        this.date = date;
        this.ghi_chu = ghi_chu;
    }

    @Override
    public String toString() {
        return "PMuon{" +
                "Id=" + Id +
                ", IdDG=" + IdDG +
                ", IdTT=" + IdTT +
                ", date='" + date + '\'' +
                ", ghi_chu='" + ghi_chu + '\'' +
                '}';
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getIdDG() {
        return IdDG;
    }

    public void setIdDG(String idDG) {
        IdDG = idDG;
    }

    public String getIdTT() {
        return IdTT;
    }

    public void setIdTT(String idTT) {
        IdTT = idTT;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getGhi_chu() {
        return ghi_chu;
    }

    public void setGhi_chu(String ghi_chu) {
        this.ghi_chu = ghi_chu;
    }
}
