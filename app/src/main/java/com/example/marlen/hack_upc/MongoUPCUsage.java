package com.example.marlen.hack_upc;

import android.util.Log;

import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Jou on 20/2/2016.
 */
public class MongoUPCUsage {
    public static void getServicio(String type,double lon, double lat, final ArrayList<Service> s) throws JSONException {
        RequestParams params = new RequestParams();
        params.put("q","{\"Type\" : \"" + type + "\", \"Coordenadas\" :" +
                " {$near:{$geometry:{type:\"Point\", coordinates:[" + lon + ", " + lat + "]}}}}");
        params.put("c","0");
        MongoUPC.get("Services", params, new JsonHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, cz.msebera.android.httpclient.Header[] headers, JSONArray response) {
                //super.onSuccess(statusCode, headers, response);
                Log.v("JSONPORN", response.toString());
                for (int i = 0; i < response.length(); i++) {
                    JSONObject jsonobject = new JSONObject();
                    try {
                        jsonobject = response.getJSONObject(i);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    Service serv = new Service();
                    serv.setName(jsonobject.optString("Name"));
                    serv.setType(jsonobject.optString("Type"));
                    serv.setCity(jsonobject.optString("Address"));
                    serv.setMaxDist(jsonobject.optInt("Dist"));
                    serv.setTelNum(jsonobject.optInt("Contact"));
                    s.add(serv);
                }

            }
        });

    }

    public void SetService(Service s) throws JSONException{

    }
}
