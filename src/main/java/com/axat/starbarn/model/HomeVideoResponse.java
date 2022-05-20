package com.axat.starbarn.model;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class HomeVideoResponse {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("meassage")
    @Expose
    private String meassage;
    @SerializedName("data")
    @Expose
    private List<Datum> data = null;

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

    public String getMeassage() {
        return meassage;
    }

    public void setMeassage(String meassage) {
        this.meassage = meassage;
    }

    public HomeVideoResponse withMeassage(String meassage) {
        this.meassage = meassage;
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
    @Generated("jsonschema2pojo")
    public class Datum {

        @SerializedName("post_id")
        @Expose
        private Integer postId;
        @SerializedName("posted_by_user_id")
        @Expose
        private Integer postedByUserId;
        @SerializedName("challenged_post_id")
        @Expose
        private Integer challengedPostId;
        @SerializedName("title")
        @Expose
        private String title;
        @SerializedName("thumbnail")
        @Expose
        private Object thumbnail;
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
        private Object tag;
        @SerializedName("slug")
        @Expose
        private Object slug;
        @SerializedName("caption")
        @Expose
        private Object caption;
        @SerializedName("status")
        @Expose
        private Integer status;
        @SerializedName("start_challenge_at")
        @Expose
        private Object startChallengeAt;
        @SerializedName("end_challenge_at")
        @Expose
        private Object endChallengeAt;
        @SerializedName("created_at")
        @Expose
        private String createdAt;
        @SerializedName("updated_at")
        @Expose
        private Object updatedAt;
        @SerializedName("deleted_at")
        @Expose
        private Object deletedAt;

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

        public Integer getChallengedPostId() {
            return challengedPostId;
        }

        public void setChallengedPostId(Integer challengedPostId) {
            this.challengedPostId = challengedPostId;
        }

        public Datum withChallengedPostId(Integer challengedPostId) {
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

        public Object getThumbnail() {
            return thumbnail;
        }

        public void setThumbnail(Object thumbnail) {
            this.thumbnail = thumbnail;
        }

        public Datum withThumbnail(Object thumbnail) {
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

        public Datum withMediaUrl(String mediaUrl) {
            this.mediaUrl = mediaUrl;
            return this;
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

        public Object getTag() {
            return tag;
        }

        public void setTag(Object tag) {
            this.tag = tag;
        }

        public Datum withTag(Object tag) {
            this.tag = tag;
            return this;
        }

        public Object getSlug() {
            return slug;
        }

        public void setSlug(Object slug) {
            this.slug = slug;
        }

        public Datum withSlug(Object slug) {
            this.slug = slug;
            return this;
        }

        public Object getCaption() {
            return caption;
        }

        public void setCaption(Object caption) {
            this.caption = caption;
        }

        public Datum withCaption(Object caption) {
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

    }
}