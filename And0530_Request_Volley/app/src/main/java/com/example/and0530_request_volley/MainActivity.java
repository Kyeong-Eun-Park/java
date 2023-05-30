package com.example.and0530_request_volley;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    EditText etUrl;
    Button btnRequest;
    TextView tvResult;

    // 요청(Request) 객체를 저장할 RequestQueue 타입 변수 선언
    static RequestQueue requestQueue; // 한 번 생성 후 재사용하기 위해 static변수 선언

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUrl = findViewById(R.id.etUrl);
        btnRequest = findViewById(R.id.btnRequest);
        tvResult = findViewById(R.id.tvResult);

        btnRequest.setOnClickListener(view -> makeRequest());

        // 요청큐가 비어있을 경우 생성
        // Volley.newRequestQueue() 메서드를 호출하여 현재 액티비티(컨텍스트) 전달
        if(requestQueue == null) requestQueue = Volley.newRequestQueue(this);
    } // onCreate() 메서드 끝

    public void makeRequest() {
//        String strUrl = etUrl.getText().toString();
        String strUrl = "http://10.0.0.2:8082/funding/admin/memberList?id=admin&passwd=1234";
//        strUrl = "http://192.168.6.200:8081/MVC_Board/board/MemberLoginPro.me?id=admin&passwd=1234";

        // StringRequest 객체 생성
        // 파라미터
        // 1) 요청방식 (Request.Method.XXX 상수 지정)
        // 2) 요청 URL
        // 3) 응답에 대한 리스너 구현 => Response.Listener 의 구현체 전달
        // => $.ajax() 에서 success : function(){}
        // 4) 에러에 대한 리스너 구현 => Response.ErrorListener 의 구현체 전달
        StringRequest request = new StringRequest(
                Request.Method.GET,
                strUrl,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response){
                        showMessage("응답 => " + response);
                    }
                },
//            response -> {},
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error){
                        showMessage("에러 => " + error.getMessage());
                    }
                }
        ){ // getParams() 메서드 오버라이딩(POST방식 요청일 경우 구현해야하는 부분)
            // => StringRequest 객체 생성자 뒤에 바디 {} 를 구현해야함

            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                // HashMap 타입 객체 (String, String)를 생성하여 리턴
                Map<String, String> params = new HashMap<>();
                params.put("id", "admin");
                params.put("passwd", "1234");
                return params;
            }
        };

        // 요청객체 (StringRequest) 생성 완료 후 요청 큐에 추가하기
        // => RequestQueue 객체의 add() 메서드를 호출하여 요청 객체를 전달
        // => 만약, 이전 요청의 응답결과를 사용하지 않도록 설정하려면
        // 요청 객체의 setShouldCache() 메서드 호출하여 false값 전달
        request.setShouldCache(false);
        requestQueue.add(request);

    } // makeRequest 끝

    public void showMessage(String str){
        tvResult.append(str + "\n");
    }
}