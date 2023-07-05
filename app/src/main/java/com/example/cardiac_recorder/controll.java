package com.example.cardiac_recorder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class controll extends AppCompatActivity {

    Button buttonShowData, buttonAddData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_controll);

        buttonShowData = findViewById(R.id.buttonShowData);
        buttonAddData = findViewById(R.id.buttonAddData);
        /**
         * This button is for Showing saved Data
         */
        buttonAddData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(controll.this, userList.class);
                startActivity(intent);
            }
        });
        /**
         * this button is for Adding Data
         */
        buttonShowData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(controll.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}