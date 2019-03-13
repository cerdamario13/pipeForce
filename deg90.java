package com.example.mario.pipeforce;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class deg90 extends AppCompatActivity {

    //Decalring variables to use at beginning of operation
    EditText rho, diam, bbld, press;
    TextView vel, fX, fY, Result;
    Button btnDeg90;
    Button btnClear;


    //Variables that will be used for operations
    double numRho, numDiam, numBBLD, numPress, numFX, numFY, numResult;
    //numVel is an operation (converting BBLD to ft^3/s to ft/s

    //Variables used for calculations
    double Area;
    double QQ; //Volumetric flowrate
    double lbperft; //pounds per ft^2
    double Vel;
    double diamConvertion; //converting in to ft


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deg90);

        //beginning the calculation process. the double variables get the number from
        //the xml file.
        //Varables come from
        rho = (EditText)findViewById(R.id.txtRho);
        diam = (EditText)findViewById(R.id.txtDiam);
        bbld = (EditText)findViewById(R.id.txtBBLD);
        press = (EditText)findViewById(R.id.txtPress);

        btnDeg90 = (Button)findViewById(R.id.deg90Butt);
        vel = (TextView)findViewById(R.id.txtVel); //////////////////
        fX = (TextView)findViewById(R.id.txtFX);
        fY = (TextView)findViewById(R.id.txtFY);
        Result = (TextView)findViewById(R.id.txtRes);

        //clear button (Clears the entries in the EditTexts)
        btnClear = (Button)findViewById(R.id.clearButt);
        btnClear.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                rho.getText().clear();  bbld.getText().clear();
                diam.getText().clear(); press.getText().clear();
                //clearing TextViews
                TextView vel = (TextView)findViewById(R.id.txtVel); vel.setText(null);
                TextView fx = (TextView)findViewById(R.id.txtFX); fx.setText(null);
                TextView fy = (TextView)findViewById(R.id.txtFY); fy.setText(null);
                TextView Result = (TextView)findViewById(R.id.txtRes); Result.setText(null);
            }
        });//clear button brace

        //Giving Functionality to the button
        btnDeg90.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                numRho = Double.parseDouble(rho.getText().toString());
                numDiam = Double.parseDouble(diam.getText().toString());
                diamConvertion = numDiam/12;
                Area = Math.PI*(Math.pow(diamConvertion,2)/4);
                //Barrels to QQ
                numBBLD = Double.parseDouble(bbld.getText().toString());
                QQ = numBBLD*6.49836034*Math.pow(10,-5);
                //Pressure
                numPress = Double.parseDouble(press.getText().toString());
                lbperft = numPress*144;
                //Velocity
                Vel = QQ/Area;
                vel.setText(Double.toString(Vel));

               numFX = (Math.pow(Vel,2))*numRho*Area + lbperft*Area;
               fX.setText(Double.toString(Math.round(numFX)));

               numFY = (Math.pow(Vel,2))*numRho*Area + lbperft*Area;
               fY.setText(Double.toString(Math.round(numFY)));

               numResult = Math.sqrt(Math.pow(numFX,2) + Math.pow(numFY,2));
               Result.setText(Double.toString(Math.round(numResult)));




            }//onclick brace
        });//btnDeg90 brace
    }//onCreate brace
}//class brace
