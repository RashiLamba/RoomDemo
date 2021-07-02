package com.example.room_demo;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "UserDetails")
public class MyDetails {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String userName;
    private String address;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
