package com.bit_loons.covidaid.models;

import com.google.gson.annotations.SerializedName;

public class LogInResponse {

    @SerializedName("msg")
    private String msg;

    @SerializedName("status")
    private String status;

    public boolean isLogedIn(){
        return status.equals("OK");
    }

    public String getMsg() {
        return msg;
    }

    public String getStatus() {
        return status;
    }
}
