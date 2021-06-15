package com.example.cowin_vac;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText ED;
    Button BTN,BTN2;
    private int mYear, mMonth, mDay ;
    private String tem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ED=(EditText)findViewById(R.id.date);
        BTN=(Button)findViewById(R.id.btn);
        BTN.setOnClickListener(this);
        BTN2=(Button)findViewById(R.id.BTN2);
        BTN2.setOnClickListener(this);



    }
    @Override
    public void onClick(View v) {
        if (v == BTN) {

            // Get Current Date
            final Calendar c = Calendar.getInstance();
             mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);

            mDay = c.get(Calendar.DAY_OF_MONTH);


            DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                    new DatePickerDialog.OnDateSetListener() {

                        @Override
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {

                            ED.setText(dayOfMonth + "-" + (monthOfYear ) + "-" + year);
                            tem=dayOfMonth + "-" + monthOfYear  + "-" +year;
                        }
                    }, mYear, mMonth, mDay);

            datePickerDialog.show();

            }
        if(v==BTN2){
            Intent inte1 = new Intent(this, SecondActivity.class);
            inte1.putExtra("date",tem);
            startActivity(inte1);

        }



    }
}
