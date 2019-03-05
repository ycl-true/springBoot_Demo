package com.example.demo.entity;

import javax.validation.constraints.Min;

public class User {
    private String userName;

    @Min(value = 33, message = "错误，最少33")
    private Integer id;

    private String address;

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", id=" + id +
                ", address='" + address + '\'' +
                '}';
    }

    public User(String userName, Integer id, String address) {
        this.userName = userName;
        this.id = id;
        this.address = address;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
