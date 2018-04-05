package project.manager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

public class Manager_TableInformation extends AppCompatActivity {
    int table_num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_information);

        // get table number
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            table_num = extras.getInt("table_num");
        }

        getSupportActionBar().setTitle("Table " + table_num + " Information");

        String main_text = "";
        // **** GETTER for all table information of specific table ****
        // put all of it into main_text, maybe as main_text+="key: value\n" etc..

        TextView text2 = (TextView) findViewById(R.id.textView2);
        text2.setText(main_text);
    }
}
