package com.example.evaho.myob;

import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NewTrainingActivity extends AppCompatActivity {

    TextInputEditText mInputDatum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_training);

        mInputDatum = this.findViewById(R.id.inputDatum);

        final Button button = (Button) this.findViewById(R.id.buttonSubmit);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                String performedOn = (String) mInputDatum.getText().toString();
                Training training = new Training(performedOn, "1", "1", "1", "1");
                DataService.addTraining(training);
            }
        });
    }


}
