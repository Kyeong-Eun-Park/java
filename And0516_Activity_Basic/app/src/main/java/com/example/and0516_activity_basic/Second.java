package com.example.and0516_activity_basic;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

// AppCompatActivity 상속 필수!
public class Second extends AppCompatActivity {
    // protected onCreate() 메서드 오버라이딩 필수!
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);

        Button btnReturn = findViewById(R.id.btnReturn);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Button btnThirdActivity = findViewById(R.id.btnThirdActivity);
        btnThirdActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Second.this, Third.class);
                startActivity(intent);
            }
        });

    }
}
