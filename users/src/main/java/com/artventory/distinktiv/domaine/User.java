package com.artventory.distinktiv.domaine;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by distinktiv on 2017-02-07.
 */
@Entity
public class User implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, columnDefinition = "boolean default 0")
    private boolean isAdmin;

    @OneToOne
    private Profile profile;

    @Column(columnDefinition = "SMALLINT default 0")
    private int failedLoginCount;

    @Column(columnDefinition = "TIMESTAMP default CURRENT_TIMESTAMP")
    private Date lastFailedLoginDate;

    @Column(columnDefinition = "boolean default 0")
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

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
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
