package com.bit_loons.covidaid.models;

import com.google.gson.annotations.SerializedName;

public class NewRequest {

    @SerializedName("name")
    private String name;

    @SerializedName("contact_number")
    private String contact_number;

    @SerializedName("location")
    private String location;

    @SerializedName("address")
    private String address;

    @SerializedName("subject")
    private String subject;

    @SerializedName("description")
    private String description;


    public void setName(String name) {
        this.name = name;
    }

    public void setContact_number(String contact_number) {
        this.contact_number = contact_number;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
