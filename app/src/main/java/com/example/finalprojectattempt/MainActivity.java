package com.example.finalprojectattempt;

import android.Manifest;
import android.app.DownloadManager;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.media.Image;
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
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_COARSE_LOCATION = 88;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.board);

        final TextView weather = findViewById(R.id.weather);

        class Identity<T> {
            T t;
            T get() { return t; }
            void put(T setT) { t = setT; }
        }

        boolean canAccessCoarseLocation =
                checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED;
        if (!canAccessCoarseLocation) {
            requestPermissions(new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, REQUEST_COARSE_LOCATION);
        }

        final Identity<Double> latitude = new Identity<>();
        final Identity<Double> longitude = new Identity<>();


        FusedLocationProviderClient fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
        fusedLocationClient.getLastLocation()
                .addOnSuccessListener(this, new OnSuccessListener<Location>() {
                    @Override
                    public void onSuccess(Location location) {
                        // Got last known location. In some rare situations this can be null.
                        if (location != null) {
                            // Logic to handle location object
                            latitude.put(location.getLatitude());
                            longitude.put(location.getLongitude());
                        }
                    }
                });

        latitude.put(40.10);
        longitude.put(-88.23);

        final String errorMessage = "Sunny and 70 degrees";
        String key = "37bfaa968cb61464140b0506164f63f0";
        String url = "https://api.openweathermap.org/data/2.5/weather?lat=" + latitude.get() + "&lon=" + longitude.get() + "&units=imperial&APPID=" + key;

        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                JsonParser parser = new JsonParser();
                JsonObject result = parser.parse(response).getAsJsonObject();
                try {
                    String city = result.get("name").getAsString();
                    String country = result.getAsJsonObject("sys").get("country").getAsString();
                    Object description = result.getAsJsonArray("weather").get(0).getAsJsonObject().get("main").getAsString();
                    long temp = Math.round(result.getAsJsonObject("main").get("temp").getAsDouble());
                    long visibility = Math.round(result.get("visibility").getAsDouble() / 1609);
                    long pressure = Math.round(result.getAsJsonObject("main").get("pressure").getAsDouble() / 33.86);
                    String output = city + ", " + country
                            + "\n" + description
                            + "\nTemperature: " + temp + "˚F"
                            + "\nVisibility: " + visibility + " mi"
                            + "\nPressure: " + pressure + " inHg";
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

        ImageView A2 = findViewById(R.id.row1col0);
        ImageView A4 = findViewById(R.id.row3col0);
        move(R.drawable.white_pawn, A2, A4);

    }

    public void move(int piece, ImageView from, ImageView to) {
        to.setImageResource(piece);
        from.setImageResource(R.drawable.transparent);
    }
    ImageView row0Co
}
