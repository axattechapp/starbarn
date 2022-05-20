package com.axat.starbarn.model;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class GetSavedVideos {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private List<Datum> data = null;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public GetSavedVideos withStatus(String status) {
        this.status = status;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public GetSavedVideos withMessage(String message) {
        this.message = message;
        return this;
    }

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }

    public GetSavedVideos withData(List<Datum> data) {
        this.data = data;
        return this;
    }
    @Generated("jsonschema2pojo")
    public class Datum {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("fk_user_id")
        @Expose
        private Integer fkUserId;
        @SerializedName("fk_post_id")
        @Expose
        private Integer fkPostId;
        @SerializedName("created_at")
        @Expose
        private String createdAt;
        @SerializedName("update_at")
        @Expose
        private Object updateAt;
        @SerializedName("deleted_at")
        @Expose
        private Object deletedAt;
        @SerializedName("post_id")
        @Expose
        private Integer postId;
        @SerializedName("posted_by_user_id")
        @Expose
        private Integer postedByUserId;
        @SerializedName("challenged_post_id")
        @Expose
        private Object challengedPostId;
        @SerializedName("title")
        @Expose
        private String title;
        @SerializedName("thumbnail")
        @Expose
        private String thumbnail;
        @SerializedName("media_type")
        @Expose
        private String mediaType;
        @SerializedName("media_url")
        @Expose
        private String mediaUrl;
        @SerializedName("description")
        @Expose
        private String description;
        @SerializedName("category_id")
        @Expose
        private String categoryId;
        @SerializedName("tag")
        @Expose
        private String tag;
        @SerializedName("slug")
        @Expose
        private String slug;
        @SerializedName("caption")
        @Expose
        private String caption;
        @SerializedName("status")
        @Expose
        private Integer status;
        @SerializedName("start_challenge_at")
        @Expose
        private Object startChallengeAt;
        @SerializedName("end_challenge_at")
        @Expose
        private Object endChallengeAt;
        @SerializedName("updated_at")
        @Expose
        private Object updatedAt;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Datum withId(Integer id) {
            this.id = id;
            return this;
        }

        public Integer getFkUserId() {
            return fkUserId;
        }

        public void setFkUserId(Integer fkUserId) {
            this.fkUserId = fkUserId;
        }

        public Datum withFkUserId(Integer fkUserId) {
            this.fkUserId = fkUserId;
            return this;
        }

        public Integer getFkPostId() {
            return fkPostId;
        }

        public void setFkPostId(Integer fkPostId) {
            this.fkPostId = fkPostId;
        }

        public Datum withFkPostId(Integer fkPostId) {
            this.fkPostId = fkPostId;
            return this;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public Datum withCreatedAt(String createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public Object getUpdateAt() {
            return updateAt;
        }

        public void setUpdateAt(Object updateAt) {
            this.updateAt = updateAt;
        }

        public Datum withUpdateAt(Object updateAt) {
            this.updateAt = updateAt;
            return this;
        }

        public Object getDeletedAt() {
            return deletedAt;
        }

        public void setDeletedAt(Object deletedAt) {
            this.deletedAt = deletedAt;
        }

        public Datum withDeletedAt(Object deletedAt) {
            this.deletedAt = deletedAt;
            return this;
        }

        public Integer getPostId() {
            return postId;
        }

        public void setPostId(Integer postId) {
            this.postId = postId;
        }

        public Datum withPostId(Integer postId) {
            this.postId = postId;
            return this;
        }

        public Integer getPostedByUserId() {
            return postedByUserId;
        }

        public void setPostedByUserId(Integer postedByUserId) {
            this.postedByUserId = postedByUserId;
        }

        public Datum withPostedByUserId(Integer postedByUserId) {
            this.postedByUserId = postedByUserId;
            return this;
        }

        public Object getChallengedPostId() {
            return challengedPostId;
        }

        public void setChallengedPostId(Object challengedPostId) {
            this.challengedPostId = challengedPostId;
        }

        public Datum withChallengedPostId(Object challengedPostId) {
            this.challengedPostId = challengedPostId;
            return this;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public Datum withTitle(String title) {
            this.title = title;
            return this;
        }

        public String getThumbnail() {
            return thumbnail;
        }

        public void setThumbnail(String thumbnail) {
            this.thumbnail = thumbnail;
        }

        public Datum withThumbnail(String thumbnail) {
            this.thumbnail = thumbnail;
            return this;
        }

        public String getMediaType() {
            return mediaType;
        }

        public void setMediaType(String mediaType) {
            this.mediaType = mediaType;
        }

        public Datum withMediaType(String mediaType) {
            this.mediaType = mediaType;
            return this;
        }

        public String getMediaUrl() {
            return mediaUrl;
        }

        public void setMediaUrl(String mediaUrl) {
            this.mediaUrl = mediaUrl;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public Datum withDescription(String description) {
            this.description = description;
            return this;
        }

        public String getCategoryId() {
            return categoryId;
        }

        public void setCategoryId(String categoryId) {
            this.categoryId = categoryId;
        }

        public Datum withCategoryId(String categoryId) {
            this.categoryId = categoryId;
            return this;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public Datum withTag(String tag) {
            this.tag = tag;
            return this;
        }

        public String getSlug() {
            return slug;
        }

        public void setSlug(String slug) {
            this.slug = slug;
        }

        public Datum withSlug(String slug) {
            this.slug = slug;
            return this;
        }

        public String getCaption() {
            return caption;
        }

        public void setCaption(String caption) {
            this.caption = caption;
        }

        public Datum withCaption(String caption) {
            this.caption = caption;
            return this;
        }

        public Integer getStatus() {
            return status;
        }

        public void setStatus(Integer status) {
            this.status = status;
        }

        public Datum withStatus(Integer status) {
            this.status = status;
            return this;
        }

        public Object getStartChallengeAt() {
            return startChallengeAt;
        }

        public void setStartChallengeAt(Object startChallengeAt) {
            this.startChallengeAt = startChallengeAt;
        }

        public Datum withStartChallengeAt(Object startChallengeAt) {
            this.startChallengeAt = startChallengeAt;
            return this;
        }

        public Object getEndChallengeAt() {
            return endChallengeAt;
        }

        public void setEndChallengeAt(Object endChallengeAt) {
            this.endChallengeAt = endChallengeAt;
        }

        public Datum withEndChallengeAt(Object endChallengeAt) {
            this.endChallengeAt = endChallengeAt;
            return this;
        }

        public Object getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(Object updatedAt) {
            this.updatedAt = updatedAt;
        }

        public Datum withUpdatedAt(Object updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

    }
}