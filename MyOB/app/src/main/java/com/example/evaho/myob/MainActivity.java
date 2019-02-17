package com.example.evaho.myob;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button bt_denik;
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
        bt_denik = (Button) findViewById(R.id.bt_denik);

        bt_denik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent (v.getContext(), Main2Activity_denik.class);
                startActivity(intent);
            }
        });
    }
}
