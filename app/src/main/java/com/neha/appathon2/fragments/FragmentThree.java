package com.neha.appathon2.fragments;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.neha.appathon2.R;
import com.neha.appathon2.adapter.CardAdapter;

/**
 * Created by neokree on 16/12/14.
 */
public class FragmentThree extends Fragment{

    Button button;
    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;
    RecyclerView.Adapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.recycler_view_layout, container, false);


        // Inflate the layout for this fragment
        mRecyclerView = (RecyclerView) v.findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new CardAdapter(getActivity());
        mRecyclerView.setAdapter(mAdapter);

        return v;
    }

    //private void getData() {
        //String id = Name.getText().toString().trim();
        // id= "\""+id+"\"";
        // String id1 = Password.getText().toString().trim();
      /*  if (id.equals("")) {
            Toast.makeText(this, "Please enter an id", Toast.LENGTH_LONG).show();
            return;
        } else if (id.equals("")) {
            Toast.makeText(this, "Please enter Password", Toast.LENGTH_LONG).show();
            return;
      */
           /* loading = ProgressDialog.show(this, "Please wait...", "Fetching...", false, false);

            String url = Config.USER_NAME + id;
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
                            Toast.makeText(Login.this, error.getMessage().toString(), Toast.LENGTH_LONG).show();
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


            Toast.makeText(getApplicationContext(), "Yes name"+name, Toast.LENGTH_SHORT).show();
            Toast.makeText(getApplicationContext(), "Yes pass"+password, Toast.LENGTH_SHORT).show();
            //   Toast.makeText(getApplicationContext(), "Yes vc"+vc, Toast.LENGTH_SHORT).show();

            if (Name.getText().toString().equals(name) && Password.getText().toString().equals(password)) {
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
*/

}
