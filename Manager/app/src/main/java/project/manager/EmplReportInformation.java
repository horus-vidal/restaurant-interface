package project.manager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class EmplReportInformation extends AppCompatActivity {

    int employee_ID;
    String type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empl_report_information);

        // get employee id and type
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            employee_ID = extras.getInt("id");
            type = extras.getString("type");
        }

        // change title to employee id + type
        getSupportActionBar().setTitle("Employee " + employee_ID + " " + type + " Report");


        // **** GETTER ****
        // generate report from database based on if user clicked weekly or daily button
    }
}
