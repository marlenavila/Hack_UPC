package com.example.marlen.hack_upc;

import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Jou on 20/2/2016.
 */
public class MongoUPCUsage {
    public void getServicio(String type,int MaxDist, final ArrayList<Service> s) throws JSONException {
        MongoUPC.get("", null, new JsonHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, cz.msebera.android.httpclient.Header[] headers, JSONArray response) {
                super.onSuccess(statusCode, headers, response);
                for (int i = 0; i < response.length();i++) {
                    JSONObject jsonobject = null;
                    try {
                        jsonobject = (JSONObject) response.get(i);
                    } catch (JSONException e) {
                        e.printStackTrace();
                        System.out.println("FUCK YOU!");
                    }
                    Service serv=new Service();
                    serv.setName (jsonobject.optString("Name"));
                    serv.setType (jsonobject.optString("Type"));
                    serv.setCity (jsonobject.optString("Address"));
                    serv.setMaxDist (jsonobject.optInt("Dist"));
                    serv.setTelNum (jsonobject.optInt("Contact"));
                    s.add(serv);
                }

            }
        });

    }

    public void SetService(Service s) throws JSONException{

    }
}
