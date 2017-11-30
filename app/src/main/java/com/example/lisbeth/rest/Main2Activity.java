package com.example.lisbeth.rest;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class Main2Activity extends AppCompatActivity {

    @Override
    public void onOptionsMenuClosed(Menu menu) {


        super.onOptionsMenuClosed(menu);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2ctivity);


    }
    public  void  book(View view) {
        Intent intent = new Intent(Main2Activity.this, Book.class);
        startActivity(intent);
    }

}

