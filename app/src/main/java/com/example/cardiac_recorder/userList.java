package com.example.cardiac_recorder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.WindowManager;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class userList extends AppCompatActivity {

    RecyclerView recyclerView;
    String phone = Login.phoneNo;
    DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReference().child("users").child(phone);
    MyAdapter myAdapter;
    ArrayList<User> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN , WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_user_list);

        recyclerView = findViewById(R.id.userlist);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<>();
        myAdapter = new MyAdapter(this, list);
        recyclerView.setAdapter(myAdapter);
        myAdapter.setOnItemClickListener(new MyAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("users")
                        .child(Login.phoneNo).child(myAdapter.getItemCount()+"");
                ref.removeValue();
//                MyAdapter.OnItemClickListener.super.onItemClick(position);
//                list.remove(position);
//                myAdapter.notifyItemRemoved(position);
                myAdapter.notifyDataSetChanged();
            }
        });

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for(DataSnapshot dataSnapshot : snapshot.getChildren()){
                    try{
                        User user = dataSnapshot.getValue(User.class);
                        list.add(user);
                    }
                    catch (Exception e){
                        e.printStackTrace();
                    }

                }

                myAdapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}