package com.WMA.minggu6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class explicit2 extends AppCompatActivity {
    TextView txtHello;
    private String KEY_NAME = "NAMA";
    private String nama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.explicit2);
        txtHello = (TextView) findViewById(R.id.text);

        Bundle extras = getIntent().getExtras();
        nama = extras.getString(KEY_NAME);
        txtHello.setText("Hello, " + nama + " !");

        getSupportActionBar().setTitle("EXPLICIT");
    }
}