package com.astrology.date.datecal;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Button1Activity extends AppCompatActivity {

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
        setContentView(R.layout.activity_button1);
        Intent intent = getIntent();
        String startYear = intent.getStringExtra("startYear");
        String endYear = intent.getStringExtra("endYear");
        TextView result = (TextView) findViewById(R.id.result1);

        int lastDayOfMonth, dayNoCal, monthNoCal, yearNoCal, level, classifiedNo1, classifiedNo2, finalNo;
        String classifiedNo;
        Map<String, ArrayList> dateSets = new HashMap<>();
        boolean isNumRepeating;
        for (int yearNo = Integer.parseInt(startYear); yearNo <= Integer.parseInt(endYear); yearNo++) {
            for (int monthNo = 1; monthNo <= 12; monthNo++) {
                if (monthNo == 2) {
                    if (yearNo % 400 == 0) {
                        lastDayOfMonth = 29;
                    } else if (yearNo % 100 == 0) {
                        lastDayOfMonth = 28;
                    } else if (yearNo % 4 == 0) {
                        lastDayOfMonth = 29;
                    } else {
                        lastDayOfMonth = 28;
                    }
                } else {

                    if (monthNo > 7) {
                        if (monthNo % 2 == 0) {
                            lastDayOfMonth = 31;
                        } else {
                            lastDayOfMonth = 30;
                        }
                    } else {
                        if (monthNo % 2 == 0) {
                            lastDayOfMonth = 30;
                        } else {
                            lastDayOfMonth = 31;
                        }
                    }

                }

                for (int dayNo = 1; dayNo <= lastDayOfMonth; dayNo++) {

                    dayNoCal = dayNo;
                    monthNoCal = monthNo;
                    yearNoCal = yearNo;

                    level = 1;
                    digits.clear();
                    isNumRepeating = false;
                    //System.out.println("dayno: " + dayNo + " month no: " + monthNo + " year no : " + yearNo);
                    dayNoCal = findSum(dayNoCal, level);
                    monthNoCal = findSum(monthNoCal, level);
                    yearNoCal = findSum(yearNoCal, level);
                    // System.out.println("date: "+date+" mont: "+month+" year: "+year);
                    digits.add(dayNoCal);
                    digits.add(monthNoCal);
                    digits.add(yearNoCal);
                    classifiedNo1 = dayNoCal;
                    finalNo = findSum(dayNoCal + monthNoCal + yearNoCal, level + 1);
                    digits.add(finalNo);
                    classifiedNo2 = finalNo;
                    for (int i = 1; i < 10; i++) {
                        if (!digits.contains(i)) {
                            isNumRepeating = true;
                        }
                    }
                    if (isNumRepeating) {

                    } else {
                        classifiedNo = classifiedNo1 + "," + classifiedNo2;
                        if(dateSets.get(classifiedNo)==null){
                            dateSets.put(classifiedNo, new ArrayList<>());
                        }
                        dateSets.get(classifiedNo).add(dayNo + ":" + monthNo + ":" + yearNo);
                    }

                }
            }
        }
        if (dateSets.isEmpty()) {
            result.append("No data found in the specified time period");
        }
        for (Map.Entry<String, ArrayList> ee : dateSets.entrySet()) {
            String key = ee.getKey();
            ArrayList values = ee.getValue();
            result.append("(" + key + ")");
            result.append(System.getProperty("line.separator"));
            result.append(values.toString());
            result.append(System.getProperty("line.separator"));
            result.append(System.getProperty("line.separator"));
            //System.out.println("(" + key + ")");
            //System.out.println(values);
        }
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

