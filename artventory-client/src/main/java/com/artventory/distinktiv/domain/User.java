package com.artventory.distinktiv.domain;

import java.util.Date;

/**
 * Created by distinktiv on 2017-02-07.
 */
public class User{

    private Long id;

    private String email;

    private String firstName;

    private String lastName;

    private String password;

    private boolean isAdmin;

    private Profile profile;

    private int failedLoginCount;

    private Date lastFailedLoginDate;

    private boolean accountLocked;


    public User(){}

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public User(String email, String password, boolean isAdmin, Profile profile) {
        this.email = email;
        this.password = password;
        this.isAdmin = isAdmin;
        this.profile = profile;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
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

    public String getPassword() {
        return password;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public Profile getProfile() {
        return profile;
    }

    public int getFailedLoginCount() {
        return failedLoginCount;
    }

    public void setFailedLoginCount(int failedLoginCount) {
        this.failedLoginCount = failedLoginCount;
    }

    public Date getLastFailedLoginDate() {
        return lastFailedLoginDate;
    }

    public void setLastFailedLoginDate(Date lastFailedLoginDate) {
        this.lastFailedLoginDate = lastFailedLoginDate;
    }

    public boolean isAccountLocked() {
        return accountLocked;
    }

    public void setAccountLocked(boolean accountLocked) {
        this.accountLocked = accountLocked;
    }
}
