package com.example.msrit.ratethefarm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class Register extends AppCompatActivity {
    EditText mText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mText = (EditText) findViewById(R.id.name);
        String name = mText.getText().toString();
    }
}
