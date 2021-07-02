package com.example.room_demo;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {MyDetails.class},version = 1,exportSchema = false)
public abstract class DataBase extends RoomDatabase {

    public abstract UserDetailsDao userDetailsDao();
}
