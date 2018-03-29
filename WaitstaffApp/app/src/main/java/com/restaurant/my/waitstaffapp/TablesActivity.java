package com.restaurant.my.waitstaffapp;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

public class TablesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tables);

        //LOG OUT BUTTON
        Button log_out_button = (Button) findViewById(R.id.logout_button);
        log_out_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                staff_sign_out();
            }
        });

        //INITIATE SWITCHES
        Switch tab1_order_switch = (Switch) findViewById(R.id.tab1_order);
        Switch tab2_order_switch = (Switch) findViewById(R.id.tab2_order);
        Switch tab3_order_switch = (Switch) findViewById(R.id.tab3_order);
        Switch tab4_order_switch = (Switch) findViewById(R.id.tab4_order);

        Switch tab1_refill_switch = (Switch) findViewById(R.id.tab1_refill);
        Switch tab2_refill_switch = (Switch) findViewById(R.id.tab2_refill);
        Switch tab3_refill_switch = (Switch) findViewById(R.id.tab3_refill);
        Switch tab4_refill_switch = (Switch) findViewById(R.id.tab4_refill);

        tab1_order_switch.setChecked(false);
        tab2_order_switch.setChecked(false);
        tab3_order_switch.setChecked(false);
        tab4_order_switch.setChecked(false);

        tab1_refill_switch.setChecked(false);
        tab2_refill_switch.setChecked(false);
        tab3_refill_switch.setChecked(false);
        tab4_refill_switch.setChecked(false);
    }

    protected void onResume(){
        super.onResume();


    }

    public void staff_sign_out() {
        Intent signOut_intent = new Intent(this, MainActivity.class);
        startActivity(signOut_intent);
    }
}
