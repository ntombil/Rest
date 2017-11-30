package com.example.lisbeth.rest;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import okhttp3.OkHttpClient;

import static com.example.lisbeth.rest.R.id.editText5;

public class Hire extends AppCompatActivity {
    EditText editText1, editText2,editText3,editText4;
    Button button1;
    Contact contact;
    private DatabaseReference db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hire);
        editText1 = (EditText) findViewById(R.id.graveyard);
        editText2 = (EditText) findViewById(R.id.name);
        editText3 = (EditText) findViewById(R.id.timeW);
        editText4 = (EditText) findViewById(R.id.Place);


        db= FirebaseDatabase.getInstance().getReference("Contact");

    }
    public  void  me(View view){
        contact = new Contact();
        contact.setName(editText1.getText().toString());
        contact.setSurname(editText2.getText().toString());
        contact.setTime(editText3.getText().toString());
        contact.setDate(editText4.getText().toString());

        EditText nameField=(EditText) findViewById(R.id .Place);
        String names=nameField.getText() .toString();

        EditText nameField1=(EditText) findViewById(R.id .timeW);
        String name=nameField1.getText().toString();

        db.child("Contact").push().setValue(contact);

        AlertDialog.Builder dialog = new AlertDialog.Builder(Hire.this);
        dialog.setTitle("May your soul REST IN PEACE");
        dialog.setMessage( "\n He/She will be  buried at:" + names +" \n Time: "+name+ "\n You will be remembered:)");


        dialog.setPositiveButton("Send An SMS",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(Hire.this, Societies.class);
                startActivity(intent);
                //intent
                dialog.dismiss();
            }
        });

        dialog.setNegativeButton("Exit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //closing finish
                dialog.dismiss();
            }
        });

        dialog.show();


    }
    }

