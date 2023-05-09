package com.example.and0509_webview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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

        MyWebViewClient myWebViewClient = new MyWebViewClient();
        webView.setWebViewClient(myWebViewClient);

        btnGo.setOnClickListener(view -> goUrl());
    }

    public void goUrl(){
        String url = etUrl.getText().toString();

        webView.loadUrl(url);
    }

    class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            return super.shouldOverrideUrlLoading(view, url);
        }
    }
}