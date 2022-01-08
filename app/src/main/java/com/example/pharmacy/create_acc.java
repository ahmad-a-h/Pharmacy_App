package com.example.pharmacy;
import android.content.Context;
import android.content.Intent;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;


public class create_acc extends AppCompatActivity {
EditText ed1,ed2,ed3;
Button button;
int url=0;
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

                //String url = "https://pharmacyappprojectdb.000webhostapp.com/pharmacy/create_acc.php/?f_name=" +f_name+ "&l_name"+l_name+"&password" +password;
                //String link = "https://pharmacyappprojectdb.000webhostapp.com/pharmacy/getonepharmacy.php?id=1";

                String f_name = ed1.getText().toString().trim();
                String l_name = ed2.getText().toString().trim();
                String password = ed3.getText().toString().trim();
                String myURL=("https://pharmacyappprojectdb.000webhostapp.com/pharmacy/create_acc.php/?f_name=" +f_name+ "&l_name"+l_name+"&password" +password);




                StringRequest stringRequest = new StringRequest(Request.Method.POST, myURL, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        ed1.setText("");
                        ed2.setText("");
                        ed3.setText("");
                        Toast.makeText(create_acc.this,"ACCOUNT CREATED",Toast.LENGTH_LONG).show();
                    }
                },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(create_acc.this,error.getMessage(), Toast.LENGTH_LONG).show();

                            }
                        }) {

                };
                RequestQueue requestQueue = Volley.newRequestQueue(create_acc.this);
                requestQueue.add(stringRequest);






            }
        });











        }
    }






