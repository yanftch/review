package com.yanftch.review.javabasic.auto_phone;

public class UserContact {
    private String name;
    private String phone;

    public UserContact(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public UserContact() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "auto_phone.UserContact{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}