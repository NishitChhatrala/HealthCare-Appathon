package com.neha.appathon2;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.neha.appathon2.adapter.CardAdapter;
import com.neha.appathon2.util.Config;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Display_Doctor extends AppCompatActivity implements View.OnClickListener{


    Button button;
    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;
    RecyclerView.Adapter mAdapter;
    String value = null;
    private ProgressDialog loading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display__doctor);

        final Bundle extras = getIntent().getExtras();

        if (extras != null) {
            value = extras.getString("code");
        }

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new CardAdapter(this);
        mRecyclerView.setAdapter(mAdapter);



    }


    private void getData() {
        String id = "ortho";
        // id= "\""+id+"\"";
        // String id1 = Password.getText().toString().trim();
        loading = ProgressDialog.show(this, "Please wait...", "Fetching...", false, false);

        String url = Config.SIGN_UP + id;
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
                        Toast.makeText(Display_Doctor.this, error.getMessage().toString(), Toast.LENGTH_LONG).show();
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }


    private void showJSON(String response) {
        String name = "";
        String password = "";
        // String vc = "";
        try {
            JSONObject jsonObject = new JSONObject(response);
            JSONArray result = jsonObject.getJSONArray(Config.JSON_ARRAY);
            JSONObject collegeData = result.getJSONObject(0);

            name = collegeData.getString(Config.KEY_NAME);
            password = collegeData.getString(Config.KEY_ADDRESS);
            //   vc = collegeData.getString(Config.KEY_VC);


            Toast.makeText(getApplicationContext(), "Yes name" + name, Toast.LENGTH_SHORT).show();
            Toast.makeText(getApplicationContext(), "Yes pass" + password, Toast.LENGTH_SHORT).show();
            //   Toast.makeText(getApplicationContext(), "Yes vc"+vc, Toast.LENGTH_SHORT).show();

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
