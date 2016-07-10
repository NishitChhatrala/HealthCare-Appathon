package com.neha.appathon2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Onedisease extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onedisease);
        final Bundle extras = getIntent().getExtras();
        String value=null;
        if (extras != null) {
            value = extras.getString("code");
        }

       final String[] name={"Malaria","Dengue","Cancer","Tuberculosis","Chickenpox","Cholera","Typhoid"};
        String[] symptoms={"\n\n Symptoms \n\n Cold \n Fever \n Headaches \n Consciousness \n Bleeding \n","\n" +
                "\nSymptoms \n\n Fever \n Headaches \n MusclePain \n JointPain \n Nausea\n","\n" +
                "\nSymptoms \n\n Vomit \n Cold \n Dizziness\n Pain \n Cough","\n" +
                "\nSymptoms \n\n" +
                " Cough \n Fever \n Cold \n MusclePain \n Nausea","\n" +
                "\nSymptoms \n\n" +
                " Fever\n Nausea\n Jointpain \n MusclePain \n Dizziness \n","\n" +
                "\nSymptoms \n\n" +
                " Dehydration \n Sleepiness \n Cramping \n Cold","\n" +
                "\nSymptoms \n\n" +
                " Headaches \n Cold \n Cough \n Chills \n Vomiting \n "};

        String[] description={"Malaria is a life-threatening blood disease caused by parasites transmitted to humans through the bite of the Anopheles mosquito. Once an infected mosquito bites a human and transmits the parasites, those parasites multiply in the host's liver before infecting and destroying red blood cells.","Dengue fever is a mosquito-borne tropical disease caused by the dengue virus","Cancer details","Tuberculosis description","chikenpox description","Cholera description","Thyphoid description"};


        TextView head= (TextView) findViewById(R.id.textView_onedisease_head);
        TextView desc= (TextView) findViewById(R.id.textView_onedisease_desc);
        Button finddoc= (Button) findViewById(R.id.onedisease_contactdoc);


        finddoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //getSupportFragmentManager().beginTransaction().add(android.R.id.content, new FragmentThree()).commit());
                Intent i= new Intent(Onedisease.this, Display_Doctor.class);
                i.putExtra("code",extras);
                startActivity(i);
            }
        });



        for(int i=0; i<name.length; i++){
            if(value.equalsIgnoreCase(name[i])){
                head.setText(name[i]);
                desc.setText(description[i]+"\n"+symptoms[i]);
            }
        }

//        String headarr[]= {"Malaria", "Cancer", "Diar"}


        //recieve intent from cardAdapter here
        //get the array of info abt diseases here
        //according to the intent recieved, put in the string in heading and description text views
    }
    }
