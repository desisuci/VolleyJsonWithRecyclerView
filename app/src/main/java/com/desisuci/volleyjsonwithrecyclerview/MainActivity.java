package com.desisuci.volleyjsonwithrecyclerview;

import android.app.ProgressDialog;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    String id, name, username, email, street, suite, city, zipcode,addr, noHp;
    private RecyclerView recyclerView;
    private KontakAdapter kontakAdapter;
    private UsersAdapter adapter;
    private Button btn_get;
    private HttpURLConnection connection = null;
    private BufferedReader reader = null;
    private ArrayList<Users> usersArrayList;
    private ArrayList<Kontak> kontakArrayList;
    SwipeRefreshLayout mSwipeRefreshLayout;
    ProgressDialog progressDialog;

    RequestQueue rq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_get = (Button) findViewById(R.id.btn_get);
        rq = Volley.newRequestQueue(this);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        //makeJsonArrayRequest();
        makeJsonObjectRequest();

        // Swipe Refresh Layout
        mSwipeRefreshLayout = (SwipeRefreshLayout)findViewById(R.id.swipeContainer);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {

            @Override
            public void onRefresh() {
                makeJsonObjectRequest();
            }
        });

        btn_get.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                makeJsonObjectRequest();
            }
        });

    }

    public void makeJsonArrayRequest(){
        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setMessage("Please Wait");
        progressDialog.setCancelable(false);
        progressDialog.show();

        String reqURL ="http://210.210.154.65/MyProject/public/kontak";
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, reqURL, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                usersArrayList = new ArrayList<>();
                try {
                    for (int i = 0; i < response.length(); i++) {
                        //create a JSONObject for fetching single user data
                        JSONObject userDetail = response.getJSONObject(i);
                        id = userDetail.getString("id");
                        name = userDetail.getString("name");
                        username = userDetail.getString("username");
                        email = userDetail.getString("email");
                        noHp = userDetail.getString("noHp");

                        JSONObject address = userDetail.getJSONObject("address");
                        street = address.getString("street");
                        suite = address.getString("suite");
                        city = address.getString("city");
                        zipcode = address.getString("zipcode");

                        addr = street + " , " + suite + " , " + city + " , " + zipcode;

                        usersArrayList.add(new Users(id, name, username, email, addr, noHp));
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
                mSwipeRefreshLayout.setRefreshing(false);
                progressDialog.dismiss();

                adapter = new UsersAdapter(usersArrayList);
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setAdapter(adapter);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                mSwipeRefreshLayout.setRefreshing(false);
                progressDialog.dismiss();
                Log.i("Volley Error : ", String.valueOf(error));
            }
        });

        rq.add(jsonArrayRequest);

    }

    public void makeJsonObjectRequest (){
        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setMessage("Please Wait");
        progressDialog.setCancelable(false);
        progressDialog.show();

        String reqURL ="http://210.210.154.65/MyProject/public/kontak";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, reqURL, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                kontakArrayList = new ArrayList<>();
                try {
                    JSONArray values = response.getJSONArray("values");
                    for (int i = 0; i < values.length(); i++) {
                        //create a JSONObject for fetching single user data
                        JSONObject kontak = values.getJSONObject(i);
                        id = kontak.getString("id");
                        name = kontak.getString("nama");
                        email = kontak.getString("email");
                        addr = kontak.getString("alamat");
                        noHp = kontak.getString("nohp");

                        kontakArrayList.add(new Kontak(id, name, email, addr, noHp));
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
                mSwipeRefreshLayout.setRefreshing(false);
                progressDialog.dismiss();

                kontakAdapter = new KontakAdapter(kontakArrayList);
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setAdapter(kontakAdapter);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                mSwipeRefreshLayout.setRefreshing(false);
                progressDialog.dismiss();
                Log.i("Volley Error : ", String.valueOf(error));
            }
        });

        rq.add(jsonObjectRequest);

    }
}

