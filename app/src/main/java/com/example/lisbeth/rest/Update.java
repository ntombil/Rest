package com.example.lisbeth.rest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Update extends AppCompatActivity {
    EditText editText,editText2, editText3,editText4, editText5,editText6;
    Button update;
    private DatabaseReference db;
    private DatabaseReference dbWrites;
    Contact contact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        editText=(EditText)findViewById(R.id.editText);
        editText2=(EditText)findViewById(R.id.editText5);
        editText3=(EditText)findViewById(R.id.editText01);
        editText4=(EditText)findViewById(R.id.editText2);
        editText5=(EditText)findViewById(R.id.editText3);
        editText6=(EditText)findViewById(R.id.editText4);

        update= (Button) findViewById(R.id.btn);

        Intent intent=getIntent();
        String key=intent.getStringExtra("Madubaduba");

        db = FirebaseDatabase.getInstance().getReference().child("Contact").child("Contact").child(key);
        dbWrites = FirebaseDatabase.getInstance().getReference().child("Contact").child("Contact").child(key);
        db.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                final Contact contact=dataSnapshot.getValue(Contact.class) ;
                editText.setText(contact.getName());
                editText2.setText(contact.getSurname());
                editText3.setText(contact.getDate());
                editText4.setText(contact.getCellNo());
                editText5.setText(contact.getDeceasedName());
                editText6.setText(contact.getTime());

                update.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        contact.setName((editText.getText().toString()));
                        contact.setSurname((editText2.getText().toString()));
                        contact.setDate(editText3.getText().toString());
                        contact.setCellNo((editText4.getText().toString()));
                        contact.setDeceasedName((editText5.getText().toString()));
                        contact.setTime((editText6.getText().toString()));
                        dbWrites.setValue(contact);
                    }} );
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}
