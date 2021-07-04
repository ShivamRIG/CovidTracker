package com.example.cowin_vac;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;


import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;

import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity implements AdapterView.OnItemClickListener ,View.OnClickListener {
    TextView Txtv,name,age,vac,fees;
    String data;
    ListView listView;
    JSONArray jsonArray;
    JSONObject jsonObject;
    Button btn;
    Intent intent;
    String Name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        data = getIntent().getStringExtra("data");
         listView =findViewById(R.id.listview);
        ArrayList<String> info=new ArrayList<>();
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,info);
        listView.setOnItemClickListener(this);
        RequestQueue queue;
        queue= Volley.newRequestQueue(this);

        
// Request a string response from the provided URL.
        JsonObjectRequest jsonRequest = new JsonObjectRequest(Request.Method.GET, "https://cdn-api.co-vin.in/api/v2/appointment/sessions/public/findByDistrict?district_id=363&date="+data,null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONObject jsonObject1 = new JSONObject(response.toString());
                             jsonArray = jsonObject1.getJSONArray("sessions");
                            Log.d("Json response", "onResponse: "+jsonObject1.toString());

                            for (int i = 0; i < jsonArray.length(); i++) {
                                 jsonObject = jsonArray.getJSONObject(i);
                                info.add(jsonObject.get("name").toString());
                            }
                            listView.setAdapter(arrayAdapter);
                            } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO: Handle error
                       Log.d("data", String.valueOf(error));
                    }
                });
            queue.add(jsonRequest);


    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
    listView.setVisibility(View.INVISIBLE);
    Txtv =findViewById(R.id.textView8);
    name= findViewById(R.id.name);
    age= findViewById(R.id.age);
    vac= findViewById(R.id.time);
    fees=findViewById(R.id.fees);
    btn=findViewById(R.id.find);
    //visible
    Txtv.setVisibility(View.VISIBLE);
    age.setVisibility(View.VISIBLE);
    name.setVisibility(View.VISIBLE);
    fees.setVisibility(View.VISIBLE);
    vac.setVisibility(View.VISIBLE);
    btn.setVisibility(View.VISIBLE);


        String dat = "";
    for (int i=0; i<jsonArray.length();i++){
        String value = parent.getItemAtPosition(position).toString();
        try {
            jsonObject =jsonArray.getJSONObject(i);
            dat=jsonObject.get("name").toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if(value.equals(dat)){
            try {
                name.setText(jsonObject.get("name").toString());
                fees.setText(jsonObject.get("fee_type").toString());
                vac.setText(jsonObject.get("vaccine").toString());
                age.setText(jsonObject.get("min_age_limit").toString());
                btn.setOnClickListener(this);


            } catch (JSONException e) {
                Log.d("data", String.valueOf(e));
            }


        }
    }
    }

    @Override
    public void onClick(View v) {
        if(name.getText()!=null) {

            intent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://www.google.com/maps/search/?api=1&query= pune " + name.getText()));
        }
        else{
        vac.setText("Data not found");
        }
        startActivity(intent);
    }
}
