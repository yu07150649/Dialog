package com.example.yu.dialog;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.CharacterPickerDialog;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {
    private TextView tv1,tv2,tv3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1 = (TextView) findViewById(R.id.uidate);
        tv2 = (TextView) findViewById(R.id.uitime);
        tv3 = (TextView) findViewById(R.id.character);
    }
    public void characterpickerdialog(View view){
        final String options="333333#+";
        CharacterPickerDialog cpd = new CharacterPickerDialog(this,new View(this),null,options,false){
            @Override
            public void onClick(View v) {
                super.onClick(v);
                tv3.append(((Button)v).getText().toString());
                if(((Button)v).getText().toString().equals("")){
                    dismiss();
                }
            }
        };
        cpd.show();
    }
    public void datepickerdialog(View view){
        DatePickerDialog dpd = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                tv1.setText("日期："+year+"-"+(month+1)+"-"+dayOfMonth);
            }
        },2016,11,11);
        dpd.show();
    }
    public void timepickerdialog(View view){
        TimePickerDialog tpd = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                tv2.setText(hourOfDay+":"+minute);
            }
        },11,11,true);
        tpd.show();
    }
    public void progressdialog(View view){
        final ProgressDialog pg = ProgressDialog.show(this,"加载","加载中,请稍后。。。。。。。。",true);
        new Thread(){
            public void run(){
                try{
                    sleep(2000);
                }catch (Exception e){
                    e.printStackTrace();
                }finally{
                    pg.dismiss();
                }
            }
        }.start();
    }
}
