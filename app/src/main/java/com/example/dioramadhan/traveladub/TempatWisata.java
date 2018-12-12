package com.example.dioramadhan.traveladub;

public class TempatWisata {
    public String namaTempat;
    public String detail;
    public String jamBukaWeekdays;
    public String jamBukaWeekends;
    public String location;
    public String hargaWeekdays;
    public String hargaWeekdends;
    public String noTelp;
    public int[] urlGambar;
    public double lat;
    public double longt;

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLongt() {
        return longt;
    }

    public void setLongt(double longt) {
        this.longt = longt;
    }

    public String getNamaTempat() {
        return namaTempat;
    }

    public void setNamaTempat(String namaTempat) {
        this.namaTempat = namaTempat;
    }

    public int[] getUrlGambar() {
        return urlGambar;
    }

    public void setUrlGambar(int[] urlGambar) {
        this.urlGambar = urlGambar;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getJamBukaWeekdays() {
        return jamBukaWeekdays;
    }

    public void setJamBukaWeekdays(String jamBukaWeekdays) {
        this.jamBukaWeekdays = jamBukaWeekdays;
    }

    public String getJamBukaWeekends() {
        return jamBukaWeekends;
    }

    public void setJamBukaWeekends(String jamBukaWeekends) {
        this.jamBukaWeekends = jamBukaWeekends;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getHargaWeekdays() {
        return hargaWeekdays;
    }

    public void setHargaWeekdays(String hargaWeekdays) {
        this.hargaWeekdays = hargaWeekdays;
    }

    public String getHargaWeekdends() {
        return hargaWeekdends;
    }

    public void setHargaWeekdends(String hargaWeekdends) {
        this.hargaWeekdends = hargaWeekdends;
    }

    public String getNoTelp() {
        return noTelp;
    }

    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
    }
}
