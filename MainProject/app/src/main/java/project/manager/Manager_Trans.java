package project.manager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class Manager_Trans extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transactions);

        // generate buttons from database
        // clicking button goes to transactioninformation screen

        getSupportActionBar().setTitle("Transcations");
        LinearLayout layout = (LinearLayout) findViewById(R.id.transactionsList);

        // create a row for each transaction in the database
        // **** example with for loop ****
        for (int i = 0; i < 50; i++)
        {
            LinearLayout.LayoutParams button_params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    30
            );
            Button button = new Button(this);
            //button.setLayoutParams(button_params);

            // **** GETTER for transactions information to place in button
            // id, date
            final int transaction_ID = i+1000;
            String text = "ID: " + transaction_ID + "    Date: 1/11/11    Click To View";
            button.setText(text);

            // set button click to send to transaction information screen
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Log.d("code", "code = " + table_num);
                    Intent intent = new Intent(Manager_Trans.this, Manager_TransInformation.class);
                    intent.putExtra("trans_ID", transaction_ID);
                    startActivity(intent);
                }
            });
            layout.addView(button);
        }
    }
}
