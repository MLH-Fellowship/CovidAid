package com.bit_loons.covidaid.models;

import com.google.gson.annotations.SerializedName;

public class HelpRequest {
    @SerializedName("status")
    private String status;

    @SerializedName("help_seeker")
    private int help_seeker;

    @SerializedName("location")
    private String location;

    @SerializedName("subject")
    private String subject;

    @SerializedName("address")
    private String address;

    @SerializedName("description")
    private String description;

    @SerializedName("id")
    private int id;

    @SerializedName("contact_number")
    private String contact_number;

    @SerializedName("name")
    private String name;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getHelp_seeker() {
        return help_seeker;
    }

    public void setHelp_seeker(int help_seeker) {
        this.help_seeker = help_seeker;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContact_number() {
        return contact_number;
    }

    public void setContact_number(String contact_number) {
        this.contact_number = contact_number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
