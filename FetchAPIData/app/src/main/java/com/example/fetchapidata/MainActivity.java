package com.example.fetchapidata;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    TextView txtId, txtResultType, txtTitle, txtDescription;

    Button btnFetch, btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtId = findViewById(R.id.movie_id);
        txtResultType = findViewById(R.id.resultType);
        txtTitle = findViewById(R.id.title);
        txtDescription = findViewById(R.id.description);

        btnFetch = findViewById(R.id.fetch);
        btnNext = findViewById(R.id.next);

        RequestQueue requestQueue = VolleySingleton.getInstance(this).getRequestQueue();

        btnFetch.setOnClickListener(view -> {
            String url = "https://imdb-api.com/en/API/SearchMovie/k_alx8rt6c/inception%202010";

            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {

                            try {
                                JSONArray resultArray = response.getJSONArray("results");
                                for (int i = 0; i < resultArray.length(); i++) {
                                    JSONObject jsonObject = resultArray.getJSONObject(i);

                                    String id = jsonObject.getString("id");
                                    String resultType = jsonObject.getString("resultType");
                                    String title = jsonObject.getString("title");
                                    String description = jsonObject.getString("description");

                                    txtId.setText(id);
                                    txtResultType.setText(resultType);
                                    txtTitle.setText(title);
                                    txtDescription.setText(description);

                                    Log.d("Printed", id + "* " + resultType + "* " + title + "* " + description);
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });

            requestQueue.add(jsonObjectRequest);
        });

        btnNext.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this, RecyclerActivity.class));
        });


    }
}