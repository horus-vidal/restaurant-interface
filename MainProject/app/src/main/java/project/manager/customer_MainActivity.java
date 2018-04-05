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
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

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




                Calendar calendar = Calendar.getInstance();
                SimpleDateFormat format = new SimpleDateFormat( "EEEEEE");
                String time =  format. format(calendar.getTime());
                Intent intent = new Intent(customer_MainActivity.this, customer_Selection.class);

                switch (time)
                {
                    case "Mon":
                        int MondayImage = R.drawable.ic_launcher_background;
                        String MondayOrder =  "Monday Daily Special";
                        String MondayPrice = "$19.99";
                        intent.putExtra("itemName", MondayOrder);
                        intent.putExtra("itemPrice", MondayPrice);
                        startActivity(intent);
                        break;

                    case "Tue":
                        int TuesdayImage = R.drawable.ic_launcher_background;
                        String TuesdayOrder =  "Tuesday Daily Special";
                        String TuesdayPrice = "$19.99";
                        intent.putExtra("itemName", TuesdayOrder);
                        intent.putExtra("itemPrice", TuesdayPrice);
                        startActivity(intent);
                        break;
                    case "WED":
                        int WednesdayImage = R.drawable.ic_launcher_background;
                        String WednesdayOrder =  "Tuesday Daily Special";
                        String WednesdayPrice = "$19.99";
                        intent.putExtra("itemName", WednesdayOrder);
                        intent.putExtra("itemPrice", WednesdayPrice);
                        startActivity(intent);
                        break;
                    case "Thu":
                        int ThursdayImage = R.drawable.ic_launcher_background;
                        String ThursdayOrder =  "Thursday Daily Special";
                        String ThursdayPrice = "$19.99";
                        intent.putExtra("itemName", ThursdayOrder);
                        intent.putExtra("itemPrice", ThursdayPrice);

                        startActivity(intent);
                        break;

                    case "Fri":
                        int FridayImage = R.drawable.ic_launcher_background;
                        String FridayOrder =  "Tuesday Daily Special";
                        String FridayPrice = "$19.99";
                        intent.putExtra("itemName", FridayOrder);
                        intent.putExtra("itemPrice", FridayPrice);
                        startActivity(intent);
                        break;

                    default:
                        break;

                }
            }



        });


        Button CWBtn = (Button) findViewById(R.id.CWBtn);
        CWBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Your waiter has been notified!", Toast.LENGTH_LONG).show();


            }
        });
    }



}

