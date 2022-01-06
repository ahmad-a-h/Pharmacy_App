package com.example.pharmacy;
import android.content.Context;
import android.content.Intent;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;




public class create_acc extends AppCompatActivity {
EditText ed1,ed2,ed3;
Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_acc);
        ed1 = findViewById(R.id.first_name);
        ed2 = findViewById(R.id.last_name);
        ed3 = findViewById(R.id.password);
        button = findViewById(R.id.create);
        Intent i=getIntent();



        button.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {




            }
        });
    }





}


