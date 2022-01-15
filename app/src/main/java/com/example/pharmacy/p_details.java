package com.example.pharmacy;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

public class p_details extends AppCompatActivity {
TextView tve,tv;
ImageView image;
Button btn;
int buy=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdetails);
        tve=findViewById(R.id.tv);
        image=findViewById(R.id.imgV);
        //btn=findViewById(R.id.buy_btn);
        //btn2=findViewById(R.id.getnb);
        //tv=findViewById(R.id.nbs);
        Intent details=getIntent();

        int img_id=getIntent().getIntExtra("id",0);
        if(img_id==1)
        {
            image.setImageResource(R.drawable.panadol);
        }
        else if(img_id==2)
        {
            image.setImageResource(R.drawable.advil);
        }
        else if(img_id==3)
        {
            image.setImageResource(R.drawable.cardicheck);
        }
        else if(img_id==4)
        {
            image.setImageResource(R.drawable.vitaminc);
        }
        else if(img_id==5)
        {
            image.setImageResource(R.drawable.panadolextra);
        }



        RequestQueue queue = Volley.newRequestQueue(this);

        int ID=getIntent().getIntExtra("id",0);
        if(ID==1) {
            String url = "https://pharmacyappprojectdb.000webhostapp.com/pharmacy/getonepharmacy.php?id=1";

            JsonArrayRequest request = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
                @Override
                public void onResponse(JSONArray response) {
                    try {
                        JSONObject row = response.getJSONObject(0);
                        int id = row.getInt("id");
                        String name = row.getString("name");
                        int quantity = row.getInt("quantity");
                        double price = row.getDouble("price");

                        Product p = new Product(id, name, quantity, price);
                        tve.setText(p.toString());

                    } catch (Exception ex) {
                        Toast.makeText(p_details.this, "No records found", Toast.LENGTH_SHORT).show();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(p_details.this, error.toString(), Toast.LENGTH_SHORT).show();
                }
            });

            queue.add(request);
        }
        else if(ID==2) {
            String url = "https://pharmacyappprojectdb.000webhostapp.com/pharmacy/getonepharmacy.php?id=2";

            JsonArrayRequest request = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
                @Override
                public void onResponse(JSONArray response) {
                    try {
                        JSONObject row = response.getJSONObject(0);
                        int id = row.getInt("id");
                        String name = row.getString("name");
                        int quantity = row.getInt("quantity");
                        double price = row.getDouble("price");

                        Product p = new Product(id, name, quantity, price);
                        tve.setText(p.toString());

                    } catch (Exception ex) {
                        Toast.makeText(p_details.this, "No records found", Toast.LENGTH_SHORT).show();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(p_details.this, error.toString(), Toast.LENGTH_SHORT).show();
                }
            });

            queue.add(request);
        }

        else if(ID==3) {
            String url = "https://pharmacyappprojectdb.000webhostapp.com/pharmacy/getonepharmacy.php?id=3";

            JsonArrayRequest request = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
                @Override
                public void onResponse(JSONArray response) {
                    try {
                        JSONObject row = response.getJSONObject(0);
                        int id = row.getInt("id");
                        String name = row.getString("name");
                        int quantity = row.getInt("quantity");
                        double price = row.getDouble("price");

                        Product p = new Product(id, name, quantity, price);
                        tve.setText(p.toString());

                    } catch (Exception ex) {
                        Toast.makeText(p_details.this, "No records found", Toast.LENGTH_SHORT).show();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(p_details.this, error.toString(), Toast.LENGTH_SHORT).show();
                }
            });

            queue.add(request);
        }

        else if(ID==4) {
            String url = "https://pharmacyappprojectdb.000webhostapp.com/pharmacy/getonepharmacy.php?id=4";

            JsonArrayRequest request = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
                @Override
                public void onResponse(JSONArray response) {
                    try {
                        JSONObject row = response.getJSONObject(0);
                        int id = row.getInt("id");
                        String name = row.getString("name");
                        int quantity = row.getInt("quantity");
                        double price = row.getDouble("price");

                        Product p = new Product(id, name, quantity, price);
                        tve.setText(p.toString());

                    } catch (Exception ex) {
                        Toast.makeText(p_details.this, "No records found", Toast.LENGTH_SHORT).show();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(p_details.this, error.toString(), Toast.LENGTH_SHORT).show();
                }
            });

            queue.add(request);
        }

        else if(ID==5) {
            String url = "https://pharmacyappprojectdb.000webhostapp.com/pharmacy/getonepharmacy.php?id=5";

            JsonArrayRequest request = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
                @Override
                public void onResponse(JSONArray response) {
                    try {
                        JSONObject row = response.getJSONObject(0);
                        int id = row.getInt("id");
                        String name = row.getString("name");
                        int quantity = row.getInt("quantity");
                        double price = row.getDouble("price");

                        Product p = new Product(id, name, quantity, price);
                        tve.setText(p.toString());

                    } catch (Exception ex) {
                        Toast.makeText(p_details.this, "No records found", Toast.LENGTH_SHORT).show();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(p_details.this, error.toString(), Toast.LENGTH_SHORT).show();
                }
            });

            queue.add(request);
        }









    }


}