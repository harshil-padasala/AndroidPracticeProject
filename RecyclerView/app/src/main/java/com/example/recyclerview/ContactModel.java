package com.example.recyclerview;

public class ContactModel {
    String contactName;
    String contactNumber;
    int img;

    public ContactModel(int img, String contactName, String contactNumber) {
        this.contactName = contactName;
        this.contactNumber = contactNumber;
        this.img = img;
    }

    public ContactModel(String contactName, String contactNumber) {
        this.contactName = contactName;
        this.contactNumber = contactNumber;
    }
}
