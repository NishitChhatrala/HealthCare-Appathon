package com.neha.appathon2;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.neha.appathon2.util.Config_Login;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Log_In extends AppCompatActivity implements View.OnClickListener {

    EditText email, Password;
    Button login,Register;
    private ProgressDialog loading;
    Toolbar toolbar;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log__in);

        login = (Button) findViewById(R.id.btnLogin);
        Register = (Button)findViewById(R.id.btnLinkToRegisterScreen);
        email = (EditText) findViewById(R.id.email);
        Password = (EditText) findViewById(R.id.password);

//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
  //      setSupportActionBar(toolbar);
        login.setOnClickListener(this);
        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(),Sign_Up.class);
                startActivity(i);
            }
        });

    }

    //String url = Config.USER_NAME + Name.getText().toString().trim() + Password.toString().trim();

    private void getData() {
        String id = email.getText().toString().trim();
        // id= "\""+id+"\"";
        // String id1 = Password.getText().toString().trim();
        if (id.equals("")) {
            Toast.makeText(this, "Please enter an id", Toast.LENGTH_LONG).show();
            return;
        } else if (id.equals("")) {
            Toast.makeText(this, "Please enter Password", Toast.LENGTH_LONG).show();
            return;
        } else {
            loading = ProgressDialog.show(this, "Please wait...", "Loading...", false, false);

            String url = Config_Login.LOG_IN + id;
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
                            Toast.makeText(Log_In.this, error.getMessage().toString(), Toast.LENGTH_LONG).show();
                        }
                    });

            RequestQueue requestQueue = Volley.newRequestQueue(this);
            requestQueue.add(stringRequest);
        }
    }

    private void showJSON(String response) {
        String name = "";
        String password = "";
        // String vc = "";
        try {
            JSONObject jsonObject = new JSONObject(response);
            JSONArray result = jsonObject.getJSONArray(Config_Login.JSON_ARRAY);
            JSONObject collegeData = result.getJSONObject(0);

            name = collegeData.getString(Config_Login.KEY_NAME);
            password = collegeData.getString(Config_Login.KEY_ADDRESS);
            //   vc = collegeData.getString(Config.KEY_VC);


            Toast.makeText(getApplicationContext(), "Welcome!", Toast.LENGTH_SHORT).show();
          //  Toast.makeText(getApplicationContext(), "Yes pass"+password, Toast.LENGTH_SHORT).show();
            //   Toast.makeText(getApplicationContext(), "Yes vc"+vc, Toast.LENGTH_SHORT).show();

            if (email.getText().toString().equals(name) && Password.getText().toString().equals(password)) {
                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
                Toast.makeText(getApplicationContext(), "Yes Successful", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getApplicationContext(), "Not Succeeful", Toast.LENGTH_SHORT).show();

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        // textViewResult.setText("Name:\t" + name + "\nAddress:\t" + address + "\nVice Chancellor:\t" + vc);
    }

    @Override
    public void onClick(View v) {
        getData();
    }

}
