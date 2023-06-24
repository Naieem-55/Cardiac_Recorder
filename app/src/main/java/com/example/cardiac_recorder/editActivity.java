package com.example.cardiac_recorder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class editActivity extends AppCompatActivity {

    private int serialNo =MyAdapter.itemPosition;
    private EditText dMeasured , tMeasured , sPressure , dPressure , htRate ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        final EditText dateMeasured = findViewById(R.id.editTextTextPersonName2);
        final EditText timeMeasured = findViewById(R.id.editTextTextPersonName3);
        final EditText systolicPressure = findViewById(R.id.editTextTextPersonName4);
        final EditText diastolicPressure = findViewById(R.id.editTextTextPersonName5);
        final EditText heartRate = findViewById(R.id.editTextTextPersonName6);

        final EditText comment = findViewById(R.id.editTextTextPersonName7);
        final Button editBtn = findViewById(R.id.button);




        final String phoneNumber = Login.phoneNo;  // Phone No taken from Login page
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();

        editBtn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        final String dateMeasuredText = dateMeasured.getText().toString();
                        final String timeMeasuredText = timeMeasured.getText().toString();
                        final String systolicPressureText = systolicPressure.getText().toString();
                        final String diastolicPressureText = diastolicPressure.getText().toString();
                        final String heartRateText = heartRate.getText().toString();
                        final String comment2 = comment.getText().toString();

                        serialNo++;

                        if(dateMeasuredText.isEmpty() || timeMeasuredText.isEmpty() || systolicPressureText.isEmpty() || diastolicPressureText.isEmpty() || heartRateText.isEmpty()){

                        }else{
                            databaseReference.child("users").child(phoneNumber).addListenerForSingleValueEvent(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot snapshot) {
                                    databaseReference.child("users").child(phoneNumber).child(String.valueOf(serialNo)).child("Date").setValue(dateMeasuredText);
                                    databaseReference.child("users").child(phoneNumber).child(String.valueOf(serialNo)).child("Time").setValue(timeMeasuredText);
                                    databaseReference.child("users").child(phoneNumber).child(String.valueOf(serialNo)).child("Systolic").setValue(systolicPressureText);
                                    databaseReference.child("users").child(phoneNumber).child(String.valueOf(serialNo)).child("Diastolic").setValue(diastolicPressureText);
                                    databaseReference.child("users").child(phoneNumber).child(String.valueOf(serialNo)).child("HeartRate").setValue(heartRateText);
                                    databaseReference.child("users").child(phoneNumber).child(String.valueOf(serialNo)).child("Comment").setValue(comment2);

                                    Toast.makeText(editActivity.this, "Updated new record successfully", Toast.LENGTH_SHORT).show();
                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError error) {

                                }
                            });
                        }
                    }

                }
        );

    }
}