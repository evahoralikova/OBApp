package com.example.evaho.myob;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView txt_header1;
    TextView txt_content1;
    TextView txt_header2;
    TextView txt_content2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt_header1=(TextView) findViewById(R.id.textView_header1);
        txt_content1=(TextView) findViewById(R.id.textView_content1);
        txt_header2=(TextView) findViewById(R.id.textView_header2);
        txt_content2=(TextView) findViewById(R.id.textView_content2);
    }
}
