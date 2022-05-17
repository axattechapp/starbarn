package com.axat.starbarn.model;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class ViewProfileModel {

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

    public ViewProfileModel withStatus(String status) {
        this.status = status;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ViewProfileModel withMessage(String message) {
        this.message = message;
        return this;
    }

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }

    public ViewProfileModel withData(List<Datum> data) {
        this.data = data;
        return this;
    }

    @Generated("jsonschema2pojo")
    public class Datum {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("email")
        @Expose
        private String email;
        @SerializedName("email_verified_at")
        @Expose
        private Object emailVerifiedAt;
        @SerializedName("password")
        @Expose
        private String password;
        @SerializedName("middle_name")
        @Expose
        private Object middleName;
        @SerializedName("last_name")
        @Expose
        private Object lastName;
        @SerializedName("phone")
        @Expose
        private String phone;
        @SerializedName("phone_verified_at")
        @Expose
        private Object phoneVerifiedAt;
        @SerializedName("bio")
        @Expose
        private Object bio;
        @SerializedName("gender")
        @Expose
        private Object gender;
        @SerializedName("birth_date")
        @Expose
        private Object birthDate;
        @SerializedName("remember_token")
        @Expose
        private Object rememberToken;
        @SerializedName("user_role")
        @Expose
        private Object userRole;
        @SerializedName("countrycode")
        @Expose
        private Object countrycode;
        @SerializedName("profile")
        @Expose
        private String profile;
        @SerializedName("category_id")
        @Expose
        private String categoryId;
        @SerializedName("user_status")
        @Expose
        private Integer userStatus;
        @SerializedName("last_login_at")
        @Expose
        private Object lastLoginAt;
        @SerializedName("created_at")
        @Expose
        private String createdAt;
        @SerializedName("updated_at")
        @Expose
        private String updatedAt;

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

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Datum withName(String name) {
            this.name = name;
            return this;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public Datum withEmail(String email) {
            this.email = email;
            return this;
        }

        public Object getEmailVerifiedAt() {
            return emailVerifiedAt;
        }

        public void setEmailVerifiedAt(Object emailVerifiedAt) {
            this.emailVerifiedAt = emailVerifiedAt;
        }

        public Datum withEmailVerifiedAt(Object emailVerifiedAt) {
            this.emailVerifiedAt = emailVerifiedAt;
            return this;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public Datum withPassword(String password) {
            this.password = password;
            return this;
        }

        public Object getMiddleName() {
            return middleName;
        }

        public void setMiddleName(Object middleName) {
            this.middleName = middleName;
        }

        public Datum withMiddleName(Object middleName) {
            this.middleName = middleName;
            return this;
        }

        public Object getLastName() {
            return lastName;
        }

        public void setLastName(Object lastName) {
            this.lastName = lastName;
        }

        public Datum withLastName(Object lastName) {
            this.lastName = lastName;
            return this;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public Datum withPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public Object getPhoneVerifiedAt() {
            return phoneVerifiedAt;
        }

        public void setPhoneVerifiedAt(Object phoneVerifiedAt) {
            this.phoneVerifiedAt = phoneVerifiedAt;
        }

        public Datum withPhoneVerifiedAt(Object phoneVerifiedAt) {
            this.phoneVerifiedAt = phoneVerifiedAt;
            return this;
        }

        public Object getBio() {
            return bio;
        }

        public void setBio(Object bio) {
            this.bio = bio;
        }

        public Datum withBio(Object bio) {
            this.bio = bio;
            return this;
        }

        public Object getGender() {
            return gender;
        }

        public void setGender(Object gender) {
            this.gender = gender;
        }

        public Datum withGender(Object gender) {
            this.gender = gender;
            return this;
        }

        public Object getBirthDate() {
            return birthDate;
        }

        public void setBirthDate(Object birthDate) {
            this.birthDate = birthDate;
        }

        public Datum withBirthDate(Object birthDate) {
            this.birthDate = birthDate;
            return this;
        }

        public Object getRememberToken() {
            return rememberToken;
        }

        public void setRememberToken(Object rememberToken) {
            this.rememberToken = rememberToken;
        }

        public Datum withRememberToken(Object rememberToken) {
            this.rememberToken = rememberToken;
            return this;
        }

        public Object getUserRole() {
            return userRole;
        }

        public void setUserRole(Object userRole) {
            this.userRole = userRole;
        }

        public Datum withUserRole(Object userRole) {
            this.userRole = userRole;
            return this;
        }

        public Object getCountrycode() {
            return countrycode;
        }

        public void setCountrycode(Object countrycode) {
            this.countrycode = countrycode;
        }

        public Datum withCountrycode(Object countrycode) {
            this.countrycode = countrycode;
            return this;
        }

        public String getProfile() {
            return profile;
        }

        public void setProfile(String profile) {
            this.profile = profile;
        }

        public Datum withProfile(String profile) {
            this.profile = profile;
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

        public Integer getUserStatus() {
            return userStatus;
        }

        public void setUserStatus(Integer userStatus) {
            this.userStatus = userStatus;
        }

        public Datum withUserStatus(Integer userStatus) {
            this.userStatus = userStatus;
            return this;
        }

        public Object getLastLoginAt() {
            return lastLoginAt;
        }

        public void setLastLoginAt(Object lastLoginAt) {
            this.lastLoginAt = lastLoginAt;
        }

        public Datum withLastLoginAt(Object lastLoginAt) {
            this.lastLoginAt = lastLoginAt;
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

        public String getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }

        public Datum withUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

    }
}