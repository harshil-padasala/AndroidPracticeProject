package com.example.fetchapidata;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class VolleySingleton {

    private final RequestQueue requestQueue;
    private static VolleySingleton volleySingleton;

    private VolleySingleton(Context context) {
        requestQueue = Volley.newRequestQueue(context.getApplicationContext());
    }

    public static synchronized VolleySingleton getInstance(Context context) {
        if (volleySingleton == null) {
            volleySingleton = new VolleySingleton(context);
        }

        return volleySingleton;
    }

    public RequestQueue getRequestQueue() {
        return requestQueue;
    }
}
