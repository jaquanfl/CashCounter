package com.example.cashcounter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import android.animation.ObjectAnimator;
import android.animation.AnimatorSet;

public class MainActivity extends AppCompatActivity {
    TextView totalText, inventory, inventory2;
    Button addOne, addFive, addTen, addTwenty, addFifty, addHundred;
    Button removeOne, removeFive, removeTen, removeTwenty, removeFifty, removeHundred;
    Button addPenny, addNickel, addDime, addQuarter;
    Button removePenny, removeNickel, removeDime, removeQuarter;
    Button clear;

    double totalSum = 0;
    int onesCount, fivesCount, tensCount, twentyCount, fiftyCount, hundredCount;
    int pennyCount, dimesCount, nickelsCount, quartersCount;


    DecimalFormat df = new DecimalFormat("#.##");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         // Initialize views
        totalText = findViewById(R.id.totalText);
        inventory = findViewById(R.id.inventory);
        inventory2 = findViewById(R.id.inventory2);

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
        // Initial text for inventory
        inventory.setText("$1: "+onesCount+"\n$5: "+fivesCount+"\n$10: "+tensCount+"\n$20: "+twentyCount+"\n$50: "+fiftyCount+"\n$100: "+hundredCount);
        inventory2.setText("$0.01: "+pennyCount+"\n$0.05: "+nickelsCount+"\n$0.10: "+dimesCount+"\n$0.25: "+quartersCount);



        // Button Listeners
        View.OnClickListener buttonClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.getId() == R.id.clear) {
                    Toast.makeText(getApplicationContext(),"To CLEAR: Press and Hold",Toast.LENGTH_SHORT).show();
                } else if (view.getId() == R.id.addOne) {
                    onesCount++;
                    totalSum++;
                } else if (view.getId() == R.id.addFive) {
                    fivesCount++;
                    totalSum += 5;
                } else if (view.getId() == R.id.addTen) {
                    tensCount++;
                    totalSum += 10;
                } else if (view.getId() == R.id.addTwenty) {
                    twentyCount++;
                    totalSum += 20;
                } else if (view.getId() == R.id.addFifty) {
                    fiftyCount++;
                    totalSum += 50;
                } else if (view.getId() == R.id.addHundred) {
                    hundredCount++;
                    totalSum += 100;
                } else if (view.getId() == R.id.addPenny) {
                    pennyCount++;
                    totalSum += 0.01;
                } else if (view.getId() == R.id.addNickel) {
                    nickelsCount++;
                    totalSum += 0.05;
                } else if (view.getId() == R.id.addDime) {
                    dimesCount++;
                    totalSum += 0.10;
                } else if (view.getId() == R.id.addQuarter) {
                    quartersCount++;
                    totalSum += 0.25;
                } else if (view.getId() == R.id.removeOne && onesCount > 0) {
                    onesCount--;
                    totalSum--;
                } else if (view.getId() == R.id.removeFive && fivesCount > 0) {
                    fivesCount--;
                    totalSum -= 5;
                } else if (view.getId() == R.id.removeTen && tensCount > 0) {
                    tensCount--;
                    totalSum -= 10;
                } else if (view.getId() == R.id.removeTwenty && twentyCount > 0) {
                    twentyCount--;
                    totalSum -= 20;
                } else if (view.getId() == R.id.removeFifty && fiftyCount > 0) {
                    fiftyCount--;
                    totalSum -= 50;
                } else if (view.getId() == R.id.removeHundred && hundredCount > 0) {
                    hundredCount--;
                    totalSum -= 100;
                } else if (view.getId() == R.id.removePenny && pennyCount > 0) {
                    pennyCount--;
                    totalSum -= 0.01;
                } else if (view.getId() == R.id.removeNickel && nickelsCount > 0) {
                    nickelsCount--;
                    totalSum -= 0.05;
                } else if (view.getId() == R.id.removeDime && dimesCount > 0) {
                    dimesCount--;
                    totalSum -= 0.10;
                } else if (view.getId() == R.id.removeQuarter && quartersCount > 0) {
                    quartersCount--;
                    totalSum -= 0.25;
                }

                if(view.getId() == R.id.totalText){
                    if(inventory.getVisibility() == View.INVISIBLE){
                        totalText.setEnabled(false);
                        ObjectAnimator translationAnimator = ObjectAnimator.ofFloat(totalText, "translationY", -totalText.getHeight());
                        translationAnimator.setDuration(500);
                        ObjectAnimator alphaAnimator = ObjectAnimator.ofFloat(inventory, "alpha", 0f, 1f);
                        alphaAnimator.setDuration(700);
                        ObjectAnimator alphaAnimator2 = ObjectAnimator.ofFloat(inventory2, "alpha", 0f, 1f);
                        alphaAnimator2.setDuration(700);

                        Animator.AnimatorListener listener = new AnimatorListenerAdapter() {
                            @Override
                            public void onAnimationEnd(Animator animation) {
                                super.onAnimationEnd(animation);
                                totalText.setEnabled(true);
                            }
                        };
                        alphaAnimator.addListener(listener);

                        AnimatorSet animatorSet = new AnimatorSet();
                        animatorSet.playTogether(translationAnimator, alphaAnimator, alphaAnimator2);
                        animatorSet.start();
                        inventory.setVisibility(View.VISIBLE);
                        inventory2.setVisibility(View.VISIBLE);
                    }
                    else{
                        ObjectAnimator translationAnimator = ObjectAnimator.ofFloat(totalText, "translationY", 0);
                        translationAnimator.setDuration(500);
                        ObjectAnimator alphaAnimator = ObjectAnimator.ofFloat(inventory, "alpha", 1f, 0f);
                        alphaAnimator.setDuration(200);
                        ObjectAnimator alphaAnimator2 = ObjectAnimator.ofFloat(inventory2, "alpha", 1f, 0f);
                        alphaAnimator2.setDuration(200);

                        Animator.AnimatorListener listener = new AnimatorListenerAdapter() {
                            @Override
                            public void onAnimationEnd(Animator animation) {
                                super.onAnimationEnd(animation);
                                totalText.setEnabled(true);
                                inventory.setVisibility(View.INVISIBLE);
                                inventory2.setVisibility(View.INVISIBLE);
                            }
                        };
                        alphaAnimator.addListener(listener);

                        AnimatorSet animatorSet = new AnimatorSet();
                        animatorSet.playTogether(translationAnimator, alphaAnimator, alphaAnimator2);
                        animatorSet.start();
                    }
                }

                // Update the totalText with the updated totalSum
                totalText.setText("$" + String.valueOf(df.format(totalSum)));

                // Update the inventory text
                inventory.setText("$1: "+onesCount+"\n$5: "+fivesCount+"\n$10: "+tensCount+"\n$20: "+twentyCount+"\n$50: "+fiftyCount+"\n$100: "+hundredCount);
                inventory2.setText("$0.01: "+pennyCount+"\n$0.05: "+nickelsCount+"\n$0.10: "+dimesCount+"\n$0.25: "+quartersCount);

            }
        };

        clear.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                totalSum = onesCount = fivesCount = tensCount = twentyCount = fiftyCount = hundredCount = 0;
                totalText.setText("$" + String.valueOf(df.format(totalSum)));
                inventory.setText("$1: "+onesCount+"\n$5: "+fivesCount+"\n$10: "+tensCount+"\n$20: "+twentyCount+"\n$50: "+fiftyCount+"\n$100: "+hundredCount);
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
        totalText.setOnClickListener(buttonClickListener);
    }
}