package com.astrology.date.datecal;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Button2Activity extends AppCompatActivity {

    static Map<Integer, Integer> repeatingNumber = new HashMap<>();
    static ArrayList<Integer> digits = new ArrayList<>();

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        repeatingNumber.clear();
        digits.clear();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button2);
        Intent intent = getIntent();
        String dateString = intent.getStringExtra("date");
        String dayString = dateString.substring(0, 2);
        String monthString = dateString.substring(2, 4);
        String yearString = dateString.substring(4, 8);
        Log.d("date", "onCreate: "+dayString+monthString+yearString+"date : "+dateString);
        int level = 1, classifiedNo1, classifiedNo2, finalNo, currentTriplet, inputDate, inputMonth, inputYear;
        int date = Integer.parseInt(dayString);
        inputDate = date;
        int month = Integer.parseInt(monthString);
        inputMonth = month;
        int year = Integer.parseInt(yearString);
        inputYear = year;
        List<Integer> availableTriplets = new ArrayList<>();
        List<Integer> missingTriplets = new ArrayList<>();
        List<Integer> availableNo = new ArrayList<>();
        List<Integer> missingNo = new ArrayList<>();
        int[] triplets = new int[]{438, 951, 276, 492, 357, 816, 456, 258};

        boolean isNumRepeating = false, tripletPresent1 = false, tripletPresent2 = false, tripletPresent3 = false;

        TextView result = (TextView) findViewById(R.id.result2);


        date = Integer.parseInt(dayString);
        date = findSum(date, level);
        month = findSum(month, level);
        year = findSum(year, level);

        if (repeatingNumber.get(date) == null) {
            repeatingNumber.put(date, 1);
        } else {
            repeatingNumber.put(date, repeatingNumber.get(date) + 1);
        }

        if (repeatingNumber.get(month) == null) {
            repeatingNumber.put(month, 1);
        } else {
            repeatingNumber.put(month, repeatingNumber.get(month) + 1);
        }

        if (repeatingNumber.get(year) == null) {
            repeatingNumber.put(year, 1);
        } else {
            repeatingNumber.put(year, repeatingNumber.get(year) + 1);
        }

        // System.out.println("date: "+date+" mont: "+month+" year: "+year);
        classifiedNo1 = date;
        digits.add(date);
        digits.add(month);
        digits.add(year);
        finalNo = findSum(date + month + year, level + 1);

        if (repeatingNumber.get(finalNo) == null) {
            repeatingNumber.put(finalNo, 1);
        } else {
            repeatingNumber.put(finalNo, repeatingNumber.get(finalNo) + 1);
        }

        classifiedNo2 = finalNo;
        digits.add(finalNo);
        System.out.println("Missing no:-");
        result.append("Missing no:-");
        result.append(System.getProperty("line.separator"));
        result.append(System.getProperty("line.separator"));
        for (int i = 1; i < 10; i++) {
            if (!digits.contains(i)) {
                missingNo.add(i);
            } else {
                availableNo.add(i);
            }
        }
        System.out.println("Missing no: ");
        System.out.println(missingNo);
        result.append(String.valueOf(missingNo));
        result.append(System.getProperty("line.separator"));
        result.append(System.getProperty("line.separator"));
        System.out.println("Available no: ");
        result.append("Available no: ");
        result.append(System.getProperty("line.separator"));
        result.append(System.getProperty("line.separator"));
        System.out.println(availableNo);
        result.append(String.valueOf(availableNo));
        result.append(System.getProperty("line.separator"));
        result.append(System.getProperty("line.separator"));
        for (int i = 0; i < triplets.length; i++) {
            tripletPresent1 = false;
            tripletPresent2 = false;
            tripletPresent3 = false;
            currentTriplet = triplets[i];
            if (availableNo.contains(currentTriplet % 10)) {
                tripletPresent1 = true;
                currentTriplet = currentTriplet / 10;
                if (availableNo.contains(currentTriplet % 10)) {
                    tripletPresent2 = true;
                    currentTriplet = currentTriplet / 10;
                    if (availableNo.contains(currentTriplet)) {
                        tripletPresent3 = true;

                    }
                }
            }
            if (tripletPresent1 && tripletPresent2 && tripletPresent3) {
                availableTriplets.add(triplets[i]);
            } else {
                missingTriplets.add(triplets[i]);
            }
        }
        System.out.println("Set: " + "(" + classifiedNo1 + "," + classifiedNo2 + ")");
        result.append("Set: " + "(" + classifiedNo1 + "," + classifiedNo2 + ")");
        result.append(System.getProperty("line.separator"));
        System.out.println("Available triplets: ");
        result.append("Available triplets");
        result.append(System.getProperty("line.separator"));
        System.out.println(availableTriplets);
        result.append(String.valueOf(availableTriplets));
        result.append(System.getProperty("line.separator"));
        System.out.println("Missing triplets: ");
        result.append("Missing triplets: ");
        result.append(System.getProperty("line.separator"));
        System.out.println(missingTriplets);
        result.append(String.valueOf(missingTriplets));
        result.append(System.getProperty("line.separator"));
        System.out.println("Repeating no: ");
        result.append("Repeating no: ");
        Iterator iterator = repeatingNumber.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry pair = (Map.Entry) iterator.next();
            System.out.println(pair.getKey() + " is " + pair.getValue() + " times");
            result.append(System.getProperty("line.separator"));
            result.append(System.getProperty("line.separator"));
            result.append(pair.getKey() + " is " + pair.getValue() + " times");
        }


        level = 1;
        inputDate = findSum(inputDate, level);
        inputMonth = findSum(inputMonth, level);
        inputYear = Calendar.getInstance().get(Calendar.YEAR);
        inputYear = findSum(inputYear, level);
        // System.out.println("date: "+date+" mont: "+month+" year: "+year);

        digits.add(inputDate);
        digits.add(inputMonth);
        digits.add(inputYear);
        finalNo = findSum(inputDate + inputMonth + inputYear, level + 1);
        result.append(System.getProperty("line.separator"));
        result.append(System.getProperty("line.separator"));
        System.out.println("Sum : " + finalNo);
        result.append("Sum with current year : " + finalNo);


    }

    public int findSum(int digit, int level) {
        // TODO Auto-generated method stub
        int sum = 0;
        if (digit < 10) {
            if (level == 1) {
                if (repeatingNumber.get(digit) == null) {
                    repeatingNumber.put(digit, 1);
                } else {
                    repeatingNumber.put(digit, repeatingNumber.get(digit) + 1);
                }


            }
            return digit;
        } else {
            while (digit > 0) {
                sum += (digit % 10);
                if (level == 1) {
                    if (repeatingNumber.get(digit % 10) == null) {
                        repeatingNumber.put(digit % 10, 1);
                    } else {
                        repeatingNumber.put(digit % 10, repeatingNumber.get(digit % 10) + 1);
                    }
                    digits.add(digit % 10);
                }
                digit /= 10;
            }
            if (sum > 9) {
                level++;
                sum = findSum(sum, level);
            } else {
                return sum;
            }

        }

        return sum;
    }

}
