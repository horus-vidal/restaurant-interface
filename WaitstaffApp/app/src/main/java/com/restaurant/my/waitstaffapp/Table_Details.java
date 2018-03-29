package com.restaurant.my.waitstaffapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Table_Details extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table__details);

        Button back_button = (Button) findViewById(R.id.table_back_button);
        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                go_back();
            }
        });
    }
    public void go_back() {
        Intent back_intent = new Intent(this, TablesActivity.class);
        startActivity(back_intent);
    }


}
