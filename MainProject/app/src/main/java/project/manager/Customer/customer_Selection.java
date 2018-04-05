package project.manager.Customer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import project.manager.R;

public class customer_Selection extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customer_activity_selection);
        Bundle nameData = getIntent().getExtras();
        final String itemName = nameData.getString("itemName");
        final String itemPrice = nameData.getString ("itemPrice");
        Intent intent = getIntent();
        // String [] Desserts = intent.getStringArrayExtra("itemName");
        final TextView NameTextView = (TextView) findViewById(R.id.NameTextView);
        final TextView PriceTextView = (TextView) findViewById(R.id.PriceTextView);
        NameTextView.setText(itemName);
        PriceTextView.setText(itemPrice);

        ImageButton ModifyBtn = (ImageButton) findViewById(R.id.ModifyBtn);
        ModifyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startIntent = new Intent(getApplicationContext(), customer_Mods.class);
                startActivity(startIntent);
            }
        });


        ImageButton OrderBtn = (ImageButton) findViewById(R.id.OrderBtn);
        OrderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), customer_cart.class);
                Toast.makeText( getApplicationContext(),"Order Added: " + itemName, Toast.LENGTH_LONG).show();

               // Intent intent = new Intent(customer_Selection.this, customer_cart.class);
                intent.putExtra("itemNames", itemName);
                intent.putExtra("itemPrices", itemPrice);
                Intent intent2 = new Intent(getApplicationContext(), customer_MainActivity.class);

                startActivity(intent);
            }
        });

        Button BackBtn = (Button) findViewById(R.id.BackBtn);
        BackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startIntent = new Intent(getApplicationContext(), customer_Food.class);
                startActivity(startIntent);
            }
        });

    }
}
