package com.new_folder.kitchen_interface;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.DrawableRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("Orders");

        // Dummy orders, grab from database
        final Queue<Order> orders = new LinkedList<Order>();
        orders.add(new Order(0)); // Queue of 5 orders
        orders.add(new Order(0));
        orders.add(new Order(3));
        orders.add(new Order(0));
        orders.add(new Order(0));
        orders.add(new Order(0));

        GridLayout layout = findViewById(R.id.ordersLayout);


        int size = orders.size(), ord_num = 1;
        // Create an button with the order text
        //for (int i = 0; i < size; i++)
        while (orders.peek() != null)
        {
            final Order order = orders.poll();
            final Button button = new Button(this);
            boolean alive = true;

            // Set initial image for button
            switch(order.getStatus()){
                case 0: button.setBackgroundResource(R.drawable.red); break;
                case 1: button.setBackgroundResource(R.drawable.yellow); break;
                case 2: button.setBackgroundResource(R.drawable.green); break;
                case 3: alive = false; break;
                default: button.setBackgroundResource(R.drawable.blank);
            }

            if (alive) {
                // Retrieve and format text for button
                button.setGravity(Gravity.RIGHT);
                String text = order.getAgeString();
                button.setText(text);

                button.setGravity(Gravity.LEFT);
                button.setTextSize(10);
                button.setPadding(8, 0, 0, 0);
                text = "#" + (ord_num++)
                        + "                                 " + order.getAgeString() + "\n"
                        + order.getOrderString();
                button.setText(text);

                // Change color based on status after a press
                button.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        if (order.getStatus() == 0)
                            button.setBackgroundResource(R.drawable.yellow);
                        else if (order.getStatus() == 1)
                            button.setBackgroundResource(R.drawable.green);

                        order.upStatus();
                    }
                });

                layout.addView(button);
            }
        }


        // Post refresh every minute
        /*Handler handle = new Handler();
        Timer clock  = new Timer();
        clock.schedule(new TimerTask(){
            @Override
            public void run() {
                handle.post(new Runnable() {
                    @Override
                    public void run() {

                    }
                });
            }
        }, 60 * 100, 60 * 100);*/

        final Handler handle = new Handler();
        handle.postDelayed( new Runnable() {
            @Override
            public void run() {
                recreate();
            }
        }, 60 * 1000 );

    }
}


class Order{
    private ArrayList<String> items;
    private ArrayList<String> notes;
    private LocalTime birth;
    private LocalTime age;
    private int status;

    @TargetApi(Build.VERSION_CODES.O)
    public Order(int s){
        items = new ArrayList<String>(0);
        items.add("Item #1");
        items.add("Item #2");
        items.add("Item #3");
        items.add("Item #4");
        notes = new ArrayList<String>(0);
        notes.add("");
        notes.add("No gross");
        notes.add("");
        notes.add("No yummy");

        birth = LocalTime.MIN;
        age   = ((LocalTime.now()).minusHours(birth.getHour())).minusMinutes(birth.getMinute());

        status = s;
    }

    public ArrayList<String> getItems(){
        return items;
    }

    public ArrayList<String> getNotes(){
        return notes;
    }

    @TargetApi(Build.VERSION_CODES.O)
    public LocalTime getAge(){
        age   = ((LocalTime.now()).minusHours(birth.getHour())).minusMinutes(birth.getMinute());
        return age;
    }

    public int getStatus(){
        return status;
    }

    @TargetApi(Build.VERSION_CODES.O)
    public String getAgeString(){
        DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm");
        String text = age.format(format) + "\n";
        return text;
    }

    public String getOrderString(){

        int num_items = items.size();
        String text = "";


        for (int j = 0; j < num_items; j++){
            text += items.get(j) + "\n";
            if (notes.get(j) != "")
                text += " - " + notes.get(j) + "\n";
        }

        return text;
    }

    public void upStatus(){
        if (status < 2)
            status++;
    }
}