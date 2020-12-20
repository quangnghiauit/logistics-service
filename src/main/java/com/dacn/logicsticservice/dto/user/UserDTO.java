package com.dacn.logicsticservice.dto.user;

import com.dacn.logicsticservice.model.Users;

public class UserDTO {

    private int id;
    private String userName;
    private String email;
    private int userType;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void doMappingEntity(Users user) {
        this.id = user.getId();
        this.userName = user.getUserName();
        this.email = user.getEmail();
        this.userType = user.getUserType();
    }
}
