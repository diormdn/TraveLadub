package com.example.dioramadhan.traveladub;

public class Pengguna {
    public Pengguna(String nama, String email, String username) {
        this.nama = nama;
        this.email = email;
        this.username = username;
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

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    String nama, email, username;

    public Pengguna()
    {

    }
}
