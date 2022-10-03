package com.example.lianabsawi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {
    //first step in programming setting objects
    EditText Number1, Number2;
    Button buttonPlus, buttonMinus;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        //linking objects by id
        Number1 = findViewById(R.id.Number1);
        Number2 = findViewById(R.id.Number2);
        buttonPlus = findViewById(R.id.buttonPlus);
        buttonMinus = findViewById(R.id.buttonMinus);
        result = findViewById(R.id.result);
    }

    public void plus(View view) {
       if((Number1!=null) && (Number2!=null)){
           double num1 = Double.parseDouble(Number1.getText().toString());
           double num2 = Double.parseDouble(Number2.getText().toString());
           result.setText((num1+num2)+"");}
       else {
            result.setText("please try again");
       }

    }

    public void minus(View view) {
        double num1 = Double.parseDouble(Number1.getText().toString());
        double num2 = Double.parseDouble(Number2.getText().toString());

        result.setText((num1-num2)+"");
    }
}