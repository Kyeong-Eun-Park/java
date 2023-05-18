package com.example.and0518_explict_intent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Second extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);

        // MainActivity로부터 전달받은 intent 객체 가져와서 데이터(num1, num2) 꺼내기
        Intent intent = getIntent();
        int num1 = intent.getIntExtra("num1", 0);
        int num2 = intent.getIntExtra("num2", 0);

        int result = num1 + num2;

        Button btnReturn = findViewById(R.id.btnReturn);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Intent 객체 생성
                Intent returnIntent = new Intent(Second.this, MainActivity.class);

                // putExtra() 메서드 호출하여 리턴할 데이터 저장
                returnIntent.putExtra("result", result);

                // 현재 액티비티에서 리턴할 Intent 객체를 전달하기 위해서는
                // setResult() 메서드를 호출하여 응답코드(ResultCode)와 인텐트 객체 전달
                setResult(RESULT_OK, returnIntent);

                finish();
            }
        });

        Intent returnIntent = new Intent(Second.this, MainActivity.class);
        returnIntent.putExtra("result", result);
        setResult(RESULT_OK, returnIntent);
        finish();
    }
}
