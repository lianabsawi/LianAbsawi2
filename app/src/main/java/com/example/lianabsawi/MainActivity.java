package com.example.lianabsawi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText editTextPasswordInSignUp, editTextEmail;
    private Button buttonLogIn, buttonSignUp;

    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPasswordInSignUp = findViewById(R.id.editTextPasswordInSignUp);
        buttonLogIn = findViewById(R.id.buttonLogIn);
        buttonSignUp = findViewById(R.id.buttonSignUp);

        preferences = getSharedPreferences("Userinfo", 0);
    }

    // sign up
    public void moveToSignUp(View view) {
        Intent i_signup= new Intent(this, SignUpActivity.class);
        startActivity(i_signup);
    }


    //menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_example, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.help_menu:
                Intent i = new Intent(MainActivity.this, ListActivity.class);
                startActivity(i);
                break;
            case R.id.settings_menu:
                Toast.makeText(MainActivity.this, "settings clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.logout_menu:
                Toast.makeText(MainActivity.this, "logout clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.home_menu:
                Toast.makeText(MainActivity.this, "Home clicked", Toast.LENGTH_SHORT).show();


        }
        return true;
    }


    //Dialog
    @Override
    public void onBackPressed() {
        AlertDialog.Builder dialog= new AlertDialog.Builder(this);
        dialog.setTitle("Back button was pressed!");
        dialog.setMessage("Are you sure you want to Exit?");
        //in case the user chose no nothing happens and the dialog closes
        dialog.setNegativeButton("No", null);
        //when the user clicks on yes the application closes
        dialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                MainActivity.this.finish();
            }
        });
        dialog.setIcon(R.drawable.ic_baseline_tag_faces_24);
        AlertDialog alertDialog= dialog.create();
        alertDialog.show();
    }

    //log in
    public void login(View view) {
        String input_mail = editTextEmail.getText().toString();
        String input_password = editTextPasswordInSignUp.getText().toString();

    // this line gets registered email and password, in case no user wqs registered empty string is returned
        String registeredMail = preferences.getString("username", "");
        String registeredPassword = preferences.getString("password", "");

    //check if the usernames are equal, if yes
        if(input_mail.equals(registeredMail) && input_password.equals(registeredPassword)){
            Intent i_mail = new Intent(this, HomeActivity.class);
            startActivity(i_mail);
        }

        else{
            Toast.makeText(this, "incorrect credentials!", Toast.LENGTH_SHORT).show();}
    }

}