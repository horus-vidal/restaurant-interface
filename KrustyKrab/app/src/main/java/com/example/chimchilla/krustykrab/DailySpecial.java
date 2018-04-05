package com.example.chimchilla.krustykrab;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DailySpecial extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent startIntent = new Intent(getApplicationContext(), DailySpecial.class);


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_special);
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat( "EEEEEE");
        String time =  format. format(calendar.getTime());
        TextView textView = findViewById(R.id.text_view_date1);
        textView.setText(time);
        switch (time)
        {
            case "Mon":

                startIntent = new Intent(getApplicationContext(), DS_Monday.class);

                startActivity(startIntent);


                break;
            case "Tue":
                startIntent = new Intent(getApplicationContext(), DS_Tuesday.class);
                startActivity(startIntent);
                break;

            case "WED":
                System.out.println("ZZZZZZZZZZZZZZ");
                break;

            default:

                break;

        }
}

    }



