package com.example.giuaki.qltthu;

public class TThu {
    String Id;
    String name;
    String sdt;
    String pass;
    String avt;

    public TThu(String id, String name, String sdt, String pass, String avt) {
        Id = id;
        this.name = name;
        this.sdt = sdt;
        this.pass = pass;
        this.avt = avt;
    }

    @Override
    public String toString() {
        return "TThu{" +
                "Id='" + Id + '\'' +
                ", name='" + name + '\'' +
                ", sdt='" + sdt + '\'' +
                ", pass='" + pass + '\'' +
                ", avt='" + avt + '\'' +
                '}';
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getAvt() {
        return avt;
    }

    public void setAvt(String avt) {
        this.avt = avt;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }
}
