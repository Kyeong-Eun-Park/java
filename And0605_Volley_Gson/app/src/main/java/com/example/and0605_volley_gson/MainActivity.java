package com.example.and0605_volley_gson;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {

    EditText etUrl;
    Button btnRequest;
    ListView movieListView;
    MovieList movieList;

    static RequestQueue requestQueue;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUrl = findViewById(R.id.etUrl);
        btnRequest = findViewById(R.id.btnRequest);
        movieListView = findViewById(R.id.movieListView);

        btnRequest.setOnClickListener(view -> makeRequest());

        if(requestQueue == null){
            requestQueue = Volley.newRequestQueue(this);
        }
    }
    public void makeRequest(){
        String strUrl = etUrl.getText().toString();

        new StringRequest(
                Request.Method.GET,
                strUrl,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
//                        응답메세지 확인
//                        Log.d("response", response);
                        processResponse(response);
                    }

//                    응답 결과에 대한 데이터 후처리(JSON -> Gson 으로 관리)하기 위해
//                    processResponse() 메서드 정의
                    public void processResponse(String response){
                        Gson gson = new Gson();
                        movieList = gson.fromJson(response, MovieList.class);

                        MovieAdapter adapter = new MovieAdapter(MainActivity.this, movieList.boxOfficeResult.dailyBoxOfficeList);
                        movieListView.setAdapter(adapter);
                        adapter.notifyDataSetChanged();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }

        );

    }
}