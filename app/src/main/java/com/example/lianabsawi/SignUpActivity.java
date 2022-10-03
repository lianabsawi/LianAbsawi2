package com.example.lianabsawi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {
    private EditText email, password;
    private Button sign_up, cancel;

    SharedPreferences preferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        email= findViewById(R.id.Email);
        password = findViewById(R.id.signUp);
        sign_up= findViewById(R.id.buttonSignUp);
        cancel= findViewById(R.id.buttonCancel);

        preferences= getSharedPreferences("userinfo", 0);
    }


    public void signup(View view) {
        String input_mail = email.getText().toString();
        String input_password = password.getText().toString();
        if(input_mail.length()>0){

            //open preferences file
            SharedPreferences.Editor editor = preferences.edit();

            // save key, value data
            editor.putString("username", input_mail).commit();
            editor.putString("password", input_password).commit();

            editor.apply();
            Toast.makeText(this, "user registered", Toast.LENGTH_LONG).show();

            Intent intent_main = new Intent(this, MainActivity.class);
            startActivity(intent_main);
        }
        else
            Toast.makeText(this, "Empty values, please insert!", Toast.LENGTH_SHORT).show();
        }

    public void cancel(View view) {
        Intent intent_main = new Intent(this, MainActivity.class);
        startActivity(intent_main);
    }
}
