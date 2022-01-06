package com.example.pharmacy;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class items extends AppCompatActivity {
ListView ls;
ImageButton image,image2;
int img_id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items);
        ls = findViewById(R.id.lstv);
        image=findViewById(R.id.img1);
        image2=findViewById(R.id.img2);

        Intent n=getIntent();
        ArrayList<Product> products = new ArrayList<Product>();

        ArrayAdapter<Product> adapter = new ArrayAdapter<Product>(this, android.R.layout.simple_list_item_1,products);
        ls.setAdapter(adapter);


        RequestQueue queue  = Volley.newRequestQueue(this);

        String url = "https://pharmacyappprojectdb.000webhostapp.com/pharmacy/getpharmacy.php";

        JsonArrayRequest request = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0;i < response.length();i++) {
                    try {
                        JSONObject row = response.getJSONObject(i);

                        int id = row.getInt("id");
                        String name = row.getString("name");
                        int quantity = row.getInt("quantity");
                        double price = row.getInt("price");
                        //String category = row.getString("category");

                        Product p=new Product(id, name, quantity, price);
                        products.add(p);

                    }
                    catch (Exception ex) {
                        Toast.makeText(items.this, "error", Toast.LENGTH_SHORT).show();
                    }
                }
                adapter.notifyDataSetChanged();
            }
        }, null);

        queue.add(request);









    }


    public void open(View view) {
        Intent details=new Intent(this,p_details.class);
        img_id=1;
        details.putExtra("id",img_id);
        startActivity(details);

    }

    public void open2(View view) {
        Intent details=new Intent(this,p_details.class);
        img_id=2;
        details.putExtra("id",img_id);
        startActivity(details);
    }
}