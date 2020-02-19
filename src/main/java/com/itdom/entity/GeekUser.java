package com.itdom.entity;


public class GeekUser {

private String username;

private String age;

    public GeekUser() {
    }

    public GeekUser(String username, String age) {
        this.username = username;
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
