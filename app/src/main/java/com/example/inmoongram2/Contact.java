package com.example.inmoongram2;

import com.google.gson.annotations.SerializedName;

public class Contact {

    @SerializedName("username")
    private String userName;

    @SerializedName("contents")
    private String Contents;

    @SerializedName("mUri")
    private String mUri;

    public String getmUri() {
        return mUri;
    }

    public String getUserName() {
        return userName;
    }

    public String getContents() {
        return Contents;
    }
}
