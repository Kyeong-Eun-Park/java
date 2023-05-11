package com.example.and0509_webview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText etUrl;
    Button btnGo, btnBack;
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUrl = findViewById(R.id.etUrl);
        btnGo = findViewById(R.id.btnGo);
        btnBack = findViewById(R.id.btnBack);
        webView = findViewById(R.id.webView);

//        MyWebViewClient myWebViewClient = new MyWebViewClient();
//        webView.setWebViewClient(myWebViewClient);
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return super.shouldOverrideUrlLoading(view, url);
            }
        });

        WebSettings webSettings = webView.getSettings();
        webSettings.setBuiltInZoomControls(true);   // 줌 기능 설정
        webSettings.setJavaScriptEnabled(true); // 자바스크립트 허용 설정
//        String url = "http://192.168.3.123:8089/FoodCode/";
//        webView.loadUrl(url);

        btnGo.setOnClickListener(view -> goUrl());

    }

    public void goUrl(){
        String url = etUrl.getText().toString();
        webView.loadUrl(url);
    }

    // WebView 위젯 동작을 위해 WebViewClient 클래스를 상속받는 서브클래스 정의 - 내부클래스
    class MyWebViewClient extends WebViewClient {
        // shouldOverrideUrlLoadding() 메서드 오버라이딩
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            return super.shouldOverrideUrlLoading(view, url);
        }
    }


}