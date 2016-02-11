package com.example.teja.signupapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    Button button_signup, button_cam,button_gal;

    EditText fname,lname,email,address,password;

    ImageView userImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fname = (EditText) findViewById(R.id.FneditText);
        lname = (EditText) findViewById(R.id.LneditText);
        email = (EditText) findViewById(R.id.EmeditText);
        address = (EditText) findViewById(R.id.AdeditText);
        password = (EditText) findViewById(R.id.PwdeditText);
        button_cam = (Button) findViewById(R.id.btn_photo);
        button_signup = (Button) findViewById(R.id.button);
        userImage = (ImageView) findViewById(R.id.view_photo);
        button_gal=(Button)findViewById(R.id.btn_gal);

    }


    public void onClickOfMapButton(View v)
    {
        Intent a = new Intent(MainActivity.this, MapActivity.class);
        startActivity(a);
    }

      public void onClickOfUploadButton(View v)
     {
    Intent c = new Intent(MainActivity.this,ImageGallery.class);
    startActivity(c);
     }
    public void onClickOfPhotoButton(View v)
    {
        Intent b = new Intent(MainActivity.this,PhotoActivity.class);
        startActivity(b);
    }

 }
