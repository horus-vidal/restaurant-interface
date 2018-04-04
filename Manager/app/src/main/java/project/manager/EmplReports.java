package project.manager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class EmplReports extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empl_reports);

        getSupportActionBar().setTitle("Employee Reports");

        // generate list of employees from the database
        // generate two buttons next to each employee for weekly and daily report

        LinearLayout layout = (LinearLayout) findViewById(R.id.employeeMainLayout);

        // loop for each employee
        // example using for loop
        for (int i = 0; i < 50; i++)
        {
            // create row to add to list
            LinearLayout row = new LinearLayout(this);
            LinearLayout.LayoutParams row_params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    200
            );
            row.setLayoutParams(row_params);

            TextView textView = new TextView(this);
            Button button1 = new Button(this); // daily report
            Button button2 = new Button(this); // weekly report

            // **** GETTER for employee ID ****
            final int employee_ID = i + 1000;
            String text = "Employee ID: " + employee_ID;
            textView.setText(text);

            LinearLayout.LayoutParams viewParams = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    60,
                    2
            );
            //textView.setLayoutParams(viewParams);

            // set buttons for daily and weekly
            button1.setText("Daily");
            button2.setText("Weekly");

            button1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Log.d("code", "code = " + table_num);
                    Intent intent = new Intent(EmplReports.this, EmplReportInformation.class);
                    intent.putExtra("id", employee_ID);
                    intent.putExtra("type", "Daily");
                    startActivity(intent);
                }
            });

            button2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Log.d("code", "code = " + table_num);
                    Intent intent = new Intent(EmplReports.this, EmplReportInformation.class);
                    intent.putExtra("id", employee_ID);
                    intent.putExtra("type", "Weekly");
                    startActivity(intent);
                }
            });

            LinearLayout.LayoutParams buttonParams = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    150,
                    1
            );

            button1.setLayoutParams(buttonParams);
            button2.setLayoutParams(buttonParams);

            // add text and buttons to row
            row.addView(textView);
            row.addView(button1);
            row.addView(button2);

            // add row to main layout
            layout.addView(row);
        }
    }
}
