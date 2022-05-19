package com.axat.starbarn.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class DashboardResponse {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("challenge_remain")
    @Expose
    private int challenge_remain;
    @SerializedName("videos")
    @Expose
    private int videos;
    @SerializedName("following_count")
    @Expose
    private int following_count;
    @SerializedName("follwer_count")
    @Expose
    private int follwer_count;
    @SerializedName("liked")
    @Expose
    private int liked;

    public DashboardResponse(String status, String message, int challenge_remain, int videos, int following_count, int follwer_count, int liked) {
        this.status = status;
        this.message = message;
        this.challenge_remain = challenge_remain;
        this.videos = videos;
        this.following_count = following_count;
        this.follwer_count = follwer_count;
        this.liked = liked;
    }

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public int getChallenge_remain() {
        return challenge_remain;
    }

    public int getVideos() {
        return videos;
    }

    public int getFollowing_count() {
        return following_count;
    }

    public int getFollwer_count() {
        return follwer_count;
    }

    public int getLiked() {
        return liked;
    }
}


