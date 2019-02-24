package com.example.evaho.myob;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button bt_denik;
    Button bt_prehled;
    TextView txt_header1;
    TextView txt_content1;
    TextView txt_header2;
    TextView txt_content2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*txt_header1=(TextView) findViewById(R.id.textView_header1);
        txt_content1=(TextView) findViewById(R.id.textView_content1);
        txt_header2=(TextView) findViewById(R.id.textView_header2);
        txt_content2=(TextView) findViewById(R.id.textView_content2); */
        /*bt_denik = (Button) findViewById(R.id.bt_denik);
        /bt_prehled = (Button) findViewById(R.id.bt_prehled);


        bt_denik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent (v.getContext(),
Main2Activity_denik.class);
                startActivity(intent);
            }
        });
        bt_prehled.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent (v.getContext(),
Overview_Activity.class);
                startActivity(intent);
            }
        });*/

        final BottomNavigationView bottomNavigationView = (BottomNavigationView)
                findViewById(R.id.navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener
                (new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull
                                                                    MenuItem item) {
                        Fragment selectedFragment = null;
                        switch (item.getItemId()) {
                            case R.id.action_item1:
                                //selectedFragment =
                                ItemOneFragment.newInstance();
                                selectedFragment =
                                        OverviewFragment.newInstance();
                                break;
                            case R.id.action_item2:
                                //selectedFragment =
                                ItemTwoFragment.newInstance();
                                selectedFragment = DenikFragment.newInstance();
                                break;
                        }
                        FragmentTransaction transaction =
                                getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.frame_layout,
                                selectedFragment);
                        transaction.commit();
                        return true;
                    }
                });

        //Manually displaying the first fragment - one time only
        FragmentTransaction transaction =
                getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_layout, OverviewFragment.newInstance());
        transaction.commit();

    }
}

