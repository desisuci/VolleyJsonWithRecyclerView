package com.desisuci.volleyjsonwithrecyclerview;

public class Kontak {
    private String id;
    private String nama;
    private String email;
    private String address;
    private String noHp;


    public Kontak(String id, String nama, String email, String address, String noHp) {
        this.id = id;
        this.nama = nama;
        this.email = email;
        this.address = address;
        this.noHp = noHp;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail (String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress (String address) {
        this.address = address;
    }

    public String getNoHp() {
        return noHp;
    }

    public void setNoHp (String noHp) {
        this.noHp = noHp;
    }


}
