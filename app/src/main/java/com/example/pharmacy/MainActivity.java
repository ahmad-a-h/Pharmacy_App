package com.example.pharmacy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {
EditText ed1,ed2;
Button btn1,fort,btn3;
TextView result;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed1=findViewById(R.id.username);
        ed2=findViewById(R.id.pass);
        btn1=findViewById(R.id.login);
        fort=findViewById(R.id.forget);
        btn3=findViewById(R.id.create);
        result=(TextView)findViewById(R.id.tvResult);
        Intent i=new Intent(this,create_acc.class);
        Intent n=new Intent(this,items.class);
        Intent GET=new Intent(this,forget.class);




        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id=ed1.getText().toString().trim();
                String password=ed2.getText().toString().trim();
                String URL=("https://pharmacyappprojectdb.000webhostapp.com/pharmacy/get_id_password.php/?id="+id+"&password="+password);
                //String URL=("https://pharmacyappprojectdb.000webhostapp.com/pharmacy/get_id_password.php/?id=22&password=13");


                RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
                StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        ed1.setText("");
                        ed2.setText("");
                        //closeKeyboard();
                        if(s.equals("confirmed"))
                        {
                            startActivity(n);
                        }
                        else
                        {
                            Toast.makeText(MainActivity.this, "username or password is incorrect", Toast.LENGTH_LONG).show();
                        }




                    }
                },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_LONG).show();


                            }
                        });

                requestQueue.add(stringRequest);


            }
        });


        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(i);
            }
        });

        fort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(GET);
            }
        });

    }


}


