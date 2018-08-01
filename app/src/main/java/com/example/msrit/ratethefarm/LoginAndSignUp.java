package com.example.msrit.ratethefarm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginAndSignUp extends AppCompatActivity {

    // Remove when project is done
    private Button mPage1, mPage2, mPage3, mPage4, mPage5;

    @Override    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_and_sign_up);

        mPage1 = findViewById(R.id.page_1);
        mPage2 = findViewById(R.id.page_2);
        mPage3 = findViewById(R.id.page_3);
        mPage4 = findViewById(R.id.page_4);
        mPage5 = findViewById(R.id.page_5);

        mPage1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent myIntent = new Intent(v.getContext(), LoginAndSignUp.class);
                startActivity(myIntent);
            }
        });

        mPage2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), GetFarmerDetails.class);
                startActivity(myIntent);
            }
        });

        mPage3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent myIntent = new Intent(v.getContext(), FarmersList.class);
                startActivity(myIntent);
            }
        });

        mPage4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), ShowFarmerDetails.class);
                startActivity(myIntent);
            }
        });

        mPage5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), TestPushData.class);
                startActivity(myIntent);
            }
        });

    }
}
