package com.example.pharmacy;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class create_acc extends AppCompatActivity {
EditText ed1,ed2,ed3;
Button btn;
SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_acc);
        ed1=findViewById(R.id.first_name);
        ed2=findViewById(R.id.last_name);
        ed3=findViewById(R.id.password);
        btn=findViewById(R.id.create);
        db=openOrCreateDatabase("accountdb", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS pharmacy(fname VARCHAR,lname VARCHAR,password VARCHAR);");





    }

    //Message for a new created account
    public void showMessage(String title,String message)
    {
        AlertDialog.Builder b=new AlertDialog.Builder(this);

        b.setCancelable(true);
        b.setTitle(title);
        b.setMessage(message);
        b.show();


    }

    //creates an account
    public void create_acc(View view) {
       //checks if edit texts are empty
        if(ed1.getText().toString().trim().length()==0||
                ed2.getText().toString().trim().length()==0||
                ed3.getText().toString().trim().length()==0)
        {
            ed1.setError("Fill in all");
            ed1.setText(null);
            ed1.setHint(null);
            ed2.setError("Fill in all");
            ed2.setText(null);
            ed2.setHint(null);
            ed3.setError("Fill in all");
            ed3.setText(null);
            ed3.setHint(null);
            ed1.requestFocus();
            return;

        }

        Cursor c = db.rawQuery("SELECT * FROM pharmacy WHERE f_name='" + ed1.getText() + "'", null);
        if (c.getCount()>0) {
            showMessage("Error", "ID Already Exists");
            return;
        } else {

            db.execSQL("INSERT INTO pharmacy VALUES('" + ed1.getText() + "','" + ed2.getText() + "','" + ed3.getText() + "');");

            showMessage("Success", "Record added");


        }//end insert

        StringBuffer buffer=new StringBuffer();
        while(c.moveToNext())
        {
            buffer.append("fname: "+c.getString(0)+"\n");
            //buffer.append("lname: "+c.getString(1)+"\n");
            buffer.append("password: "+c.getString(2)+"\n\n");
        }

        //showMessage("Student Details", buffer.toString());
        Intent cur=new Intent(this,MainActivity.class);
        cur.putExtra("DATA",buffer.toString());
        //startActivity(cur);
    }


    public void selectAll()
    {
        Cursor c=db.rawQuery("SELECT * FROM pharmacy ", null);
        if(c.getCount()==0)
        {
            showMessage("Error", "No records found");
            return;
        }

        StringBuffer buffer=new StringBuffer();
        while(c.moveToNext())
        {
            buffer.append("first_name: "+c.getString(0)+"\n");
           // buffer.append("Name: "+c.getString(1)+"\n");
            buffer.append("password: "+c.getString(2)+"\n\n");
        }

        //showMessage("Student Details", buffer.toString());
        Intent cur=new Intent(this,MainActivity.class);
        cur.putExtra("DATA",buffer.toString());
        startActivity(cur);
    }//end selectAll



}