package com.example.room_demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText userName,address;
    Button btnAddUser;
    DataBase dataBase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userName =findViewById(R.id.edt_user_name);
        address = findViewById(R.id.edt_address);
        btnAddUser = findViewById(R.id.btn_add_user);


        dataBase = Room.databaseBuilder(this,DataBase.class,"UserDataBase").allowMainThreadQueries().build();

        btnAddUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (userName.getText().equals("") && address.getText().equals(""))
                {
                    Toast.makeText(MainActivity.this,"data bhrdo sir or mam",Toast.LENGTH_SHORT).show();
                }else {
                    UserDetailsDao userDetailsDao = dataBase.userDetailsDao();
                    MyDetails myDetails = new MyDetails();
                    myDetails.setUserName(userName.getText().toString());
                    myDetails.setAddress(address.getText().toString());

                    //save data
                    userDetailsDao.insertUser(myDetails);
                    Toast.makeText(MainActivity.this,"bhgvan bhlaa kree aapka",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(MainActivity.this,HomeActivity.class));
                }
            }
        });
    }
}