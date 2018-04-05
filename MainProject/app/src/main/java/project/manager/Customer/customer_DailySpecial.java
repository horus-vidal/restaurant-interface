package project.manager.Customer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import project.manager.R;

public class customer_DailySpecial extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent startIntent = new Intent(getApplicationContext(), customer_DailySpecial.class);


        super.onCreate(savedInstanceState);
        setContentView(R.layout.customer_activity_daily_special);
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat( "EEEEEE");
        String time =  format. format(calendar.getTime());
        TextView textView = findViewById(R.id.text_view_date1);
        textView.setText(time);
        switch (time)
        {
            case "Mon":

                startIntent = new Intent(getApplicationContext(), customer_DS_Monday.class);
                int MondayImage = R.drawable.ic_launcher_background;
                String MondayOrder =  "Tuesday Daily Special";
                String MondayPrice = "$19.99";
                startActivity(startIntent);
                break;

            case "Tue":
                startIntent = new Intent(getApplicationContext(), customer_DS_Tuesday.class);
                int TuesdayImage = R.drawable.ic_launcher_background;
                String TuesdayOrder =  "Tuesday Daily Special";
                String TuesdayPrice = "$19.99";
                startActivity(startIntent);
                break;

            case "WED":
                startIntent = new Intent(getApplicationContext(), customer_DS_Wednesday.class);
                int WednesdayImage = R.drawable.ic_launcher_background;
                String WednesdayOrder =  "Tuesday Daily Special";
                String WednesdayPrice = "$19.99";
                startActivity(startIntent);
                break;

            case "Thu":
                startIntent = new Intent(getApplicationContext(), customer_DS_Thursday.class);
                int ThursdayImage = R.drawable.ic_launcher_background;
                String ThursdayOrder =  "Tuesday Daily Special";
                String ThursdayPrice = "$19.99";
                startActivity(startIntent);
                break;

            case "Fri":
                startIntent = new Intent (getApplicationContext(), customer_DS_Friday.class);
                startActivity (startIntent);
                break;



                default:
                break;

        }
}

    }



