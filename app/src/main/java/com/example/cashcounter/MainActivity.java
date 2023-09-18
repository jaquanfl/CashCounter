package com.example.cashcounter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    TextView totalText;
    Button addOne, addFive, addTen, addTwenty, addFifty, addHundred;
    Button removeOne, removeFive, removeTen, removeTwenty, removeFifty, removeHundred;
    Button addPenny, addNickel, addDime, addQuarter;
    Button removePenny, removeNickel, removeDime, removeQuarter;
    Button clear;

    double totalSum = 0;
    DecimalFormat df = new DecimalFormat("#.##");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         // Initialize views
        totalText = findViewById(R.id.totalText);
        addOne = findViewById(R.id.addOne);
        addFive = findViewById(R.id.addFive);
        addTen = findViewById(R.id.addTen);
        addTwenty = findViewById(R.id.addTwenty);
        addFifty = findViewById(R.id.addFifty);
        addHundred = findViewById(R.id.addHundred);
        removeOne = findViewById(R.id.removeOne);
        removeFive = findViewById(R.id.removeFive);
        removeTen = findViewById(R.id.removeTen);
        removeTwenty = findViewById(R.id.removeTwenty);
        removeFifty = findViewById(R.id.removeFifty);
        removeHundred = findViewById(R.id.removeHundred);

        addPenny = findViewById(R.id.addPenny);
        addNickel = findViewById(R.id.addNickel);
        addDime = findViewById(R.id.addDime);
        addQuarter = findViewById(R.id.addQuarter);
        removePenny = findViewById(R.id.removePenny);
        removeNickel = findViewById(R.id.removeNickel);
        removeDime = findViewById(R.id.removeDime);
        removeQuarter = findViewById(R.id.removeQuarter);

        clear = findViewById(R.id.clear);

        // Initial text for total sum
        totalText.setText("$" + String.valueOf(df.format(totalSum)));



        // Button Listeners
        View.OnClickListener buttonClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.getId() == R.id.clear) {
                    Toast.makeText(getApplicationContext(),"To CLEAR: Press and Hold",Toast.LENGTH_SHORT).show();
                } else if (view.getId() == R.id.addOne) {
                    totalSum++;
                } else if (view.getId() == R.id.addFive) {
                    totalSum += 5;
                } else if (view.getId() == R.id.addTen) {
                    totalSum += 10;
                } else if (view.getId() == R.id.addTwenty) {
                    totalSum += 20;
                } else if (view.getId() == R.id.addFifty) {
                    totalSum += 50;
                } else if (view.getId() == R.id.addHundred) {
                    totalSum += 100;
                } else if (view.getId() == R.id.addPenny) {
                    totalSum += 0.01;
                } else if (view.getId() == R.id.addNickel) {
                    totalSum += 0.05;
                } else if (view.getId() == R.id.addDime) {
                    totalSum += 0.10;
                } else if (view.getId() == R.id.addQuarter) {
                    totalSum += 0.25;
                } else if (view.getId() == R.id.removeOne) {
                    totalSum--;
                } else if (view.getId() == R.id.removeFive) {
                    totalSum -= 5;
                } else if (view.getId() == R.id.removeTen) {
                    totalSum -= 10;
                } else if (view.getId() == R.id.removeTwenty) {
                    totalSum -= 20;
                } else if (view.getId() == R.id.removeFifty) {
                    totalSum -= 50;
                } else if (view.getId() == R.id.removeHundred) {
                    totalSum -= 100;
                } else if (view.getId() == R.id.removePenny) {
                    totalSum -= 0.01;
                } else if (view.getId() == R.id.removeNickel) {
                    totalSum -= 0.05;
                } else if (view.getId() == R.id.removeDime) {
                    totalSum -= 0.10;
                } else if (view.getId() == R.id.removeQuarter) {
                    totalSum -= 0.25;
                }
                if(totalSum < 0) {
                    totalSum = 0;
                }

                // Update the totalText with the updated totalSum
                totalText.setText("$" + String.valueOf(df.format(totalSum)));
            }
        };

        clear.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                totalSum = 0;
                totalText.setText("$" + String.valueOf(df.format(totalSum)));
                return true;
            }
        });
        clear.setOnClickListener(buttonClickListener);
        addOne.setOnClickListener(buttonClickListener);
        addFive.setOnClickListener(buttonClickListener);
        addTen.setOnClickListener(buttonClickListener);
        addTwenty.setOnClickListener(buttonClickListener);
        addFifty.setOnClickListener(buttonClickListener);
        addHundred.setOnClickListener(buttonClickListener);
        removeOne.setOnClickListener(buttonClickListener);
        removeFive.setOnClickListener(buttonClickListener);
        removeTen.setOnClickListener(buttonClickListener);
        removeTwenty.setOnClickListener(buttonClickListener);
        removeFifty.setOnClickListener(buttonClickListener);
        removeHundred.setOnClickListener(buttonClickListener);
        addPenny.setOnClickListener(buttonClickListener);
        addNickel.setOnClickListener(buttonClickListener);
        addDime.setOnClickListener(buttonClickListener);
        addQuarter.setOnClickListener(buttonClickListener);
        removePenny.setOnClickListener(buttonClickListener);
        removeNickel.setOnClickListener(buttonClickListener);
        removeDime.setOnClickListener(buttonClickListener);
        removeQuarter.setOnClickListener(buttonClickListener);
    }
}