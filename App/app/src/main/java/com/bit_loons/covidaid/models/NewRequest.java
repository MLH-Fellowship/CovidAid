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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact_number() {
        return contact_number;
    }

    public void setContact_number(String contact_number) {
        this.contact_number = contact_number;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
