package com.neha.appathon2;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.neha.appathon2.util.Config;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Sign_Up extends AppCompatActivity implements View.OnClickListener {
    private EditText Name, LastName, Email, Password, Mob_Num, Emer_Num;
    private Button Register,Move;
    private TextView textViewResult;
    private Toolbar toolbar;
    private ProgressDialog loading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign__up);
        String fname,lname,email,mno,pass,emeno;
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        Name = (EditText) findViewById(R.id.name);
        LastName = (EditText) findViewById(R.id.lasname);
        Email = (EditText) findViewById(R.id.email);
        Password = (EditText) findViewById(R.id.password);
        Mob_Num = (EditText) findViewById(R.id.mob_no);
        Emer_Num = (EditText) findViewById(R.id.emergency_num);

/*
        fname = Name.getText().toString().trim();
        lname = LastName.getText().toString().trim();
        email = Email.getText().toString().trim();
        mno = Password.getText().toString().trim();
        pass = Mob_Num.getText().toString().trim();
        emeno = Emer_Num.getText().toString().trim();*/

        Register = (Button) findViewById(R.id.btnRegister);
        Move = (Button)findViewById(R.id.btnLinkToLoginScreen);
      Register.setOnClickListener(this);


        Move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(),Log_In.class);
                startActivity(i);

            }
        });

    }

    // String url = Config.USER_NAME+Name.getText().toString().trim()+"&"+LastName.toString().trim()+"&"+Email.toString().trim()+"&"+Mob_Num.toString().trim()+"&"+Password.toString().trim()+"&"+Emer_Num.toString().trim();

    private void getData() {
        String id = Name.getText().toString().trim();
        String fname1,lname1,email1,mno1,pass1,emeno1;

        fname1 = Name.getText().toString().trim();
        fname1= "\""+fname1+"\"";
        lname1 = LastName.getText().toString().trim();
        lname1= "\""+lname1+"\"";
        email1 = Email.getText().toString().trim();
        email1 = "\""+email1+"\"";
        mno1 = Mob_Num.getText().toString().trim();
        mno1 = "\""+mno1+"\"";
        pass1 = Password.getText().toString().trim();
        pass1= "\""+pass1+"\"";
        emeno1 = Emer_Num.getText().toString().trim();
        emeno1 = "\""+emeno1+"\"";

        if (id.equals("")) {
            Toast.makeText(this, "Please enter an id", Toast.LENGTH_LONG).show();
            return;
        }
        loading = ProgressDialog.show(this, "Please wait...", "Loading...", false, false);


        String url = Config.SIGN_UP + "fname="+fname1 + "&lname="+lname1 +  "&email="+email1 + "&mno="+mno1 + "&pass="+pass1 + "&emeno="+emeno1;
        System.out.println("url" + url);


        StringRequest stringRequest = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                loading.dismiss();

                showJSON(response);

            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Sign_Up.this, error.getMessage().toString(), Toast.LENGTH_LONG).show();
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
        Intent i = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(i);
    }

    private void showJSON(String response) {
        String name = "";
        String address = "";
        String vc = "";
        try {
            JSONObject jsonObject = new JSONObject(response);
            Toast.makeText(getApplicationContext(),"hi",Toast.LENGTH_SHORT).show();
            JSONArray result = jsonObject.getJSONArray(Config.JSON_ARRAY);
           // JSONObject collegeData = result.getJSONObject(0);

            //   name = collegeData.getString(Config.KEY_NAME);
            //   address = collegeData.getString(Config.KEY_ADDRESS);
            //  vc = collegeData.getString(Config.KEY_VC);
        } catch (JSONException e) {
            e.printStackTrace();
        }
//        textViewResult.setText("Name:\t" + name + "\nAddress:\t" + address + "\nVice Chancellor:\t" + vc);
    }



    @Override
    public void onClick(View v) {
        getData();
    }
}
