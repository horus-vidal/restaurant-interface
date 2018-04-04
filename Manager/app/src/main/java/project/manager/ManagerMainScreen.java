package project.manager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ManagerMainScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("Manager Interface");
    }

    // Start Table List
    public void startTableList(View view) {
        Intent intent = new Intent(this, TableList.class);
        startActivity(intent);
    }

    // Start Transaction Activity
    public void startTrans(View view) {
        Intent intent = new Intent(this, Transactions.class);
        startActivity(intent);
    }

    // Start Compensation Report Activity
    public void startComps(View view) {
        Intent intent = new Intent(this, CompReports.class);
        startActivity(intent);
    }

    // Start Employee Reports Activity
    public void startEmpl(View view) {
        Intent intent = new Intent(this, EmplReports.class);
        startActivity(intent);
    }

}
