package com.bit_loons.covidaid.models;

import com.google.gson.annotations.SerializedName;

public class LeaderBoard {
    @SerializedName("email")
    private String email;

    @SerializedName("id")
    private String id;

    @SerializedName("contact_number")
    private String contact_number;

    @SerializedName("last_name")
    private String last_name;

    @SerializedName("points")
    private String points;

    @SerializedName("first_name")
    private String first_name;

    public String getPoints() {
        return points;
    }

    public String getName() {
        return first_name + " " + last_name;
    }
}
