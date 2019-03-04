package com.startandroid.myapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity{
    EditText emailBox, passwordBox;
    Button loginButton;
    TextView register;
    String URL = "http://192.168.0.90:8080/JavaRESTfullWS/rest/DemoService/login";

    static String login="";
    static String password="";
    static String name="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailBox = (EditText)findViewById(R.id.emailBox);
        passwordBox = (EditText)findViewById(R.id.passwordBox);
        loginButton = (Button)findViewById(R.id.loginButton);
        register = (TextView)findViewById(R.id.registerLink);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringRequest request = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>(){
                    @Override
                    public void onResponse(String s) {
                        if(s.equals("false")){
                            Toast.makeText(MainActivity.this, "Incorrect Details", Toast.LENGTH_LONG).show();
                        }else{
                            login = emailBox.getText().toString();
                            password = passwordBox.getText().toString();
                            name = s;
                            Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_LONG).show();
                            startActivity(new Intent(MainActivity.this, ShopPage.class));
                        }
                    }
                },new Response.ErrorListener(){
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        Toast.makeText(MainActivity.this, "Some error occurred -> "+volleyError, Toast.LENGTH_LONG).show();;
                    }
                }) {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> parameters = new HashMap<String, String>();
                        parameters.put("email", emailBox.getText().toString());
                        parameters.put("password", passwordBox.getText().toString());
                        return parameters;
                    }
                };

                RequestQueue rQueue = Volley.newRequestQueue(MainActivity.this);
                rQueue.add(request);
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Register.class));
            }
        });
    }
}