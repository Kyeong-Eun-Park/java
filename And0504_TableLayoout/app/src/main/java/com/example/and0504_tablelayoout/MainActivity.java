package com.example.and0504_tablelayoout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etNum1, etNum2;
    Button btn0 ,btn1 ,btn2 ,btn3 ,btn4 ,btn5 ,btn6 ,btn7 ,btn8 ,btn9;
    Button btnAdd, btnSub, btnMul, btnDiv;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator);

        etNum1 = findViewById(R.id.etNum1);
        etNum2 = findViewById(R.id.etNum2);

        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);

        btnAdd = findViewById(R.id.btnAdd);
        btnSub = findViewById(R.id.btnSub);
        btnMul = findViewById(R.id.btnMul);
        btnDiv = findViewById(R.id.btnDiv);

        tvResult = findViewById(R.id.tvResult);

        // EditText 자판 안올라오게 설성
//        etNum1.setInputType(InputType.TYPE_NULL);
//        etNum2.setInputType(0);

        // --------------------------------------------
        // 0 ~ 9 까지의 숫자버튼에 대한 입력 처리
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 현재 포커스 되어있는 위젯(EditText) 가져오기
                EditText etNum = (EditText)getCurrentFocus();

                if(etNum == null){
                    return;
                }

                Button btn = (Button)view;
                String strNum = etNum.getText().toString();

                if(strNum.equals("0")){
                    strNum = "";
                }

                strNum += btn.getText().toString();
                etNum.setText(strNum);

            }
        };
        btn0.setOnClickListener(listener);
        btn1.setOnClickListener(listener);
        btn2.setOnClickListener(listener);
        btn3.setOnClickListener(listener);
        btn4.setOnClickListener(listener);
        btn5.setOnClickListener(listener);
        btn6.setOnClickListener(listener);
        btn7.setOnClickListener(listener);
        btn8.setOnClickListener(listener);
        btn9.setOnClickListener(listener);

        View.OnClickListener calcListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int num1 = Integer.parseInt(etNum1.getText().toString());
                int num2 = Integer.parseInt(etNum2.getText().toString());

                int result = 0;
                switch (view.getId()){
                    case R.id.btnAdd: result = num1 + num2; break;
                    case R.id.btnSub: result = num1 - num2; break;
                    case R.id.btnMul: result = num1 * num2; break;
                    case R.id.btnDiv: result = num1 / num2; break;
                }

                tvResult.setText("계산결과: " + result);
            }
        };
        btnAdd.setOnClickListener(calcListener);
        btnSub.setOnClickListener(calcListener);
        btnMul.setOnClickListener(calcListener);
        btnDiv.setOnClickListener(calcListener);



    }
}