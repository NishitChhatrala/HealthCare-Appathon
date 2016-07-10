package com.neha.appathon2.fragments;

import android.app.AlarmManager;
import android.app.DatePickerDialog;
import android.support.v4.app.Fragment;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import com.neha.appathon2.R;
import com.neha.appathon2.adapter.TimeAlarm;

import java.util.Calendar;

public class FragmentOne extends Fragment {


    Spinner vaccinespinner;
    String vaccine;
    EditText date;
    EditText time;
    private int mYear,mMonth,mDay,mHour,mMinute;
    Button notificationbutton;
    Calendar c=Calendar.getInstance();



    final String[] vaccines={"vaccine1","vaccine2","vaccine3","vaccine4","vaccine5","vaccine6"};


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_one, container, false);

        vaccinespinner = (Spinner) v.findViewById(R.id.vaccine);
        date = (EditText) v.findViewById(R.id.date);
        time = (EditText) v.findViewById(R.id.time);
        ArrayAdapter<String> MspinnerAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, vaccines);
        vaccinespinner.setAdapter(MspinnerAdapter);
        vaccinespinner.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                        vaccine = vaccines[position];
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });


        final Calendar current = Calendar.getInstance();
        date = (EditText) v.findViewById(R.id.date);
        time = (EditText) v.findViewById(R.id.time);
        notificationbutton = (Button) v.findViewById(R.id.notification);


        //----date picker

        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);

        final DatePickerDialog dpd = new DatePickerDialog(getActivity(),
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {
                        // Display Selected date in textbox
                        date.setText(dayOfMonth + "-"
                                + (monthOfYear + 1) + "-" + year);
                        c.set(Calendar.YEAR, year);
                        c.set(Calendar.MONTH, monthOfYear);
                        c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                        mYear = c.get(Calendar.YEAR);
                        mMonth = c.get(Calendar.MONTH);
                        mDay = c.get(Calendar.DAY_OF_MONTH);

                    }
                }, mYear, mMonth, mDay);

        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dpd.show();
            }
        });

        //----
        //----time picker----

        mHour=c.get(Calendar.HOUR_OF_DAY);
        mMinute = c.get(Calendar.MINUTE);

        final TimePickerDialog tpd=new TimePickerDialog(getActivity(),new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                time.setText(hourOfDay + ":" + minute);
                // now.set(mYear,mMonth,mDay,mHour,mMinute);
                c.set(Calendar.HOUR_OF_DAY, hourOfDay);
                c.set(Calendar.MINUTE, minute);

                mHour=c.get(Calendar.HOUR_OF_DAY);
                mMinute = c.get(Calendar.MINUTE);

            }
        },mHour,mMinute,false);

        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                tpd.show();
            }

        });


        //---
        notificationbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(c.getTimeInMillis() <= System.currentTimeMillis()){
                    //The set Date/Time already passed
                    Toast.makeText(getActivity().getApplicationContext(),
                            "date:"+date+" time:"+time+" calendertime: "+c.getTime().toString() ,
                            Toast.LENGTH_LONG).show();
                }else{
Toast.makeText(getActivity().getApplicationContext(), "Reminer successfully set", Toast.LENGTH_SHORT).show();





                    setNotification(c);
                    //now=null;
                }

            }
        });
        //    /----
return v;
    }





    public void setNotification(Calendar c){


        Intent intent = null;
        intent=new Intent(getActivity().getApplicationContext(),TimeAlarm.class);
        /*intent.putExtra("NOTIFICATION", "Time to complete your list" + name);
        intent.putExtra("ID", pos);
        intent.putExtra("LONG", dateNotification.getTime());*/

        PendingIntent sender = PendingIntent.getBroadcast(
                getActivity().getApplicationContext(), 001,
                intent, 0);
        AlarmManager am = null;
        am = (AlarmManager) getActivity().getSystemService(getActivity().ALARM_SERVICE);
        am.set(AlarmManager.RTC_WAKEUP, c.getTimeInMillis(),
                sender);

    }


}
