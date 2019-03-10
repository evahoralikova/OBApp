package com.example.evaho.myob;

import android.content.Intent;
import android.os.AsyncTask;
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
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Collections;
import java.util.*;



public class MainActivity extends AppCompatActivity {
    Button bt_denik;
    Button bt_prehled;
    TextView txt_header1;
    TextView txt_content1;
    TextView txt_header2;
    TextView txt_content2;
    String m_training_info;
    TextView m_textView_denik;

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

        //int rid = R.id.textView_denik;
        //textView_denik = (TextView) (myView.findViewById(rid));
        new MyDownloadTask("http://ec2-35-171-129-7.compute-1.amazonaws.com/trainings").execute();


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
                                //ItemOneFragment.newInstance();
                                selectedFragment =
                                        OverviewFragment.newInstance();
                                break;
                            case R.id.action_item2:
                                //selectedFragment =
                                //ItemTwoFragment.newInstance();
                                selectedFragment = DenikFragment.newInstance();
                                DenikFragment denik_fragment = (DenikFragment) selectedFragment;
                                denik_fragment.setDenikText(m_training_info);
                                break;
                        }
                        FragmentTransaction transaction =
                                getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.frame_layout,
                                selectedFragment);
                        transaction.commit();

;
                        return true;
                    }
                });

        //Manually displaying the first fragment - one time only
        FragmentTransaction transaction =
                getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_layout, OverviewFragment.newInstance());
        transaction.commit();

    }

    class MyDownloadTask extends AsyncTask<Void,Void,Void> {
        private String mUrl;
        //private String mContent;
        //TextView mTextView_denik;

        public MyDownloadTask(String url) {

            mUrl = url;
            //mContent = null;
            //mTextView_denik = textView;
        }

        protected void onPreExecute() {
            //display progress dialog.

        }

        protected Void doInBackground(Void... params) {
            try {
                m_training_info = downloadUrl(mUrl);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            return null;
        }

        protected void onPostExecute(Void result) {

        }

        private String downloadUrl(String myurl) throws IOException {
            InputStream is = null;
            // Only display the first 500 characters of the retrieved
            // web page content.
            //int len = 30000;

            try {
                URL url = new URL(myurl);
                HttpURLConnection conn = (HttpURLConnection)
                        url.openConnection();
                conn.setReadTimeout(20000 /* milliseconds */);
                conn.setConnectTimeout(30000 /* milliseconds */);
                conn.setRequestMethod("GET");
                conn.setDoInput(true);
                // Starts the query
                conn.connect();
                int response = conn.getResponseCode();
                is = conn.getInputStream();

                // Convert the InputStream into a string
                //String contentAsString = readIt(is, len);
                String contentAsString = readItBetter(is);
                return contentAsString;

                // Makes sure that the InputStream is closed after the app is
                // finished using it.
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return "";
            } finally {
                if (is != null) {
                    is.close();
                }
            }
        }

        private String readItBetter(InputStream stream) throws IOException {
            BufferedReader r = new BufferedReader(new
                    InputStreamReader(stream));
            StringBuilder total = new StringBuilder();
            String line;
            while ((line = r.readLine()) != null) {
                total.append(line).append('\n');
            }

            return total.toString();
        }
    }

}

