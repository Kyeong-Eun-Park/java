package com.example.and0518_implicit_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnDial = findViewById(R.id.btnDial);
        Button btnWeb = findViewById(R.id.btnWeb);
        Button btnGoogle = findViewById(R.id.btnGoogle);
        Button btnSearch = findViewById(R.id.btnSearch);
        Button btnSms = findViewById(R.id.btnSms);
        Button btnPhoto = findViewById(R.id.btnPhoto);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Uri uri = null;
                Intent intent = null;
                switch (view.getId()) {
                    case R.id.btnDial:
                        // 전화번호 입력을 위한 파라미터로 "tel:전화번호" 형식의 문자열을 전달
                        uri = Uri.parse("tel:01012345678");
                        intent = new Intent(Intent.ACTION_DIAL, uri);
                        startActivity(intent);
                        break;
                    case R.id.btnWeb:
                        uri = Uri.parse("http://www.itwillbs.co.kr");
                        intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                        break;
                    case R.id.btnGoogle:
                        // https://www.google.co.kr/maps/place
                        // 35.1584043 (위도), 129.0620349 (경도)
                        uri = Uri.parse("http://maps.google.com/maps?q=35.1584043,129.0620349");
                        intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                        break;

                    case R.id.btnSearch:
                        // Intent 객체 생성 시 ACTION_WEB_SEARCH 상수 전달 (Uri 객체 없음)
                        intent = new Intent(Intent.ACTION_WEB_SEARCH);
                        // intent 객체에 putExtra() 메서드를 호출하여 검색을 위한 키와 검색어 전달
                        // => 검색을 위한 키값은 SearchManager.QUERY 상수 사용(문자열 "query")
//                        intent.putExtra(SearchManager.QUERY, "아이티윌");
                        intent.putExtra("query", "아이티윌");
                        startActivity(intent);
                        break;
                    case R.id.btnSms:
                        intent = new Intent(Intent.ACTION_SENDTO);
                        // intent 객체의 putExtra() 메서드를 호출하여 문자 메세지 내용 저장
                        // => 키값으로 "sms_body" 문자열 전달
                        intent.putExtra("sms_body", "안녕하세요");

                        // intent 객체의 setData() 메서드를 호출하여 문자 메세지를 전송할 번호 저장
                        uri = Uri.parse("smsto:01012345678");
                        intent.setData(uri);
                        startActivity(intent);
                        break;
                    case R.id.btnPhoto:
                        // Intent 객체 생성 시 MediaStore.ACTION_IMAGE_CAPTURE 상수 전달 (Uri 객체 없음)
                        intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                        startActivity(intent);
                        break;

                }
            }
        };

        btnDial.setOnClickListener(listener);
        btnWeb.setOnClickListener(listener);
        btnGoogle.setOnClickListener(listener);
        btnSearch.setOnClickListener(listener);
        btnSms.setOnClickListener(listener);
        btnPhoto.setOnClickListener(listener);

    }
}