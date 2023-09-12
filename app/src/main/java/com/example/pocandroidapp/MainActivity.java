package com.example.pocandroidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @SuppressLint("SetTextI18n")
    public void onClickIndia(View view) {
        String formattedDate = getTime("Asia/Kolkata");
        TextView textView = findViewById(R.id.my_clock);
        textView.setText("India: " + formattedDate);
    }

    @SuppressLint("SetTextI18n")
    public void onClickGermany(View view) {
        String formattedDate = getTime("Europe/Berlin");
        TextView textView = findViewById(R.id.my_clock);
        textView.setText("Germany: " + formattedDate);
    }

    public String getTime(String timeZoneParam){
        TimeZone timeZone = TimeZone.getTimeZone(timeZoneParam);
        Calendar calendar = Calendar.getInstance(timeZone);

        @SuppressLint("SimpleDateFormat") SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdf.setTimeZone(timeZone);

        return  sdf.format(calendar.getTime());
    }
}