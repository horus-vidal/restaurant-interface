package project.manager;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

//import java.util.ArrayList;
//import java.util.LinkedHashMap;

public class Waitstaff_Table_Details extends AppCompatActivity {
    private String[] OrdersArray = {"ORDER 1", "ORDER 2", "ORDER 3"};

    private ListView ListOrder;
    private ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table__details);

        Bundle b = getIntent().getExtras();
        String header = b.getString("tableHeader");

        //Header Text View
        TextView headerTxt = (TextView) findViewById(R.id.table_header);
        headerTxt.setText(header);

        //Back Button
        Button back_button = (Button) findViewById(R.id.table_back_button);
        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                go_back();
            }
        });

        //Orders List
        ListOrder = (ListView) findViewById(R.id.listView);
        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, OrdersArray);
        ListOrder.setAdapter(arrayAdapter);
        ListOrder.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Get the selected item text from ListView
                String selectedItem = (String) adapterView.getItemAtPosition(i);
                //Pass selected item to new activity header
                Intent item_intent = new Intent(view.getContext(), Waitstaff_Order_details.class);
                item_intent.putExtra("itemHeader", selectedItem);
                startActivity(item_intent);
            }
        });

        //Reset Button
        Button reset_button = (Button) findViewById(R.id.table_reset_button);
        reset_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ListOrder.setAdapter(null);
            }
        });

    }

    public void go_back() {
        Intent back_intent = new Intent(this, Waitstaff_TablesActivity.class);
        startActivity(back_intent);
    }


}
