package com.astrology.date.datecal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText startYear = (EditText) findViewById(R.id.start_year);
        final EditText endYear = (EditText) findViewById(R.id.end_year);
        final EditText date = (EditText) findViewById(R.id.date);
        final EditText name = (EditText) findViewById(R.id.name);
        Button op1 = (Button) findViewById(R.id.button);
        Button op2 = (Button) findViewById(R.id.button2);
        Button op3 = (Button) findViewById(R.id.button3);
        op1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("a", "onClick: "+startYear.getText().equals(null)+startYear.getText().toString().length());
                if(startYear.getText().toString().length()==0||endYear.getText().toString().length()==0){
                    Toast.makeText(MainActivity.this, "Start year or end year cannot be empty!", Toast.LENGTH_LONG).show();
                }else{
                    Intent intent = new Intent(MainActivity.this, Button1Activity.class);
                    intent.putExtra("startYear",startYear.getText().toString());
                    intent.putExtra("endYear",endYear.getText().toString());
                    startActivity(intent);
                }
            }
        });
        op2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("a", "onClick: "+startYear.getText().equals(null)+startYear.getText().toString().length());
                if(date.getText().toString().length()==0){
                    Toast.makeText(MainActivity.this, "Date cannot be empty!", Toast.LENGTH_LONG).show();
                }else{
                    Intent intent = new Intent(MainActivity.this, Button2Activity.class);
                    intent.putExtra("date",date.getText().toString());
                    startActivity(intent);
                }
            }
        });
        op3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("a", "onClick: "+startYear.getText().equals(null)+startYear.getText().toString().length());
                if(name.getText().toString().length()==0){
                    Toast.makeText(MainActivity.this, "Name cannot be empty!", Toast.LENGTH_LONG).show();
                }else{
                    Intent intent = new Intent(MainActivity.this, Button3Activity.class);
                    intent.putExtra("name",name.getText().toString());
                    startActivity(intent);
                }
            }
        });

    }

}
