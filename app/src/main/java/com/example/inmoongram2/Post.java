package com.example.inmoongram2;

import com.google.gson.annotations.SerializedName;

public class Post {

    @SerializedName("response")
    private String response;

    @SerializedName("post_num")
    private String post_num;

    @SerializedName("title")
    private String title;

    @SerializedName("content")
    private String content;

    @SerializedName("uri")
    private String uri;

    @SerializedName("lat")
    private String lat;

    @SerializedName("lng")
    private String lng;

    @SerializedName("likes")
    private String likes;

    @SerializedName("shared_date")
    private String sharedDate;

    public String getResponse() {
        return response;
    }

    public String getPost_num() {
        return post_num;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getUri() {
        return uri;
    }

    public String getLat() {
        return lat;
    }

    public String getLng() {
        return lng;
    }

    public String getLikes() {
        return likes;
    }

    public String getSharedDate() {
        return sharedDate;
    }
}
