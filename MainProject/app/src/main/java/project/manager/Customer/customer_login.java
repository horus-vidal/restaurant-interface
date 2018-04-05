package project.manager.Customer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import project.manager.R;

public class customer_login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customer_login);

        setTitle("Customer Log-in");

        Button sign_in_button = (Button) findViewById(R.id.customer_log_in_button);
        sign_in_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //get username
                EditText customerName;
                customerName = (EditText) findViewById(R.id.customer_id);
                Toast.makeText(getApplicationContext(), (customerName.getText().toString() + " signed in."), Toast.LENGTH_SHORT).show();

                //get password
                staff_sign_in();
            }
        });
    }
    public void staff_sign_in() {
        Intent signIn_intent = new Intent(this, customer_MainActivity.class);
        startActivity(signIn_intent);
    }
}
