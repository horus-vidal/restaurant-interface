package com.example.chimchilla.krustykrab;

//public class Dessert extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_dessert);
//        final String[] NAMES = {"Dessert 1", "Dessert 2", " Dessert 3", " Dessert 4"};
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
//                        String Dessert = String.valueOf(parent.getItemAtPosition(position));
//                        Intent intent = new Intent(Dessert.this, Selection.class);
//                        intent.putExtra("itemName", Dessert);
//                        context.startActivity(intent);;
//
//
//                      //  Toast.makeText( Dessert.this,"Order Added: " + Dessert, Toast.LENGTH_LONG).show();
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
//public class Dessert extends ListActivity {
//
//    public void onCreate(Bundle icicle) {
//        super.onCreate(icicle);
//        // 1. pass context and data to the custom adapter
//        custom_adapter adapter = new custom_adapter(this, generateData());
//
//        // 2. Get ListView from activity_main.xml
//        ListView listView = (ListView) findViewById(R.id.EntreeList);
//
//        // 3. setListAdapter
//        listView.setAdapter(adapter);
//    }
//
//    private ArrayList<Items> generateData(){
//        ArrayList<Items> items = new ArrayList<Items>();
//        items.add(new Items("Item 1","First Item on the list"));
//        items.add(new Items("Item 2","Second Item on the list"));
//        items.add(new Items("Item 3","Third Item on the list"));
//
//        return items;
//    }
//

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

//package com.example.chimchilla.customlayout;

public class Dessert extends AppCompatActivity {
    int[] IMAGES = {R.drawable.ic_launcher_background, R.drawable.ic_launcher_foreground};
    String[] Name = {"Dessert 1", "Dessert 2", "Dessert 3"};
    String[] Description = {"$9.99", "$2.99", "$5.99"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrees);

        ListView listView = (ListView) findViewById(R.id.EntreeList);
        custom_adapter customAdapter = new custom_adapter();

        listView.setAdapter(customAdapter);

        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {

                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Context context = view.getContext();
                        String Dessert = String.valueOf(parent.getItemAtPosition(position));
                        Intent intent = new Intent(Dessert.this, Selection.class);
                        intent.putExtra("itemName", Name[position]);
                        intent.putExtra("itemPrice", Description[position]);
                        context.startActivity(intent);;


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


            view = getLayoutInflater().inflate(R.layout.custom_row,null);
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
