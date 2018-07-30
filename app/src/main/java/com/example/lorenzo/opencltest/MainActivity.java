package com.example.lorenzo.opencltest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

import static com.example.lorenzo.opencltest.R.id.vect_A_in;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Example of a call to a native method
        //TextView tv = (TextView) findViewById(R.id.sample_text);
        //tv.setText(stringFromJNI());
    }

    ///**
    // * A native method that is implemented by the 'native-lib' native library,
    // * which is packaged with this application.
    // */
    //public native String stringFromJNI();

    //Callback to generation buttons
    public void generateVectorA(View view){
        generateVector("A");
    }

    public void generateVectorB(View view){
        generateVector("B");
    }

    //Get vector dimension
    public int getVectorDimension(){
        EditText dim_tv = (EditText) findViewById(R.id.dimension_input);
        return Integer.parseInt(dim_tv.getText().toString());
    }

    //Generate and display random vector
    public void generateVector(String vectName){
        int dim = getVectorDimension();
        EditText editText;
        if(vectName.equals("A"))
            editText = (EditText) findViewById(R.id.vect_A_in);
        else{
            editText = (EditText) findViewById(R.id.vect_B_in);
        }
        editText.setText(createRandomArray(dim));

    }

    /**
     * Generate a random vector
     * @param dimension of the array to be generated
     */
    public String createRandomArray(int dimension) {
        v_min = 1;
        v_max = 10;
        int[] vect = new int[dimension];
        for(int i = 0; i<dimension; i++){
            Random r = new Random();
            vect[i] = r.nextInt((v_max - v_min) + 1) + v_min;
        }
        //To string
        StringBuilder sb = new StringBuilder(",");
        for(int i = 0; i<dimension; i++){
            sb.append(vect[i]);
            sb.append(", ");
        }
        return sb.toString();
    }
}
