package com.gan.wcarewebservice.model;

import java.util.Date;

public class WcBusinessManager {

    private int id;

    private int wcUserId;

    private String firstName;

    private String lastName;

    private Date startDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWcUserId() {
        return wcUserId;
    }

    public void setWcUserId(int wcUserId) {
        this.wcUserId = wcUserId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

}