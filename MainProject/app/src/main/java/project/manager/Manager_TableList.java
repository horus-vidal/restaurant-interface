package project.manager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;

public class Manager_TableList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_list);

        getSupportActionBar().setTitle("Tables");

        // Create Table List with Buttons
        TableLayout layout = (TableLayout) findViewById(R.id.table_layout);

        // create 8 rows in the table
        for (int i = 0; i < 8; i++) {
            TableRow row = new TableRow(this);
            TableLayout.LayoutParams row_params = new TableLayout.LayoutParams(
                    TableLayout.LayoutParams.MATCH_PARENT,
                    0,
                    1);
            row.setLayoutParams(row_params);

            // create 2 buttons in each row
            for (int j = 0; j < 2; j++) {
                final int table_num = (i * 2) + j + 1;
                TableRow.LayoutParams button_params = new TableRow.LayoutParams (
                        0,
                        TableRow.LayoutParams.MATCH_PARENT,
                        1
                );
                Button table_button = new Button(this);
                table_button.setLayoutParams(button_params);

                // **** GETTER for table active status ****
                String active = "";

                table_button.setText("Table " + table_num + "\nStatus: " + active);


                // set button click to send to table information screen
                table_button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //Log.d("code", "code = " + table_num);
                        Intent intent = new Intent(Manager_TableList.this, Manager_TableInformation.class);
                        intent.putExtra("table_num", table_num);
                        startActivity(intent);
                    }
                });
                row.addView(table_button);
            }
            layout.addView(row);
        }
    }
}