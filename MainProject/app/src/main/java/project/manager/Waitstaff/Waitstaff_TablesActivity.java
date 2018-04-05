package project.manager.Waitstaff;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Switch;

import project.manager.R;

public class Waitstaff_TablesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tables);

        setTitle("[WAITER NAME]'s Tables");

        //LOG OUT BUTTON
        Button log_out_button = (Button) findViewById(R.id.logout_button);
        log_out_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                staff_sign_out();
            }
        });


        //RELATIVE LAYOUT CLICKABLE TABLES
        RelativeLayout rl_1 = (RelativeLayout)findViewById(R.id.ViewTable_1);
        rl_1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String tableName = "Table 1";
                open_tableLayout(tableName);
            }
        });

        RelativeLayout rl_2 = (RelativeLayout)findViewById(R.id.ViewTable_2);
        rl_2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String tableName = "Table 2";
                open_tableLayout(tableName);
            }
        });

        RelativeLayout rl_3 = (RelativeLayout)findViewById(R.id.ViewTable_3);
        rl_3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String tableName = "Table 3";
                open_tableLayout(tableName);
            }
        });

        RelativeLayout rl_4 = (RelativeLayout)findViewById(R.id.ViewTable_4);
        rl_4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String tableName = "Table 4";
                open_tableLayout(tableName);
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

  /*  protected void onResume(){
        super.onResume();


    }*/

    public void staff_sign_out() {
        Intent signOut_intent = new Intent(this, Waitstaff_MainScreen.class);
        startActivity(signOut_intent);
    }

    public void open_tableLayout(String tableName) {
        Intent rl_intent = new Intent(this, Waitstaff_Table_Details.class);
        rl_intent.putExtra("tableHeader", tableName);
        startActivity(rl_intent);
    }
}
