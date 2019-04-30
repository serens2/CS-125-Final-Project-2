package com.example.finalprojectattempt;

import android.Manifest;
import android.app.DownloadManager;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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
    private ImageView from;
    private int fromId;
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

        final ImageView A1 = findViewById(R.id.row0col0);
        final ImageView A2 = findViewById(R.id.row0col1);
        final ImageView A3 = findViewById(R.id.row0col2);
        final ImageView A4 = findViewById(R.id.row0col3);
        final ImageView A5 = findViewById(R.id.row0col4);
        final ImageView A6 = findViewById(R.id.row0col5);
        final ImageView A7 = findViewById(R.id.row0col6);
        final ImageView A8 = findViewById(R.id.row0col7);

        final ImageView B1 = findViewById(R.id.row1col0);
        final ImageView B2 = findViewById(R.id.row1col1);
        final ImageView B3 = findViewById(R.id.row1col2);
        final ImageView B4 = findViewById(R.id.row1col3);
        final ImageView B5 = findViewById(R.id.row1col4);
        final ImageView B6 = findViewById(R.id.row1col5);
        final ImageView B7 = findViewById(R.id.row1col6);
        final ImageView B8 = findViewById(R.id.row1col7);

        final ImageView C1 = findViewById(R.id.row2col0);
        final ImageView C2 = findViewById(R.id.row2col1);
        final ImageView C3 = findViewById(R.id.row2col2);
        final ImageView C4 = findViewById(R.id.row2col3);
        final ImageView C5 = findViewById(R.id.row2col4);
        final ImageView C6 = findViewById(R.id.row2col5);
        final ImageView C7 = findViewById(R.id.row2col6);
        final ImageView C8 = findViewById(R.id.row2col7);

        final ImageView D1 = findViewById(R.id.row3col0);
        final ImageView D2 = findViewById(R.id.row3col1);
        final ImageView D3 = findViewById(R.id.row3col2);
        final ImageView D4 = findViewById(R.id.row3col3);
        final ImageView D5 = findViewById(R.id.row3col4);
        final ImageView D6 = findViewById(R.id.row3col5);
        final ImageView D7 = findViewById(R.id.row3col6);
        final ImageView D8 = findViewById(R.id.row3col7);

        final ImageView E1 = findViewById(R.id.row4col0);
        final ImageView E2 = findViewById(R.id.row4col1);
        final ImageView E3 = findViewById(R.id.row4col2);
        final ImageView E4 = findViewById(R.id.row4col3);
        final ImageView E5 = findViewById(R.id.row4col4);
        final ImageView E6 = findViewById(R.id.row4col5);
        final ImageView E7 = findViewById(R.id.row4col6);
        final ImageView E8 = findViewById(R.id.row4col7);

        final ImageView F1 = findViewById(R.id.row5col0);
        final ImageView F2 = findViewById(R.id.row5col1);
        final ImageView F3 = findViewById(R.id.row5col2);
        final ImageView F4 = findViewById(R.id.row5col3);
        final ImageView F5 = findViewById(R.id.row5col4);
        final ImageView F6 = findViewById(R.id.row5col5);
        final ImageView F7 = findViewById(R.id.row5col6);
        final ImageView F8 = findViewById(R.id.row5col7);

        final ImageView G1 = findViewById(R.id.row6col0);
        final ImageView G2 = findViewById(R.id.row6col1);
        final ImageView G3 = findViewById(R.id.row6col2);
        final ImageView G4 = findViewById(R.id.row6col3);
        final ImageView G5 = findViewById(R.id.row6col4);
        final ImageView G6 = findViewById(R.id.row6col5);
        final ImageView G7 = findViewById(R.id.row6col6);
        final ImageView G8 = findViewById(R.id.row6col7);

        final ImageView H1 = findViewById(R.id.row7col0);
        final ImageView H2 = findViewById(R.id.row7col1);
        final ImageView H3 = findViewById(R.id.row7col2);
        final ImageView H4 = findViewById(R.id.row7col3);
        final ImageView H5 = findViewById(R.id.row7col4);
        final ImageView H6 = findViewById(R.id.row7col5);
        final ImageView H7 = findViewById(R.id.row7col6);
        final ImageView H8 = findViewById(R.id.row7col7);

        A1.setTag(R.drawable.white_rook);
        A2.setTag(R.drawable.white_knight);
        A3.setTag(R.drawable.white_bishop);
        A4.setTag(R.drawable.white_queen);
        A5.setTag(R.drawable.white_king);
        A6.setTag(R.drawable.white_bishop);
        A7.setTag(R.drawable.white_knight);
        A8.setTag(R.drawable.white_rook);

        B1.setTag(R.drawable.white_pawn);
        B2.setTag(R.drawable.white_pawn);
        B3.setTag(R.drawable.white_pawn);
        B4.setTag(R.drawable.white_pawn);
        B5.setTag(R.drawable.white_pawn);
        B6.setTag(R.drawable.white_pawn);
        B7.setTag(R.drawable.white_pawn);
        B8.setTag(R.drawable.white_pawn);

        C1.setTag(R.drawable.transparent);
        C2.setTag(R.drawable.transparent);
        C3.setTag(R.drawable.transparent);
        C4.setTag(R.drawable.transparent);
        C5.setTag(R.drawable.transparent);
        C6.setTag(R.drawable.transparent);
        C7.setTag(R.drawable.transparent);
        C8.setTag(R.drawable.transparent);

        D1.setTag(R.drawable.transparent);
        D2.setTag(R.drawable.transparent);
        D3.setTag(R.drawable.transparent);
        D4.setTag(R.drawable.transparent);
        D5.setTag(R.drawable.transparent);
        D6.setTag(R.drawable.transparent);
        D7.setTag(R.drawable.transparent);
        D8.setTag(R.drawable.transparent);

        E1.setTag(R.drawable.transparent);
        E2.setTag(R.drawable.transparent);
        E3.setTag(R.drawable.transparent);
        E4.setTag(R.drawable.transparent);
        E5.setTag(R.drawable.transparent);
        E6.setTag(R.drawable.transparent);
        E7.setTag(R.drawable.transparent);
        E8.setTag(R.drawable.transparent);

        F1.setTag(R.drawable.transparent);
        F2.setTag(R.drawable.transparent);
        F3.setTag(R.drawable.transparent);
        F4.setTag(R.drawable.transparent);
        F5.setTag(R.drawable.transparent);
        F6.setTag(R.drawable.transparent);
        F7.setTag(R.drawable.transparent);

        G1.setTag(R.drawable.black_pawn);
        G2.setTag(R.drawable.black_pawn);
        G3.setTag(R.drawable.black_pawn);
        G4.setTag(R.drawable.black_pawn);
        G5.setTag(R.drawable.black_pawn);
        G6.setTag(R.drawable.black_pawn);
        G7.setTag(R.drawable.black_pawn);
        G8.setTag(R.drawable.black_pawn);

        H1.setTag(R.drawable.black_rook);
        H2.setTag(R.drawable.black_knight);
        H3.setTag(R.drawable.black_bishop);
        H4.setTag(R.drawable.black_queen);
        H5.setTag(R.drawable.black_king);
        H6.setTag(R.drawable.black_bishop);
        H7.setTag(R.drawable.black_knight);
        H8.setTag(R.drawable.black_rook);

        A1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go(A1);
            }
        });

        A2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go(A2);
            }
        });

        A3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go(A3);
            }
        });

        A4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go(A4);
            }
        });

        A5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go(A5);
            }
        });

        A6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go(A6);
            }
        });

        A7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go(A7);
            }
        });

        A8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go(A8);
            }
        });

        B1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go(B1);
            }
        });

        B2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go(B2);
            }
        });

        B3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go(B3);
            }
        });

        B4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go(B4);
            }
        });

        B5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go(B5);
            }
        });

        B6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go(B6);
            }
        });

        B7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go(B7);
            }
        });

        B8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go(B8);
            }
        });

        C1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go(C1);
            }
        });

        C2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go(C2);
            }
        });

        C3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go(C3);
            }
        });

        C4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go(C4);
            }
        });

        C5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go(C5);
            }
        });

        C6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go(C6);
            }
        });

        C7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go(C7);
            }
        });

        C8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go(C8);
            }
        });

        D1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go(D1);
            }
        });

        D2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go(D2);
            }
        });

        D3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go(D3);
            }
        });

        D4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go(D4);
            }
        });

        D5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go(D5);
            }
        });

        D6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go(D6);
            }
        });

        D7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go(D7);
            }
        });

        D8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go(D8);
            }
        });

        E1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go(E1);
            }
        });

        E2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go(E2);
            }
        });

        E3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go(E3);
            }
        });

        E4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go(E4);
            }
        });

        E5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go(E5);
            }
        });

        E6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go(E6);
            }
        });

        E7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go(E7);
            }
        });

        E8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go(E8);
            }
        });

        F1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go(F1);
            }
        });

        F2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go(F2);
            }
        });

        F3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go(F3);
            }
        });

        F4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go(F4);
            }
        });

        F5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go(F5);
            }
        });

        F6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go(F6);
            }
        });

        F7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go(F7);
            }
        });

        F8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go(F8);
            }
        });

        G1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go(G1);
            }
        });

        G2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go(G2);
            }
        });

        G3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go(G3);
            }
        });

        G4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go(G4);
            }
        });

        G5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go(G5);
            }
        });

        G6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go(G6);
            }
        });

        G7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go(G7);
            }
        });

        G8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go(G8);
            }
        });

        H1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go(H1);
            }
        });

        H2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go(H2);
            }
        });

        H3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go(H3);
            }
        });

        H4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go(H4);
            }
        });

        H5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go(H5);
            }
        });

        H6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go(H6);
            }
        });

        H7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go(H7);
            }
        });

        H8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go(H8);
            }
        });

    }

    public void move(int piece, ImageView from, ImageView to) {
        from.setImageResource(R.drawable.transparent);
        from.setTag(R.drawable.transparent);
        to.setImageResource(piece);
        to.setTag(piece);
    }

    public void go(ImageView square) {
        if (from == null) {
            from = square;
            fromId = (int) square.getTag();
        } else {
            move(fromId, from, square);
            from = null;
        }
    }
    ImageView row0Co
}
