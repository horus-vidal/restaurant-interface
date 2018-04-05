package project.manager;//package com.example.chimchilla.krustykrab;//package com.example.chimchilla.krustykrab;
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
//public class customer_Music extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.customer_activity_apps);
//        String[] songs = {"Song #1", "Song #2", "Song #3", "Song #4"};
//        ListAdapter stupidAdapter = new custom_adapter(this, songs);
//        ListView EntreeList = (ListView) findViewById(R.id.EntreeList);
//        EntreeList.setAdapter(stupidAdapter);
//        EntreeList.setOnItemClickListener(
//
//                new AdapterView.OnItemClickListener() {
//
//                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                        Context context = view.getContext();
//                        String songs = String.valueOf(parent.getItemAtPosition(position));
//                        Intent intent = new Intent(customer_Music.this, customer_Selection.class);
//                        intent.putExtra("itemName", songs);
//                        context.startActivity(intent);
//
//                    }
//                }
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


//package com.example.chimchilla.customlayout;

public class customer_Music extends AppCompatActivity {
    int[] IMAGES = {R.drawable.ic_launcher_background, R.drawable.ic_launcher_foreground};
    String[] Name = {"Song 1", "Song 2", "Song 3"};
    String[] Description = {"$.99", "$.99", "$.99"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customer_activity_entrees);

        setTitle("Music");

        ListView listView = (ListView) findViewById(R.id.EntreeList);
        custom_adapter customAdapter = new custom_adapter();

        listView.setAdapter(customAdapter);

        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {

                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Context context = view.getContext();
                        String Dessert = String.valueOf(parent.getItemAtPosition(position));
                        Intent intent = new Intent(customer_Music.this, customer_Selection.class);
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
