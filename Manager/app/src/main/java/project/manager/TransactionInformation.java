package project.manager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class TransactionInformation extends AppCompatActivity {

    int trans_ID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction_information);

        // get transaction id
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            trans_ID = extras.getInt("trans_ID");
        }

        // change title to display Transaction ID: xxxxxxx
        getSupportActionBar().setTitle("Transaction ID: " + trans_ID);

        // display information about transaction in 2nd textView
    }
}
