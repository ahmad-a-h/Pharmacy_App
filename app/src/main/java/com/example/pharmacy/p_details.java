package com.example.pharmacy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class p_details extends AppCompatActivity {
TextView tve;
ImageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdetails);
        //tve=findViewById(R.id.tv);
        image=findViewById(R.id.imgV);
        Intent details=getIntent();
        
        int img_id=getIntent().getIntExtra("id",0);
        if(img_id==1)
        {
            image.setImageResource(R.drawable.panadol);
        }
        else if(img_id==2)
        {
            image.setImageResource(R.drawable.panadolextra);
        }
    }
}