package com.example.room_demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    UserDetailsDao userDetailsDao;
    DataBase dataBase;
    List<MyDetails> myDetailsList;
    ArrayList<MyDetails> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        dataBase = Room.databaseBuilder(this,DataBase.class,"UserDataBase").allowMainThreadQueries().build();
        userDetailsDao = dataBase.userDetailsDao();

        myDetailsList = userDetailsDao.fetchAllData();
        if (myDetailsList.size() > 0){
            for (int i = 0; i < myDetailsList.size(); i++){
                Log.e("myDetai", String.valueOf(myDetailsList.get(i).getId()));
                Log.e("myDetai", String.valueOf(myDetailsList.get(i).getUserName()));
                Log.e("myDetai", String.valueOf(myDetailsList.get(i).getAddress()));
            }
            list.addAll(myDetailsList);

        }else {
            Toast.makeText(this,"no data found",Toast.LENGTH_SHORT).show();
        }
    }
}