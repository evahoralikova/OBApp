package com.example.evaho.myob;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity_denik extends AppCompatActivity {
    TextView textView_headline;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2_denik);
        textView_headline=(TextView) findViewById(R.id.textView_headline);
    }
}
