package project.manager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import project.manager.Customer.customer_login;
import project.manager.Manager.Manager_MainScreen;
import project.manager.Waitstaff.Waitstaff_MainScreen;

public class MainProjectScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_project_screen);

        getSupportActionBar().setTitle("Project");
    }

    // Start customer interface
    public void startCustomer(View view) {
        Intent intent = new Intent(this, customer_login.class);
        startActivity(intent);
    }

    // Start waitstaff interface
    public void startWaitstaff(View view) {
        Intent intent = new Intent(this, Waitstaff_MainScreen.class);
        startActivity(intent);
    }

    // Start kitchen interface
    public void startKitchen(View view) {
        //Intent intent = new Intent(this, KITCHEN_ACTIVITY.class);
        //startActivity(intent);
    }

    // Start manager interface
    public void startManager(View view) {
        Intent intent = new Intent(this, Manager_MainScreen.class);
        startActivity(intent);
    }
}
