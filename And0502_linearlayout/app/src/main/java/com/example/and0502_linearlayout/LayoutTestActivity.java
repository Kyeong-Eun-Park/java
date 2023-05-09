package com.example.and0502_linearlayout;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

// 화면을 구성하는 액티비티 클래스는 반드시 AppCompatActivity 클래스를 상속받아 정의!
// => onCreate() 메서드를 오버라이딩하여 초기 코드 작성
public class LayoutTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
