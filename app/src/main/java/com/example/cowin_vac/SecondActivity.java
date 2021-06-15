package com.example.cowin_vac;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    TextView Txtv;
    String data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Txtv=(TextView)findViewById(R.id.textView2);
        data=getIntent().getStringExtra("date");
        Txtv.setText(data);
    }
}