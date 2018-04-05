package project.manager.Customer;//package com.example.chimchilla.krustykrab;
//
//import android.content.Context;
//import android.content.Intent;
//import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
//import android.view.View;
//import android.widget.AdapterView;
//import android.widget.ListAdapter;
//import android.widget.ListView;
//
//public class customer_drink extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.customer_activity_drink);
//        String [] drinks  = {"Drink 1", "Drink 2", " Drink 3", " Drink 4"};
//        ListAdapter stupidAdapter = new custom_adapter(this, drinks);
//        ListView EntreeList = (ListView) findViewById(R.id.EntreeList);
//        EntreeList.setAdapter(stupidAdapter);
//        EntreeList.setOnItemClickListener(
//
//                new AdapterView.OnItemClickListener() {
//
//                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                        Context context = view.getContext();
//                        String drinks = String.valueOf(parent.getItemAtPosition(position));
//                        Intent intent = new Intent(customer_drink.this, customer_Selection.class);
//                        intent.putExtra("itemName", drinks);
//                        context.startActivity(intent);;
//    }
//}
//        );
//    }
//}

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import project.manager.R;

//package com.example.chimchilla.krustykrab;
//public class customer_Dessert extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.customer_activity_dessert);
//        final String[] NAMES = {"customer_Dessert 1", "customer_Dessert 2", " customer_Dessert 3", " customer_Dessert 4"};
//        final String [] PRICE = {"$14.99", "$12.99", "$13.50", "$45.00"};
//        ListAdapter stupidAdapter = new custom_adapter(this, NAMES);
//        ListAdapter priceAdapter = new custom_adapter(this, PRICE);
//
//        ListView EntreeList = (ListView) findViewById(R.id.EntreeList);
//        EntreeList.setAdapter(priceAdapter);
//
//        EntreeList.setOnItemClickListener(
//
//                new AdapterView.OnItemClickListener() {
//
//                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                        Context context = view.getContext();
//                        String customer_Dessert = String.valueOf(parent.getItemAtPosition(position));
//                        Intent intent = new Intent(customer_Dessert.this, customer_Selection.class);
//                        intent.putExtra("itemName", customer_Dessert);
//                        context.startActivity(intent);;
//
//
//                      //  Toast.makeText( customer_Dessert.this,"Order Added: " + customer_Dessert, Toast.LENGTH_LONG).show();
//                    }
//                }
//        );
//    }
//}
//
//
//import android.app.ListActivity;
//import android.os.Bundle;
//import android.widget.ListView;
//
//import java.util.ArrayList;
//
//
//public class customer_Dessert extends ListActivity {
//
//    public void onCreate(Bundle icicle) {
//        super.onCreate(icicle);
//        // 1. pass context and data to the custom adapter
//        custom_adapter adapter = new custom_adapter(this, generateData());
//
//        // 2. Get ListView from customer_activity_main.xml_main.xml
//        ListView listView = (ListView) findViewById(R.id.EntreeList);
//
//        // 3. setListAdapter
//        listView.setAdapter(adapter);
//    }
//
//    private ArrayList<customer_Items> generateData(){
//        ArrayList<customer_Items> items = new ArrayList<customer_Items>();
//        items.add(new customer_Items("Item 1","First Item on the list"));
//        items.add(new customer_Items("Item 2","Second Item on the list"));
//        items.add(new customer_Items("Item 3","Third Item on the list"));
//
//        return items;
//    }
//
//}

//package com.example.chimchilla.customlayout;

public class customer_drink extends AppCompatActivity {
    int[] IMAGES = {R.drawable.ic_launcher_background, R.drawable.ic_launcher_foreground};
    String[] Name = {"Drink 1", "Drink 2", "Drink  3"};
    String[] Description = {"$1.99", "$2.99", "$1.99"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customer_activity_drink);

        setTitle("Drinks");

        ListView listView = (ListView) findViewById(R.id.EntreeList);
        custom_adapter customAdapter = new custom_adapter();

        listView.setAdapter(customAdapter);

        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {

                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Context context = view.getContext();
                        String Dessert = String.valueOf(parent.getItemAtPosition(position));
                        Intent intent = new Intent(customer_drink.this, customer_Selection.class);
                        intent.putExtra("itemName", Name[position]);
                        intent.putExtra("itemPrice", Description[position]);
                        context.startActivity(intent);
                        ;
                    }
                });
    }
    public class custom_adapter extends BaseAdapter {
        @Override
        public int getCount () {
            return IMAGES.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup)

        {
            view = getLayoutInflater().inflate(R.layout.customer_custom_row,null);
            ImageView imageView = (ImageView)view.findViewById(R.id.Krabby);
            TextView textView = (TextView) view.findViewById(R.id.Name);
            TextView textView1 = (TextView) view.findViewById(R.id.Price);

            imageView.setImageResource(IMAGES[i]);
            textView.setText(Name[i]);
            textView1.setText(Description[i]);


            return view;
        }
    }

}