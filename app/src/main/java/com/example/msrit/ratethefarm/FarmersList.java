package com.example.msrit.ratethefarm;

import android.app.LauncherActivity.ListItem;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class FarmersList extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private List<UserData> mListItems;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farmers_list);

        mDatabase = FirebaseDatabase.getInstance().getReference().child("Users");

        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));



         mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                mListItems = new ArrayList<>();
                UserData CurrentUser= dataSnapshot.getValue(UserData.class);
                mListItems.add(CurrentUser);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        mAdapter = new MyAdapter(mListItems,this);
        mRecyclerView.setAdapter(mAdapter);



    }
}


/*
Data attributes to be included:
user id : int
Farmer's name
age
gender
Father's/husband's name

 */

