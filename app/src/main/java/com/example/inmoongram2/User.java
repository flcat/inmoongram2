package com.example.inmoongram2;

import com.google.gson.annotations.SerializedName;

public class User {
//Model Class
    @SerializedName("response")
    private String Response;

    @SerializedName("user_id")
    private String userId;

    @SerializedName("name")
    private String userName;

    public String getResponse() {
        return Response;
    }

    public String getuserName() {
        return userName;
    }

    public String getUserId() {
        return userId;
    }
}
