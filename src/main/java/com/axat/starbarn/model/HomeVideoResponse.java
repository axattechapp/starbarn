package com.axat.starbarn.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class HomeVideoResponse {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    public List<Datum> data = null;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public HomeVideoResponse withStatus(String status) {
        this.status = status;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HomeVideoResponse withMessage(String message) {
        this.message = message;
        return this;
    }

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }

    public HomeVideoResponse withData(List<Datum> data) {
        this.data = data;
        return this;
    }
    public class Datum {

        @SerializedName("title")
        @Expose
        private String title;
        @SerializedName("post_id")
        @Expose
        private Integer post_id;
        @SerializedName("media_url")
        @Expose
        private String media_url;
        @SerializedName("description")
        @Expose
        private String description;

        public Datum(String title, Integer post_id, String media_url, String description) {
            this.title = title;
            this.post_id = post_id;
            this.media_url = media_url;
            this.description = description;
        }

        public String getTitle() {
            return title;
        }

        public Integer getPost_id() {
            return post_id;
        }

        public String getMedia_url() {
            return media_url;
        }

        public String getDescription() {
            return description;
        }
    }
}


