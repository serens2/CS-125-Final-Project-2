package com.example.finalprojectattempt;

import android.app.DownloadManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class MainActivity extends AppCompatActivity {
//hello
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.board);

        final TextView weather = findViewById(R.id.weather);

        final String errorMessage = "Sunny and 70 degrees";
        double latitude = 40.104711;
        double longitude = -88.2272431;
        String key = "37bfaa968cb61464140b0506164f63f0";
        String url = "https://api.openweathermap.org/data/2.5/weather?lat=" + latitude + "&lon=" + longitude + "&units=imperial&APPID=" + key;

        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                JsonParser parser = new JsonParser();
                JsonObject result = parser.parse(response).getAsJsonObject();
                try {
                    String city = result.get("name").getAsString();
                    String country = result.getAsJsonObject("sys").get("country").getAsString();
                    String temp = result.getAsJsonObject("main").get("temp").getAsString();
                    String output = city + ", " + country + "\nTemperature: " + temp + "˚F";
                    weather.setText(output);
                } catch (Exception e) {
                    weather.setText(errorMessage);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                weather.setText(errorMessage);
            }
        });
        queue.add(stringRequest);
    }
}
