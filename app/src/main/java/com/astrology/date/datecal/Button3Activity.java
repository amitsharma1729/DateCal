package com.astrology.date.datecal;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

public class Button3Activity extends AppCompatActivity {

    static Map<Character, Integer> alphabets = new HashMap<>();

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        alphabets.clear();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button3);
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        TextView result = (TextView) findViewById(R.id.result3);

        alphabets.put('A', 1);
        alphabets.put('a', 1);
        alphabets.put('J', 1);
        alphabets.put('j', 1);
        alphabets.put('Y', 1);
        alphabets.put('y', 1);
        alphabets.put('Q', 1);
        alphabets.put('q', 1);
        alphabets.put('I', 1);
        alphabets.put('i', 1);
        alphabets.put('B', 1);
        alphabets.put('b', 2);
        alphabets.put('R', 2);
        alphabets.put('r', 2);
        alphabets.put('K', 2);
        alphabets.put('k', 2);
        alphabets.put('C', 3);
        alphabets.put('c', 3);
        alphabets.put('S', 3);
        alphabets.put('s', 3);
        alphabets.put('G', 3);
        alphabets.put('g', 3);
        alphabets.put('L', 3);
        alphabets.put('l', 3);
        alphabets.put('D', 4);
        alphabets.put('d', 4);
        alphabets.put('T', 4);
        alphabets.put('t', 4);
        alphabets.put('M', 4);
        alphabets.put('m', 4);
        alphabets.put('E', 5);
        alphabets.put('e', 5);
        alphabets.put('X', 5);
        alphabets.put('x', 5);
        alphabets.put('N', 5);
        alphabets.put('n', 5);
        alphabets.put('H', 5);
        alphabets.put('h', 5);
        alphabets.put('U', 5);
        alphabets.put('u', 6);
        alphabets.put('V', 6);
        alphabets.put('v', 6);
        alphabets.put('W', 6);
        alphabets.put('w', 6);
        alphabets.put('O', 7);
        alphabets.put('o', 7);
        alphabets.put('Z', 7);
        alphabets.put('z', 7);
        alphabets.put('F', 8);
        alphabets.put('f', 8);
        alphabets.put('P', 8);
        alphabets.put('p', 8);

        int sum = findNameSum(name);
        result.append("Sum of the name "+name+":");
        result.append(System.getProperty("line.separator"));
        result.append(String.valueOf(sum));
    }

    public int findNameSum(String name) {
        int sum = 0, temp=0;
        for(int i=0; i<name.length(); i++) {
            try {
                sum+=alphabets.get(name.charAt(i));
            }
            catch(Exception exe) {

            }
        }
        sum = findSumPlaneVanilla(sum);
        return sum;
    }

    public int findSumPlaneVanilla(int digit) {
        int sum = 0;
        if(digit<10) {
            return digit;
        }else {
            while(digit>0) {
                sum += digit%10;
                digit/=10;
            }
            if(sum>9) {
                sum = findSumPlaneVanilla(sum);
            }
            else {
                return sum;
            }
        }
        return sum;
    }

}
