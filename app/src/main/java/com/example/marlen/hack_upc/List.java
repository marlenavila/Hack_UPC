package com.example.marlen.hack_upc;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import org.json.JSONException;

import java.util.ArrayList;

public class List extends AppCompatActivity {

    RecyclerView recView;
    LinearLayoutManager manager;
    MyCustomAdapter myCustomAdapter;
    final ArrayList<Service> myawesomearraylistofservices = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        recView = (RecyclerView)findViewById(R.id.mRecyclerView);
        manager = new LinearLayoutManager(this);

        Bundle b = getIntent().getExtras();
        try {
            MongoUPCUsage.getServicio(b.getString("type"),b.getDouble("lon"),b.getDouble("lat"),myawesomearraylistofservices);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        recView.setLayoutManager(manager);

        myCustomAdapter = new MyCustomAdapter();
        recView.setAdapter(myCustomAdapter);
        myCustomAdapter.setData(myawesomearraylistofservices);

    }
}
