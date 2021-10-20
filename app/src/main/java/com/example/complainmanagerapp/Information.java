package com.example.complainmanagerapp;

public class Information {
    String name,number,address,complain;

    public Information(String name, String number, String address, String complain) {
        this.name = name;
        this.number = number;
        this.address = address;
        this.complain = complain;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getComplain() {
        return complain;
    }

    public void setComplain(String complain) {
        this.complain = complain;
    }

    //    String FullName = fullName.getText().toString();
//    String Phone = phone.getText().toString();
//    String Address = address.getText().toString();
//    String Complain = complain.getText().toString();
}
