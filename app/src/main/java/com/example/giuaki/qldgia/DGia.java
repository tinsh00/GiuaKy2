package com.example.giuaki.qldgia;

public class DGia {
    String IdDG;
    String Ho;
    String Ten;
    String NamSinh;
    String Phai;
    String DiaChi;
    String ttrang;

    public DGia(String idDG, String ho, String ten, String namSinh, String phai, String diaChi, String ttrang) {
        IdDG = idDG;
        Ho = ho;
        Ten = ten;
        NamSinh = namSinh;
        Phai = phai;
        DiaChi = diaChi;
        this.ttrang = ttrang;
    }

    @Override
    public String toString() {
        return "DGia{" +
                "IdDG=" + IdDG +
                ", Ho='" + Ho + '\'' +
                ", Ten='" + Ten + '\'' +
                ", NamSinh='" + NamSinh + '\'' +
                ", Phai='" + Phai + '\'' +
                ", DiaChi='" + DiaChi + '\'' +
                ", ttrang='" + ttrang + '\'' +
                '}';
    }

    public String getIdDG() {
        return IdDG;
    }

    public void setIdDG(String idDG) {
        IdDG = idDG;
    }

    public String getHo() {
        return Ho;
    }

    public void setHo(String ho) {
        Ho = ho;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String ten) {
        Ten = ten;
    }

    public String getNamSinh() {
        return NamSinh;
    }

    public void setNamSinh(String namSinh) {
        NamSinh = namSinh;
    }

    public String getPhai() {
        return Phai;
    }

    public void setPhai(String phai) {
        Phai = phai;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String diaChi) {
        DiaChi = diaChi;
    }

    public String getTtrang() {
        return ttrang;
    }

    public void setTtrang(String ttrang) {
        this.ttrang = ttrang;
    }
}
