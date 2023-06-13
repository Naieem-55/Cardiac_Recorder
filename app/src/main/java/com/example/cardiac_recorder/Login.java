package com.example.cardiac_recorder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Login extends AppCompatActivity {

    DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReference();
    public static String phoneNo;
    public static int serialNo = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText phone=findViewById(R.id.phone);
        final EditText password=findViewById(R.id.password);
        final Button loginButton=findViewById(R.id.login_button);
        final TextView registerButton=findViewById(R.id.register_now_button);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String phoneText=phone.getText().toString();
                final String passwordText=password.getText().toString();
                phoneNo=phoneText;

                if(phoneText.isEmpty() || passwordText.isEmpty()){
                    Toast.makeText(Login.this, "Please Enter your mobile and password.", Toast.LENGTH_SHORT).show();
                }else{
                    databaseReference.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if(snapshot.hasChild(phoneText)){
                                final String getPassword=snapshot.child(phoneText).child("password").getValue(String.class);

                                if(getPassword.equals(passwordText)){
                                    Toast.makeText(Login.this,"Login Successful.",Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(Login.this,controll.class));
                                    finish();
                                }else{
                                    Toast.makeText(Login.this, "Wrong password!.", Toast.LENGTH_SHORT).show();
                                }
                            }else{
                                Toast.makeText(Login.this, "Incorrect phone number !.", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                }
            }
        });

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //open register activity
                startActivity(new Intent(Login.this,Register.class));

            }
        });

    }
}


