package com.example.msrit.ratethefarm;

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
    int userID = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_push_data);

        mDatabase = FirebaseDatabase.getInstance().getReference();
        final EditText bName = findViewById(R.id.test_name);
        final EditText bVillage = findViewById(R.id.test_village);
        final EditText bCrop = findViewById(R.id.test_crop);
        final EditText bLand = findViewById(R.id.test_land);
        final EditText bAnimals = findViewById(R.id.test_animals);
        final EditText bRating = findViewById(R.id.test_rating);

        Button mPush = findViewById(R.id.push_data);

        mPush.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                UserData user = new UserData();
                user.Name = bName.getText().toString();
                user.Village = bVillage.getText().toString();
                user.Crop = bCrop.getText().toString();
                user.Land = bLand.getText().toString();
                user.Animals = bAnimals.getText().toString();
                user.Rating = bRating.getText().toString();

                mDatabase.child("Users").child("key_" + Integer.toString(userID++)).setValue(user);



            }
        });

    }
}
