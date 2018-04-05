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

public class Waitstaff_Order_details extends AppCompatActivity {

    private String[] ItemsArray = {"Krabby Patty", "JellyFish Sandwich", "Fries"};

    private ListView ListItem;
    private ArrayAdapter arrayAdapter2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);

        Bundle new_b = getIntent().getExtras();
        String item_header = new_b.getString("itemHeader");

        //Header Text View
        TextView item_headerTxt = (TextView) findViewById(R.id.order_Num);
        item_headerTxt.setText(item_header);

        //Back Button
        Button order_back_button = (Button) findViewById(R.id.order_back_button);
        order_back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                order_back();
            }
        });

        //Orders List
        ListItem = (ListView) findViewById(R.id.orderView);
        arrayAdapter2 = new ArrayAdapter(this, android.R.layout.simple_list_item_1, ItemsArray);
        ListItem.setAdapter(arrayAdapter2);
        ListItem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Get the selected item text from ListView
                String selectedItem = (String) adapterView.getItemAtPosition(i);
                //Pass selected item to new activity header
                Intent aboutItem_intent = new Intent(view.getContext(), Waitstaff_item_details.class);
                aboutItem_intent.putExtra("itemName", selectedItem);
                startActivity(aboutItem_intent);
            }
        });

    }

    public void order_back() {
        Intent Order_back_intent = new Intent(this, Waitstaff_Table_Details.class);
        startActivity(Order_back_intent);
    }
}
