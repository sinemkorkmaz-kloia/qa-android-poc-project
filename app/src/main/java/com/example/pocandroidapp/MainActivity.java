package com.example.pocandroidapp;

import androidx.appcompat.app.AppCompatActivity;

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

    public void onClickIndia(View view) {
        String formattedDate = getTime("Asia/Kolkata");
        TextView textView = findViewById(R.id.my_clock);
        textView.setText("India: " + formattedDate);
    }

    public void onClickGermany(View view) {
        String formattedDate = getTime("Europe/Berlin");
        TextView textView = findViewById(R.id.my_clock);
        textView.setText("Germany: " + formattedDate);
    }

    public String getTime(String timeZoneParam){
        TimeZone timeZone = TimeZone.getTimeZone("Europe/Berlin");
        Calendar calendar = Calendar.getInstance(timeZone);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdf.setTimeZone(timeZone);

        return  sdf.format(calendar.getTime());
    }
}