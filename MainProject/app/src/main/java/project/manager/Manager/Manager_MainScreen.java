package project.manager.Manager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import project.manager.R;

public class Manager_MainScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager_main);

        getSupportActionBar().setTitle("Manager Interface");
    }

    // Start Table List
    public void startTableList(View view) {
        Intent intent = new Intent(this, Manager_TableList.class);
        startActivity(intent);
    }

    // Start Transaction Activity
    public void startTrans(View view) {
        Intent intent = new Intent(this, Manager_Trans.class);
        startActivity(intent);
    }

    // Start Compensation Report Activity
    public void startComps(View view) {
        Intent intent = new Intent(this, Manager_CompReports.class);
        startActivity(intent);
    }

    // Start Employee Reports Activity
    public void startEmpl(View view) {
        Intent intent = new Intent(this, Manager_EmplReports.class);
        startActivity(intent);
    }

}
