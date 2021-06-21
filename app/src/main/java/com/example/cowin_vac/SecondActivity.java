package com.example.cowin_vac;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SecondActivity extends AppCompatActivity {
    TextView Txtv;
    String data;
    //String Hos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Txtv=(TextView)findViewById(R.id.textView2);
         data = getIntent().getStringExtra("data");
        Txtv.setText(data);
        RequestQueue queue;
        queue= Volley.newRequestQueue(this);
        
// Request a string response from the provided URL.
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, "https://cdn-api.co-vin.in/api/v2/appointment/sessions/public/findByDistrict?district_id=363&date=20-06-2021",null, new Response.Listener<JSONArray>() {

                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            Log.d("res",response.getString(2));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO: Handle error
                       Log.d("map", String.valueOf(error));
                    }
                });
            queue.add(jsonArrayRequest);


// Add the request to the RequestQueue.


               // url = new URL("https://cdn-api.co-vin.in/api/v2/appointment/sessions/public/findByDistrict?district_id=363&date=" + data);


    }
}
