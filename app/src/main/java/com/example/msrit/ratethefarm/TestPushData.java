package com.example.msrit.ratethefarm;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class TestPushData extends AppCompatActivity {

    DatabaseReference mDatabase;
    int UserID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_push_data);

        mDatabase = FirebaseDatabase.getInstance().getReference();
        final EditText bName = findViewById(R.id.test_name);
        final EditText bAge = findViewById(R.id.test_age);
        final EditText bVillage = findViewById(R.id.test_village);
        final EditText bCrop = findViewById(R.id.test_crop);
        final EditText bLand = findViewById(R.id.test_land);
        final EditText bAnimals = findViewById(R.id.test_animals);
        final EditText bRating = findViewById(R.id.test_rating);

        Button mPush = findViewById(R.id.push_data);

        mDatabase.child("Current Users").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                UserID = dataSnapshot.getValue(Integer.class);
                UserID++;
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        mPush.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                UserData user = new UserData();
                user.setName(bName.getText().toString());
                user.setAge(bAge.getText().toString());
                user.setVillage(bVillage.getText().toString());
                user.setCrop(bCrop.getText().toString());
                user.setLand(bLand.getText().toString());
                user.setAnimals(bAnimals.getText().toString());
                user.setRating(bRating.getText().toString());
                user.setUserID(UserID);

                mDatabase.child("Users").child(Integer.toString(UserID)).setValue(user);
                mDatabase.child("Current Users").setValue(UserID);

            }
        });

    }
}