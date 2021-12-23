package com.example.pharmacy;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class item_details extends AppCompatActivity {
    TextView text;
    Button btn;
    ImageView image;
    int index;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.itemdetails);



        image=(ImageView) findViewById(R.id.imgV);

        text=(TextView) findViewById(R.id.tv1);

        text=(TextView) findViewById(R.id.tv2);

        text=(TextView) findViewById(R.id.tv3);

        btn=(Button) findViewById(R.id.btn1);


        Intent i=getIntent();
        Toast.makeText(this, "HELLO", Toast.LENGTH_LONG).show();
        index=i.getIntExtra("POSITION",0);


    }

}
