package com.example.evaho.myob;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import org.w3c.dom.Text;

import java.net.HttpURLConnection;
import java.net.URL;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.List;


public class DenikFragment extends Fragment {

    TextView textView_denik;
    List<Training> m_training_info;

    private Context context = null;


    public static DenikFragment newInstance() {
        DenikFragment fragment = new DenikFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        context = this.getContext();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View myView = inflater.inflate(R.layout.fragment_denik, container, false);
        //int rid = R.id.textView_denik;
        //textView_denik = (TextView) (myView.findViewById(rid));
        //new MyDownloadTask("http://ec2-35-171-129-7.compute-1.amazonaws.com/trainings", textView_denik).execute();
        setDenikTextView(myView);

        final Button button = (Button) myView.findViewById(R.id.buttonAddTraining);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Activity currentActivity = getActivity();
                Intent myIntent = new Intent(currentActivity, NewTrainingActivity.class);
                //myIntent.putExtra("key", value); //Optional parameters
                DenikFragment.this.startActivity(myIntent);
            }
        });

        return myView;
    }

    public void setDenikText(String newText){

        m_training_info = DataService.getTrainings();

    }

    private void setDenikTextView(View view){

        textView_denik = (TextView) (view.findViewById(R.id.textView_denik));
        textView_denik.setText("Ahoj2");

        /*int rid = R.id.denikTableLayout;
        TabLayout table = view.findViewById(rid);

        // Create a new table row.
        TableRow tableRow = new TableRow(view.getContext());

        // Set new table row layout parameters.
        TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
        tableRow.setLayoutParams(layoutParams);

        // Add a TextView in the first column.
        TextView textView = new TextView(context);
        textView.setText("Ahoj");
        tableRow.addView(textView, 0);

        table.addView(tableRow);*/

    }

    /*class MyDownloadTask extends AsyncTask<Void,Void,Void>
    {
        private String mUrl;
        private String mContent;
        TextView mTextView_denik;

        public MyDownloadTask(String url, TextView textView){

            mUrl = url;
            mContent = null;
            mTextView_denik = textView;
        }

        protected void onPreExecute() {
            //display progress dialog.

        }
        protected Void doInBackground(Void... params) {
            try {
                mContent = downloadUrl(mUrl);
            }catch (IOException e){
                System.out.println(e.getMessage());
            }
            return null;
        }

        protected void onPostExecute(Void result) {
            mTextView_denik.setText(mContent);
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
                conn.setReadTimeout(20000 );
                conn.setConnectTimeout(30000);
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
            }catch (Exception e) {
                System.out.println(e.getMessage());
                return "";
            }
            finally {
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

    }*/
}

