package com.example.cardiac_recorder;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    //private int serialNo = Login.serialNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText dateMeasured = findViewById(R.id.editTextTextPersonName2);
        final EditText timeMeasured = findViewById(R.id.editTextTextPersonName3);
        final EditText systolicPressure = findViewById(R.id.editTextTextPersonName4);
        final EditText diastolicPressure = findViewById(R.id.editTextTextPersonName5);
        final EditText heartRate = findViewById(R.id.editTextTextPersonName6);

        final EditText comment = findViewById(R.id.editTextTextPersonName7);

        final Button addButton = findViewById(R.id.btnAdd);
        final Button backButton = findViewById(R.id.btnBack);


        dateMeasured.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String input = editable.toString();
                if (!input.isEmpty()) {
                    boolean isValidDate = validateDate(input);
                    if (!isValidDate) {
                        dateMeasured.setError("Invalid date format (dd-mm-yyyy)");
                    } else {
                        dateMeasured.setError(null); // Clear any previous error
                    }
                }
            }

            private boolean validateDate(String input) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
                dateFormat.setLenient(false); // Disable lenient mode for strict date parsing

                try {
                    dateFormat.parse(input);
                    return true; // Date is valid
                } catch (ParseException e) {
                    return false; // Date is invalid
                }
            }

        });

        timeMeasured.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String input = editable.toString();
                if (!input.isEmpty()) {
                    boolean isValidTime = validateTime(input);
                    if (!isValidTime) {
                        timeMeasured.setError("Invalid time format (hh:mm)");
                    } else {
                        timeMeasured.setError(null); // Clear any previous error
                    }
                }
            }

            private boolean validateTime(String input) {
                SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm", Locale.US);
                timeFormat.setLenient(false); // Disable lenient mode for strict time parsing

                try {
                    timeFormat.parse(input);
                    return true; // Time is valid
                } catch (ParseException e) {
                    return false; // Time is invalid
                }
            }

        });



        systolicPressure.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String input = editable.toString();
                if (!input.isEmpty()) {
                    boolean isValidNumber = validateNonNegativeInteger(input);
                    if (!isValidNumber) {
                        systolicPressure.setError("Invalid value (non-negative integer required)");
                    } else {
                        systolicPressure.setError(null); // Clear any previous error
                    }
                }
            }

            private boolean validateNonNegativeInteger(String input) {
                try {
                    int value = Integer.parseInt(input);
                    return value >= 0; // Check if the value is non-negative
                } catch (NumberFormatException e) {
                    return false; // Invalid number format
                }
            }

        });


        diastolicPressure.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String input = editable.toString();
                if (!input.isEmpty()) {
                    boolean isValidNumber = validateNonNegativeInteger(input);
                    if (!isValidNumber) {
                        systolicPressure.setError("Invalid value (non-negative integer required)");
                    } else {
                        systolicPressure.setError(null); // Clear any previous error
                    }
                }
            }

            private boolean validateNonNegativeInteger(String input) {
                try {
                    int value = Integer.parseInt(input);
                    return value >= 0; // Check if the value is non-negative
                } catch (NumberFormatException e) {
                    return false; // Invalid number format
                }
            }
        });


        heartRate.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String input = editable.toString();
                if (!input.isEmpty()) {
                    boolean isValidNumber = validateNonNegativeInteger(input);
                    if (!isValidNumber) {
                        systolicPressure.setError("Invalid value (non-negative integer required)");
                    } else {
                        systolicPressure.setError(null); // Clear any previous error
                    }
                }
            }

            private boolean validateNonNegativeInteger(String input) {
                try {
                    int value = Integer.parseInt(input);
                    return value >= 0; // Check if the value is non-negative
                } catch (NumberFormatException e) {
                    return false; // Invalid number format
                }
            }
        });


        comment.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String input = editable.toString();
                if (!input.isEmpty()) {
                    boolean isValidString = validateString(input);
                    if (!isValidString) {
                        comment.setError("Invalid string length (0-20 characters)");
                    } else {
                        comment.setError(null); // Clear any previous error
                    }
                }
            }

            private boolean validateString(String input) {
                int length = input.length();
                return length >= 0 && length <= 20; // Check if the string length is within the specified range
            }

        });


        final String phoneNumber = Login.phoneNo;  // Phone No taken from Login page

        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("users");

        addButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        final String dateMeasuredText = dateMeasured.getText().toString();
                        final String timeMeasuredText = timeMeasured.getText().toString();
                        final String systolicPressureText = systolicPressure.getText().toString();
                        final String diastolicPressureText = diastolicPressure.getText().toString();
                        final String heartRateText = heartRate.getText().toString();
                        final String comment2 = comment.getText().toString();

                        Login.serialNo++;

                        if(dateMeasuredText.isEmpty() || timeMeasuredText.isEmpty() || systolicPressureText.isEmpty() || diastolicPressureText.isEmpty() || heartRateText.isEmpty()){
                            Toast.makeText(MainActivity.this, "Please Fill all the Data", Toast.LENGTH_SHORT).show();
                        }else{
                            databaseReference.child(phoneNumber).addListenerForSingleValueEvent(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot snapshot) {
                                    databaseReference.child(phoneNumber).child(String.valueOf(Login.serialNo)).child("Date").setValue(dateMeasuredText);
                                    databaseReference.child(phoneNumber).child(String.valueOf(Login.serialNo)).child("Time").setValue(timeMeasuredText);
                                    databaseReference.child(phoneNumber).child(String.valueOf(Login.serialNo)).child("Systolic").setValue(systolicPressureText);
                                    databaseReference.child(phoneNumber).child(String.valueOf(Login.serialNo)).child("Diastolic").setValue(diastolicPressureText);
                                    databaseReference.child(phoneNumber).child(String.valueOf(Login.serialNo)).child("HeartRate").setValue(heartRateText);
                                    databaseReference.child(phoneNumber).child(String.valueOf(Login.serialNo)).child("Comment").setValue(comment2);

                                    Toast.makeText(MainActivity.this, "Added new record successfully", Toast.LENGTH_SHORT).show();
                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError error) {

                                }
                            });
                        }
                    }

                }
        );

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, controll.class);
                startActivity(intent);
            }
        });

    }


}