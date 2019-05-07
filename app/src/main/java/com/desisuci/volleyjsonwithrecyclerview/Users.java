package com.desisuci.volleyjsonwithrecyclerview;

public class Users {
    private String id;
    private String nama;
    private String username;
    private String email;
    private String address;


    public Users(String id, String nama, String username, String email, String address) {
        this.id = id;
        this.nama = nama;
        this.username = username;
        this.email = email;
        this.address = address;

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

    public String getUserName(){return username;}

    public void setUserName(String username){this.username = username;}

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

}
