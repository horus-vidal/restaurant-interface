package project.manager.Waitstaff;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import project.manager.DBhelper;
import project.manager.R;

public class Waitstaff_MainScreen extends AppCompatActivity {
    DBhelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDb = new DBhelper(this);

        setTitle("Waitstaff Log-in");

        Button sign_in_button = (Button) findViewById(R.id.log_in_button);
        sign_in_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //get username
                EditText waiterName;
                waiterName = (EditText) findViewById(R.id.customer_id);

                EditText waiterPassword;
                waiterPassword = (EditText) findViewById(R.id.waitstaff_password);

 //take this out lmao
                Log.d("log: ", " LOGGED LMAO ");


                //if waiters aren't fully staffed and user isn't already "clocked in", "clock in" waiter
                if(myDb.getWaiterCount() < 4 && myDb.doesWaiterExist(waiterName.getText().toString()) == false)
                {
                    myDb.WSlogin(waiterName.getText().toString(), waiterPassword.getText().toString());
                    Toast.makeText(getApplicationContext(), (waiterName.getText().toString() + " signed in."), Toast.LENGTH_SHORT).show();
                }




                //get password?

                staff_sign_in();
            }
        });
    }
    public void staff_sign_in() {
        Intent signIn_intent = new Intent(this, Waitstaff_TablesActivity.class);
        startActivity(signIn_intent);
    }
}
