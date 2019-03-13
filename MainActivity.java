package com.example.mario.pipeforce;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button button1;
    Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Locate the button on the activity_main.xml
        button1 = (Button)findViewById(R.id.deg90);//deg90 is the name of the button
        button2 = (Button)findViewById(R.id.varAng);//varAng is the name of the button

        //Capture button clicks
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Start the new activity
                Intent myIntent = new Intent(MainActivity.this, deg90.class);
                startActivity(myIntent);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Start the new activity
                Intent myIntent = new Intent(MainActivity.this, VariableAngle.class );
                startActivity(myIntent);
            }
        });



    }//onCreate brace
}//class brace

