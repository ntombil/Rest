package com.example.lisbeth.rest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Orbituaries extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orbituaries);


    }
public void orbit(View view){
Intent intent= new Intent(Orbituaries.this,InfoOrbirtuaries.class);
    startActivity(intent);

}

}
