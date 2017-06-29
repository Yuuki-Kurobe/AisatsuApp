package com.example.kurobe.aisatsuapp;

import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView mTextView;
    int myHour;
    int myMinute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);

        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(this);

        mTextView = (TextView) findViewById(R.id.textView);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button1) {
            showTimePickerDialog();
        } else if (v.getId() == R.id.button2) {
            showGreeting();
        }

    }
    private void  showTimePickerDialog() {
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void  onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        myHour = hourOfDay;
                    }
                },12,0,true);
        timePickerDialog.show();
    }
    private void showGreeting() {

        if (myHour >=2 && myHour <= 9) {
            mTextView.setText("おはよう");
        } else if (myHour >= 10 && myHour <= 17) {
            mTextView.setText("こんにちは");
        } else {
            mTextView.setText("こんばんは");
        }


    }

}
