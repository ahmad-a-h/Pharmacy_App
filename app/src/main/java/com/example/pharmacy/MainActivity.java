package com.example.pharmacy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText ed1,ed2;
Button btn1,btn2,btn3;
TextView result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed1=findViewById(R.id.username);
        ed2=findViewById(R.id.pass);
        btn1=findViewById(R.id.login);
        btn2=findViewById(R.id.forget);
        btn3=findViewById(R.id.create);
        result=(TextView)findViewById(R.id.tvResult);
        Intent i=new Intent(this,create_acc.class);




        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent cur=getIntent();
                result.setText(i.getStringExtra("DATA"));

                //if(ed1.getText().toString()!=i.getStringExtra()))
                //{
                  //  ed1.setError("invalid username");
                 //   ed1.setTextColor(Color.RED);
                   // ed1.setText(null);
                  //  ed1.setHint(null);
                   // ed1.requestFocus();
               // }
               // if(ed2.getText().toString().trim().length()!=0)
               // {
                  //  ed1.setError("invalid password");
                   // ed1.setTextColor(Color.RED);
                   // ed1.setText(null);
                    //ed1.setHint(null);
                   // ed1.requestFocus();
              //  }

            }
        });






        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(i);


            }
        });






    }


}