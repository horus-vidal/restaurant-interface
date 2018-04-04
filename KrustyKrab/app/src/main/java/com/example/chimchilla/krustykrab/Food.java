package com.example.chimchilla.krustykrab;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Food extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);
        ImageButton EntreeBtn = (ImageButton) findViewById(R.id.FoodBtn);
        EntreeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startIntent = new Intent(getApplicationContext(), Entrees.class);
                startActivity(startIntent);
            }
        });

        ImageButton DrinkBtn = (ImageButton) findViewById(R.id.GamesBtn);
        DrinkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startIntent = new Intent(getApplicationContext(), drink.class);
                startActivity(startIntent);
            }

        });

        ImageButton DessertBtn = (ImageButton) findViewById(R.id.MusicBtn);
        DessertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startIntent = new Intent(getApplicationContext(), Dessert.class);
                startActivity(startIntent);
            }
        });
        ImageButton AppBtn = (ImageButton) findViewById(R.id.DSBtn);
        AppBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startIntent = new Intent(getApplicationContext(), Apps.class);
                startActivity(startIntent);
            }
        });

        Button BackBtn = (Button) findViewById(R.id.BackBtn);
        BackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startIntent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(startIntent);
            }
        });

        Button VOBtn = (Button) findViewById(R.id.VOBtn);
        VOBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startIntent = new Intent(getApplicationContext(), cart.class);
                startActivity(startIntent);
            }
        });


    }
}