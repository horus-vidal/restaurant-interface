package project.manager;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CompReports extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comp_reports);

        getSupportActionBar().setTitle("Compensation Reports");

        // generate list of comps from database
        LinearLayout layout = (LinearLayout) findViewById(R.id.compsList);

        // create a textViews for each compensation
        // **** example with for loop ****
        for (int i = 0; i < 50; i++)
        {
            TextView textView = new TextView(this);
            textView.setPadding(0, 60, 0, 0);

            // **** GETTER for compensation information to place in button
            // Date, Item, Reason, Server
            String text = "Date: 1/11/11\n";
            text += "Item: Item\n";
            text += "Reason: N/A\n";
            text += "Server: John Doe";

            textView.setText(text);
            layout.addView(textView);
        }
    }
}
