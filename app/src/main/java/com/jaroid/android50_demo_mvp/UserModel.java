package com.jaroid.android50_demo_mvp;

public class UserModel {
    private String userName;
    private String password;

    public UserModel(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public UserModel() {
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

    @Override
    public String toString() {
        return "UserModel{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
