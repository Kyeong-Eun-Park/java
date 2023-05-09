package com.example.and0413_padding_margin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn5 = findViewById(R.id.btn5);

        // 주의! setContentView() xml 파일을 읽어올때는 clickable = false였지만
        // setOnClickListener 이벤트를 연결하면서 clickable = true 가 됨
        btn5.setOnClickListener(view -> {
            Toast.makeText(this, "버튼5 클릭!", Toast.LENGTH_SHORT).show();
        });

        btn5.setClickable(false);

    }
}