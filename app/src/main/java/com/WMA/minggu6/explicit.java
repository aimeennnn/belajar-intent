package com.WMA.minggu6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class explicit extends AppCompatActivity {
    EditText name;
    Button btnSend;
    private String KEY_NAME = "NAMA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.explicit);
        Spinner spinner = findViewById(R.id.spinner2);
        String [] options = {"Explicit","Implicit"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, options);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = options[position];

                switch (selectedItem) {
                    case "Implicit":
                        Intent explicitIntent = new Intent(explicit.this, implicit.class);
                        startActivity(explicitIntent);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        name = (EditText) findViewById(R.id.inputNama);
        btnSend = (Button) findViewById(R.id.button1);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String nama = name.getText().toString();
                    if (!TextUtils.isEmpty(nama)){
                        Intent i = new Intent(explicit.this, explicit2.class);
                        i.putExtra(KEY_NAME, nama);
                        startActivity(i);
                    }else {
                        Toast.makeText(getApplication(), "MASUKKAN DULU BANG NAMAMU", Toast.LENGTH_SHORT).show();
                    }
                }catch (Exception e){
                    e.printStackTrace();
                    Toast.makeText(getApplication(), "ERRORR BANGGG MASUKIN LAGI BANG!!!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        getSupportActionBar().setTitle("EXPLICIT");
    }
}