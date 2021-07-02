package com.example.room_demo;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDetailsDao {

    @Insert
    void insertUser(MyDetails myDetails);

    @Query("SELECT * from UserDetails")
    List<MyDetails> fetchAllData();


}
