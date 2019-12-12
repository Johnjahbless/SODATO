package com.app.android.june.sodato;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {
String name;

    private ProgressDialog pDialog;
    BarChart barChart;
    BarData barData;
    BarDataSet barDataSet;
    ArrayList<BarEntry> barEntries;
    CountDownTimer countDownTimer;
    private int counter = 10;
    SwipeRefreshLayout swipeRefreshLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        name = getIntent().getStringExtra("name");
        barChart = findViewById(R.id.BarChart);

        swipeRefreshLayout = findViewById(R.id.refresh);
getEntries();
getEntries2();
        swipeRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_dark,
                (android.R.color.black));
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                displayLoader();
                startTimer2();

            }
        });

        displayLoader();
        startTimer();
    }
    private void getEntries() {
        barEntries = new ArrayList<BarEntry>();
        barEntries.add(new BarEntry(2f, 0));
        barEntries.add(new BarEntry(4f, 1));
        barEntries.add(new BarEntry(6f, 1));
        barEntries.add(new BarEntry(8f, 3));
        barEntries.add(new BarEntry(7f, 4));
        barEntries.add(new BarEntry(3f, 3));

    }

    private void getEntries2() {
        barEntries = new ArrayList<BarEntry>();
        barEntries.add(new BarEntry(2f, 3));
        barEntries.add(new BarEntry(4f, 0));
        barEntries.add(new BarEntry(6f, 1));
        barEntries.add(new BarEntry(8f, 3));
        barEntries.add(new BarEntry(7f, 1));
        barEntries.add(new BarEntry(3f, 2));

    }
    private void displayLoader() {
        pDialog = new ProgressDialog(Main2Activity.this);
        pDialog.setMessage("Processing.. Please wait...");
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(false);
        pDialog.show();

    }

    public void startTimer() {

        countDownTimer = new CountDownTimer(10000, 1000) {
            public void onTick(long millisUntilFinished) {
                counter--;
            }
            public void onFinish() {
                pDialog.cancel();
                barDataSet = new BarDataSet(barEntries, "Hausa");
                barData = new BarData(barDataSet);
                barChart.setData(barData);
                barDataSet.setColors(ColorTemplate.JOYFUL_COLORS);
                barDataSet.setValueTextColor(Color.BLACK);
                barDataSet.setValueTextSize(18f);

            }

        }.start();
    }

    public void startTimer2() {

        countDownTimer = new CountDownTimer(10000, 1000) {
            public void onTick(long millisUntilFinished) {
                counter--;
            }
            public void onFinish() {
                pDialog.cancel();
                barDataSet = new BarDataSet(barEntries, "Hausa");
                barData = new BarData(barDataSet);
                barChart.setData(barData);
                barDataSet.setColors(ColorTemplate.JOYFUL_COLORS);
                barDataSet.setValueTextColor(Color.BLACK);
                barDataSet.setValueTextSize(18f);

            }

        }.start();
    }
    public void start(View view) {
        Intent intent = new Intent(this, Main3Activity.class);
        intent.putExtra("name", name);
        startActivity(intent);
    }

    public void tou(View view) {
        TextView textView = findViewById(R.id.touch);
        textView.setVisibility(View.GONE);
    }
}
