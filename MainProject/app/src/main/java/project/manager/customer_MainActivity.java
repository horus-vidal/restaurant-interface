//package com.example.chimchilla.krustykrab;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
//import android.view.View;
//import android.widget.Button;
//import android.widget.ImageButton;
//
//public class customer_MainActivity extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.customer_activity_main);
//
//
//        ImageButton FoodBtn = (ImageButton) findViewById(R.id.FoodBtn);
//        FoodBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent startIntent = new Intent(getApplicationContext(), customer_Food.class);
//                startActivity(startIntent);
//            }
//        });
//
//
//        ImageButton MusicBtn = (ImageButton) findViewById(R.id.MusicBtn);
//        MusicBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent startIntent = new Intent(getApplicationContext(), customer_Music.class);
//                startActivity(startIntent);
//            }
//        });
//
//        Button BackBtn = (Button) findViewById(R.id.BackBtn);
//        BackBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent startIntent = new Intent(getApplicationContext(), customer_MainActivity.class);
//                startActivity(startIntent);
//            }
//        });
//
//        ImageButton GamesBtn = (ImageButton) findViewById(R.id.GamesBtn);
//        GamesBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent startIntent = new Intent(getApplicationContext(), customer_Games.class);
//                startActivity(startIntent);
//            }
//        });
//    }
//}


package project.manager;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class customer_MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customer_activity_main);


        ImageButton FoodBtn = (ImageButton) findViewById(R.id.FoodBtn);
        FoodBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startIntent = new Intent(getApplicationContext(), customer_Food.class);
                startActivity(startIntent);
            }
        });


        ImageButton MusicBtn = (ImageButton) findViewById(R.id.MusicBtn);
        MusicBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startIntent = new Intent(getApplicationContext(), customer_Music.class);
                startActivity(startIntent);
            }
        });

        Button BackBtn = (Button) findViewById(R.id.BackBtn);
        BackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startIntent = new Intent(getApplicationContext(), customer_MainActivity.class);
                startActivity(startIntent);
            }
        });


        ImageButton GamesBtn = (ImageButton) findViewById(R.id.GamesBtn);
        GamesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startIntent = new Intent(getApplicationContext(), customer_Games.class);
                startActivity(startIntent);
            }
        });

        ImageButton DSBtn = (ImageButton) findViewById(R.id.DSBtn);
        DSBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startIntent = new Intent(getApplicationContext(), customer_DailySpecial.class);

                startActivity(startIntent);


            }
        });
    }



}

