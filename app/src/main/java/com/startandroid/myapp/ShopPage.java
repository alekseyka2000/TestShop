package com.startandroid.myapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.w3c.dom.Text;

import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

public class ShopPage extends AppCompatActivity {

    String URL = "http://192.168.0.90:8080/JavaRESTfullWS/rest/DemoService/enter";;

    TextView tvName, tvContinue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_page);

        tvName = (TextView)findViewById(R.id.textView);
        tvContinue = (TextView)findViewById(R.id.textView2);

        tvName.setText("Welcome "+MainActivity.name+"!");
    }
}
