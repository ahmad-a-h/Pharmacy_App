package com.example.pharmacy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

//Ahmad loute
public class forget extends AppCompatActivity {
EditText i_d,pass;
Button btn1;
TextView set;
int count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget);
        i_d=findViewById(R.id.edid);
        pass=findViewById(R.id.passw);
        btn1=findViewById(R.id.reset);
        set=findViewById(R.id.textView);
        Intent GET=getIntent();


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Id=i_d.getText().toString().trim();
                String n = pass.getText().toString().trim();
                String url=("https://pharmacyappprojectdb.000webhostapp.com/pharmacy/forget_pass.php/?id="+Id);
                RequestQueue req= Volley.newRequestQueue(forget.this);
                StringRequest st=new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        int ln= n.length();
                        int lres = response.length();
                        if (ln < lres){
                            for(int i=0;i<n.length();i++)
                            {
                                for(int j=0;j<response.length();j++)
                                {
                                    if(n.charAt(i) == response.charAt(j))
                                    {
                                        count++;
                                    }
                                }
                            }
                        }
                        if (ln > lres) {
                            for (int i = 0; i < response.length(); i++) {
                                for (int j = 0; j < n.length(); j++) {
                                    if (n.charAt(i) == response.charAt(j)) {
                                        count++;
                                    }
                                }
                            }
                        }

                        if(count>=3)
                        {
                            showMessage("Your Password is", response);
                            //Toast.makeText(forget.this,response,Toast.makeText())
                        }

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }
                );req.add(st);
            }
        });







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
