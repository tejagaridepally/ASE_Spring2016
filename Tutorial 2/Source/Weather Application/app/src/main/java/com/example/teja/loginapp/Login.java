package com.example.teja.loginapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Intent;


public class Login extends AppCompatActivity {


    private static EditText username;
    private static EditText password;
    private static Button login_button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        LoginButton();
       // Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
       // setSupportActionBar(toolbar);

        //FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        //fab.setOnClickListener(new View.OnClickListener() {
           // @Override
           // public void onClick(View view) {
               // Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                       // .setAction("Action", null).show();
          //  }
       // });
    }
public void LoginButton() {

    username = (EditText) findViewById(R.id.editText__user);
    password = (EditText) findViewById(R.id.editText_password);
    login_button = (Button) findViewById(R.id.button_login);

    login_button.setOnClickListener(new View.OnClickListener() {

                                        public void onClick(View v) {
                                            if (username.getText().toString().equals("teja") &
                                            password.getText().toString().equals("password"))
                                            {
                                                Toast.makeText(Login.this, "Username and password is correct",
                                                        Toast.LENGTH_SHORT).show();
                                                Intent intent = new Intent("com.example.teja.loginapp.WeatherActivity");
                                                startActivity(intent);
                                            }
                                            else
                                            {
                                                Toast.makeText(Login.this, "Username and password incorrect", Toast.LENGTH_SHORT).show();
                                            }
                                        }
                                    }
    );
}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}