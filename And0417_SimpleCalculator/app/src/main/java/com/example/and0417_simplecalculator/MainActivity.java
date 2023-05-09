package com.example.and0417_simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 위젯 ID 연결
        EditText edit1 = findViewById(R.id.edit1);
        EditText edit2 = findViewById(R.id.edit2);
        Button btnPlus = findViewById(R.id.btnPlus);
        Button btnSub = findViewById(R.id.btnSub);
        Button btnMul = findViewById(R.id.btnMul);
        Button btnDiv = findViewById(R.id.btnDiv);
        TextView tvResult = findViewById(R.id.tvResult);

        // 4단계 방식으로 listener 연결
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // edit1, edit2 에서 문자가져와서 숫자로 변경
                int num1 = Integer.parseInt(edit1.getText().toString());
                int num2 = Integer.parseInt(edit2.getText().toString());
//                Toast.makeText(MainActivity.this, num1 + ", " + num2, Toast.LENGTH_SHORT).show();
                // 사칙연산 (+)
                int result = 0;
                switch (view.getId()) {
                    case R.id.btnPlus: result = num1 + num2; break;
                    case R.id.btnSub: result = num1 - num2; break;
                    case R.id.btnMul: result = num1 * num2; break;
                    case R.id.btnDiv: result = num1 / num2; break;
                }
                tvResult.setText("계산결과: " + result);
            }
        };

        btnPlus.setOnClickListener(listener);
        btnSub.setOnClickListener(listener);
        btnMul.setOnClickListener(listener);
        btnDiv.setOnClickListener(listener);

    }
}