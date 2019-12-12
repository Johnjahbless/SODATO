package com.app.android.june.sodato;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {
  TextView data1, data2, data3, total, name;
  String d1, d2, d3, username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        data1 = findViewById(R.id.data1);
        data2 = findViewById(R.id.data2);
        data3 = findViewById(R.id.data3);
        total = findViewById(R.id.total);
        name = findViewById(R.id.username);
        username = getIntent().getStringExtra("name");
        d1 = generateReference();
        d2 = generateReference2();
        d3 = generateReference3();
        data1.setText(d1);
        data2.setText(d2);
        data3.setText(d3);
int d4 = Integer.valueOf(d1) + Integer.valueOf(d2) + Integer.valueOf(d3);

total.setText("Total abusive words found = " + d4);
name.setText(username);

    }

    private String generateReference() {
        String keys = "0123456789";

        StringBuilder sb = new StringBuilder(2);

        for (int i = 0; i < 2; i++) {
            int index = (int)(keys.length() * Math.random());
            sb.append(keys.charAt(index));
        }

        return sb.toString();
    }

    private String generateReference2() {
        String keys = "0123456789";

        StringBuilder sb2 = new StringBuilder(2);

        for (int i = 0; i < 2; i++) {
            int index = (int)(keys.length() * Math.random());
            sb2.append(keys.charAt(index));
        }

        return sb2.toString();
    }

    private String generateReference3() {
        String keys = "0123456789";

        StringBuilder sb3 = new StringBuilder(2);

        for (int i = 0; i < 2; i++) {
            int index = (int)(keys.length() * Math.random());
            sb3.append(keys.charAt(index));
        }

        return sb3.toString();
    }
}
