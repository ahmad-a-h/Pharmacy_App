package com.example.pharmacy;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;


public class create_acc extends AppCompatActivity {
EditText ed1,ed2,ed3;
Button button;
TextView tv;

int url=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_acc);
        ed1 = findViewById(R.id.first_name);
        ed2 = findViewById(R.id.last_name);
        ed3 = findViewById(R.id.password);
        button = findViewById(R.id.create);
        tv = findViewById(R.id.tvusername);
        Intent i = getIntent();


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //String url = "https://pharmacyappprojectdb.000webhostapp.com/pharmacy/create_acc.php/?f_name=" +f_name+ "&l_name"+l_name+"&password" +password;
                //String link = "https://pharmacyappprojectdb.000webhostapp.com/pharmacy/getonepharmacy.php?id=1";

                String f_name = ed1.getText().toString().trim();
                String l_name = ed2.getText().toString().trim();
                String password = ed3.getText().toString().trim();
                String myURL = ("https://pharmacyappprojectdb.000webhostapp.com/pharmacy/create_acc.php/?f_name=" + f_name + "&l_name=" + l_name + "&password=" + password);
                String URL =("https://pharmacyappprojectdb.000webhostapp.com/pharmacy/get_id.php/?f_name="+f_name) ;
                if(ed1.getText().toString().trim()!=null&ed2.getText().toString().trim()!=null&ed3.getText().toString().trim()!=null){

                    RequestQueue requestQueue = Volley.newRequestQueue(create_acc.this);
                    StringRequest stringRequest = new StringRequest(Request.Method.POST, myURL, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        ed1.setText("");
                        ed2.setText("");
                        ed3.setText("");
                        closeKeyboard();
                        Toast.makeText(create_acc.this,s,Toast.LENGTH_LONG).show();
                        StringRequest stRequest = new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                showMessage("YOUR ID IS ",response);

                            }
                        }, new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {

                            }
                        });requestQueue.add(stRequest);


                    }
                },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(create_acc.this, error.getMessage(), Toast.LENGTH_LONG).show();

                            }
                        });

                requestQueue.add(stringRequest);




                }




            }
        });



        }

    private void closeKeyboard() {
        View view = this.getCurrentFocus();

        // if nothing is currently
        // focus then this will protect
        // the app from crash
        if (view != null) {

            // now assign the system
            // service to InputMethodManager
            InputMethodManager manager
                    = (InputMethodManager)
                    getSystemService(
                            Context.INPUT_METHOD_SERVICE);
            manager
                    .hideSoftInputFromWindow(
                            view.getWindowToken(), 0);
        }
    }
    public void showMessage(String title,String message)
    {
        AlertDialog.Builder b=new AlertDialog.Builder(this);

        b.setCancelable(true);
        b.setTitle(title);
        b.setMessage(message);
        b.show();
    }
}






