package com.restaurant.my.waitstaffapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button sign_in_button = (Button) findViewById(R.id.log_in_button);
        sign_in_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                staff_sign_in();
            }
        });
    }
    public void staff_sign_in() {
        Intent signIn_intent = new Intent(this, TablesActivity.class);
        startActivity(signIn_intent);
    }
}
