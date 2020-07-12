package com.gan.wcarewebservice.model;


public class WcUsers {

    private int id;

    private String userName;

    private String password;

    private String emailId;

    private String role;

    public WcUsers() {
    }

    public WcUsers(String userName, String password, String emailId, String role) {
        this.userName = userName;
        this.password = password;
        this.emailId = emailId;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

