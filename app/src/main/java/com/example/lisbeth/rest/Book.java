package com.example.lisbeth.rest;

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

//import static com.example.lisbeth.rest.R.id.surname;
public class Book extends AppCompatActivity {
    EditText editText1, editText2,editText3,editText4,editText5;

    Button button1;
    Spinner spinner;
    Contact contact;

    private DatabaseReference db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        editText1 = (EditText) findViewById(R.id.editText01);
        editText2 = (EditText) findViewById(R.id.editText2);
        editText3 = (EditText) findViewById(R.id.editText3);
        editText4 = (EditText) findViewById(R.id.editText4);
        editText5 = (EditText) findViewById(R.id.editText5);

        spinner= (Spinner)findViewById(R.id.spin);
        button1=(Button)findViewById(R.id.btn);
        db= FirebaseDatabase.getInstance().getReference("Contact");
    }
    public void next(View view) {
        contact = new Contact();
        contact.setName(editText1.getText().toString());
        contact.setSurname(editText2.getText().toString());
        contact.setTime(editText3.getText().toString());
        contact.setDate(editText4.getText().toString());
        contact.setCellNo(editText5.getText().toString());

        db.child("Contact").push().setValue(contact);

        EditText nameField=(EditText) findViewById(R.id .editText01);
        String names=nameField.getText().toString();

        EditText nameField1=(EditText) findViewById(R.id .editText2);
        String name=nameField1.getText().toString();

        AlertDialog.Builder dialog = new AlertDialog.Builder(Book.this);
        dialog.setTitle("Saved Successfully . You will hear from us soon");
        dialog.setMessage( "\n You are:" +names +" \n Surname "+name);

        dialog.setPositiveButton("More Information",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(Book.this, Fetching.class);
                startActivity(intent);
                //intent
                dialog.dismiss();
            }
        });
        dialog.setNegativeButton("Exit",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog,int which) {
                //closing finish
                dialog.dismiss();}
        });
        dialog.show();
    }}
