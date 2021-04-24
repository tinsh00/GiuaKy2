package com.example.giuaki.qlsach;

public class Sach {
    String name;
    long gia;
    String masach;
    int soluong;
    String noidung;

    @Override
    public String toString() {
        return "Sach{" +
                "name='" + name + '\'' +
                ", gia=" + gia +
                ", masach=" + masach +
                ", soluong=" + soluong +
                ", noidung='" + noidung + '\'' +
                '}';
    }

    public Sach(String name, long gia, String masach, int soluong, String noidung) {
        this.name = name;
        this.gia = gia;
        this.masach = masach;
        this.soluong = soluong;
        this.noidung = noidung;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getGia() {
        return gia;
    }

    public void setGia(long gia) {
        this.gia = gia;
    }

    public String getMasach() {
        return masach;
    }

    public void setMasach(String masach) {
        this.masach = masach;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public String getNoidung() {
        return noidung;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }
}
