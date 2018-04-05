//package project.manager;
//
//import android.content.Context;
//import android.content.Intent;
//import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
//import android.widget.TextView;
//
//import java.text.SimpleDateFormat;
//import java.util.Calendar;
//
//public class customer_DailySpecial extends AppCompatActivity {
//
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        Intent startIntent = new Intent(getApplicationContext(), customer_DailySpecial.class);
//
//
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.customer_activity_daily_special);
//        Calendar calendar = Calendar.getInstance();
//        SimpleDateFormat format = new SimpleDateFormat( "EEEEEE");
//        String time =  format. format(calendar.getTime());
//        TextView textView = findViewById(R.id.text_view_date1);
//        textView.setText(time);
//        Intent intent = new Intent(customer_DailySpecial.this, customer_Selection.class);
//
//        switch (time)
//        {
//            case "Mon":
//                int MondayImage = R.drawable.ic_launcher_background;
//                String MondayOrder =  "Monday Daily Special";
//                String MondayPrice = "$19.99";
//                intent.putExtra("itemName", MondayOrder);
//                intent.putExtra("itemPrice", MondayPrice);
//                startActivity(intent);
//                break;
//
//            case "Tue":
//                int TuesdayImage = R.drawable.ic_launcher_background;
//                String TuesdayOrder =  "Tuesday Daily Special";
//                String TuesdayPrice = "$19.99";
//                intent.putExtra("itemName", TuesdayOrder);
//                intent.putExtra("itemPrice", TuesdayPrice);
//                startActivity(intent);
//                break;
//            case "WED":
//                int WednesdayImage = R.drawable.ic_launcher_background;
//                String WednesdayOrder =  "Tuesday Daily Special";
//                String WednesdayPrice = "$19.99";
//                intent.putExtra("itemName", WednesdayOrder);
//                intent.putExtra("itemPrice", WednesdayPrice);
//                startActivity(intent);
//                break;
//            case "Thu":
//                int ThursdayImage = R.drawable.ic_launcher_background;
//                String ThursdayOrder =  "Thursday Daily Special";
//                String ThursdayPrice = "$19.99";
//                intent.putExtra("itemName", ThursdayOrder);
//                intent.putExtra("itemPrice", ThursdayPrice);
//                startActivity(intent);
//                break;
//
//            case "Fri":
//                int FridayImage = R.drawable.ic_launcher_background;
//                String FridayOrder =  "Tuesday Daily Special";
//                String FridayPrice = "$19.99";
//                intent.putExtra("itemName", FridayOrder);
//                intent.putExtra("itemPrice", FridayPrice);
//                startActivity(intent);
//                break;
//
//                default:
//                break;
//
//        }
//}
//
//    }
//
//
//
