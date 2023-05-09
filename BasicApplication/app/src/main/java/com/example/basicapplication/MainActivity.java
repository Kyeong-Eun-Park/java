package com.example.basicapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Button 위젯을 자바 코드에서 접근하기 위한 방법
        // 1. Button 위젯 ID를 연결하여 Button 객체 가져오기
        Button btn = findViewById(R.id.btn);

        // 2. Button 객체를 사용하여 버튼 클릭 시 동작할 리스너를 연결하여 이벤트 처리
        // => 버튼 관련 이벤트를 처리하는 리스너 : OnClickListener
        // => 리스너 연결을 위해서는 해당 객체의 setXXXListener() 메서드 호출
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "버튼2 클릭!", Toast.LENGTH_SHORT).show();
            }
        });

        btn.setOnClickListener(view -> {
            Toast.makeText(this, "람다식 적용!", Toast.LENGTH_SHORT).show();
        });
    }

    public void btnClick(View view){
        Toast.makeText(this, "Hello, World 클릭됨!", Toast.LENGTH_SHORT).show();
    }

    public void btnClick2(View view){
        Toast.makeText(this, "버튼 클릭됨!", Toast.LENGTH_SHORT).show();
//        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.naver.com"));
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:010-1234-5678"));
        startActivity(intent);
    }

}