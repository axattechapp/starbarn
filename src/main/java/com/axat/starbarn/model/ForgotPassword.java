package com.axat.starbarn.model;

public class ForgotPassword {
    public boolean status;
    public String message;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getmessage() {
        return message;
    }

    public void setToken(String message) {
        this.message = message;
    }
}
