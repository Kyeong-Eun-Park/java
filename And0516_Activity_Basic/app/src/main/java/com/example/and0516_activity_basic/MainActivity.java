package com.example.and0516_activity_basic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 버튼 클릭 시 새 액티비티 전환하기
        Button btnNewActivity = findViewById(R.id.btnNewActivity);
        btnNewActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Intent 객체를 생성하여 Second 클래스를 전환클래스로 지정하고
                // startActivity() 메서드를 호출하여 intent 객체 전달
                Intent intent = new Intent(MainActivity.this, Second.class);
                startActivity(intent);
            }
        });

    }
}