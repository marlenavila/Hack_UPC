package com.example.marlen.hack_upc;

/**
 * Created by Jou on 20/2/2016.
 */

import com.loopj.android.http.*;

public class MongoUPC {
    private static final String BASE_URL = "https://api.mongolab.com/api/1/databases/hackupc/collections/";
    private static final String API_KEY = "t6Jm8gibg6IEHUJ9u7mlKQAv_lvVfm-c";

    private static AsyncHttpClient client = new AsyncHttpClient();

    public static void get(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        params.put("apiKey", API_KEY);
        client.get(getAbsoluteUrl(url), params, responseHandler);
    }

    public static void post(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        params.put("apiKey", API_KEY);
        client.post(getAbsoluteUrl(url), params, responseHandler);
    }

    private static String getAbsoluteUrl(String relativeUrl) {
        return BASE_URL;
    }
}
