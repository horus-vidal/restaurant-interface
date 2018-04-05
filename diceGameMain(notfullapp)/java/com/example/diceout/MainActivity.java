package com.example.diceout;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    //Field to hold roll result text
    TextView rollResult;

    //field to hold the score
    int score;

    Random rand;

    //fields to hold the dice values
    int die1;
    int die2;
    int die3;

    //Field to hold the score text
    TextView scoreText;

    //Arraylist to hold all 3 dice
    ArrayList<Integer> dice;

    //ArrayList to hold all 3 dice images
    ArrayList<ImageView> diceImageViews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rollDice(view);
            }
        });

        //set initial score
        score = 0;

        //create greeting
        Toast.makeText(getApplicationContext(), "Welcome to Dice Roller!", Toast.LENGTH_SHORT).show();

        //links java items to layout items
        rollResult = findViewById(R.id.rollResult);
        scoreText = findViewById(R.id.scoreText);

        //initialize the random number generator
        rand = new Random();

        //create ArrayList container for dice
        dice = new ArrayList<Integer>();

        ImageView die1Image = (ImageView) findViewById(R.id.die1Image);
        ImageView die2Image = (ImageView) findViewById(R.id.die2Image);
        ImageView die3Image = (ImageView) findViewById(R.id.die3Image);

        diceImageViews = new ArrayList<ImageView>();
        diceImageViews.add(die1Image);
        diceImageViews.add(die2Image);
        diceImageViews.add(die3Image);
    }

    public void rollDice(View v){
        rollResult.setText("Clicked!");

        //roll dice
        die1 = rand.nextInt(6)+1;
        die2 = rand.nextInt(6)+1;
        die3 = rand.nextInt(6)+1;

        //set dice values into arraylist
        dice.clear();
        dice.add(die1);
        dice.add(die2);
        dice.add(die3);

        //loops through all 3 dice
        for(int dieOfSet = 0; dieOfSet < 3; dieOfSet++){
            String imageName = "die_" + dice.get(dieOfSet) + ".png"; //creates image name from rand num
            try{
                InputStream stream = getAssets().open(imageName); //stream gets pics from "assets folder"
                Drawable d = Drawable.createFromStream(stream, null); //creates empty? drawable
                diceImageViews.get(dieOfSet).setImageDrawable(d); //sets current dice in loop to be a drawable
            } catch(IOException e){
                e.printStackTrace();
            }
        }


        //build message with result
        String msg = "";

        if(die1 == die2 && die1 == die3){
            //Triples
            int scoreDelta = die1 * 100;
            msg = "You rolled a triple " + die1 + "! You scored " + scoreDelta + " points!";
            score += scoreDelta;
        } else if(die1 == die2 || die1 == die3 || die2 == die3) {
            score += 50;
            msg = "Doubles! +50 points ";
        } else {
            msg = "You didn't score this roll. Try again!";
        }

        //Update the app to display the result message
        rollResult.setText(msg);
        scoreText.setText("Score: " + score);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
