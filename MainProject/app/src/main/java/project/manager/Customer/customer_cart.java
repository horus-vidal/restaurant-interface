package project.manager.Customer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

import project.manager.R;

public class customer_cart extends AppCompatActivity{



    @Override
    protected void onCreate(Bundle icicle) {


        super.onCreate(icicle);
        setContentView(R.layout.customer_activity_cart);
        Bundle nameDatas = getIntent().getExtras();
         String itemNamess = nameDatas.getString("itemNames");
         String itemPrice = nameDatas.getString("itemPrices");


        ListView listView = (ListView) findViewById(R.id.list);
        ArrayList<String> listItems = new ArrayList<String>();
       ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listItems);

        listView.setAdapter(adapter);
        listItems.add( itemNamess );
        adapter.notifyDataSetChanged();

        Button BackBtn = (Button) findViewById(R.id.BackBtn);
        BackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startIntent = new Intent(getApplicationContext(), customer_MainActivity.class);
                startActivity(startIntent);
            }
        });
    }

//    public void addItems(View v) {
//
//
//        listItems.add( itemName );
//       adapter.notifyDataSetChanged();
//    }
    }
