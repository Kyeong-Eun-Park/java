package com.example.and0518_explict_intent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etNum1, etNum2;
    Button btnAdd;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNum1 = findViewById(R.id.etNum1);
        etNum2 = findViewById(R.id.etNum2);
        btnAdd = findViewById(R.id.btnAdd);
        
        // 더하기 버튼 클릭 시 새 액티비티 (Second)로 전환
        // => 이때, 명시적 인텐트를 사용하며, 입력받은 정수 2개를 포함하여 전달
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // EditText 위젯에 입력된 2개의 숫자 가져오기(입력 여부 판별 생략)
                int num1 = Integer.parseInt(etNum1.getText().toString());
                int num2 = Integer.parseInt(etNum2.getText().toString());

                // Intent 객체 생성
                Intent intent = new Intent(MainActivity.this, Second.class);

                // Intent 객체에 데이터 저장
                intent.putExtra("num1", num1);
                intent.putExtra("num2", num2);

//                startActivity(intent); // 응답을 리턴받을 수 없는 액티비티 전환
                startActivityForResult(intent, 0);
                // => 요청코드(requestCode)는 여러 액티비티로부터 응답이 리턴되어야 하는 경우
                //    각 응답 액티비티를 구분할 목적으로 사용함

            }
        });
    } // onCreate() 메서드 끝
    
    // 다른 액티비티에서 응답을 전달받기 위해 onActivityResult() 메서드가 자동으로 호출됨
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // 만약, 여러 액티비티로 부터 응답이 돌아오는 경우
//        if(requestCode == 0){ // Second로 부터 왔으면~~~
//
//        } else if(){
//
//        }

        // resultCode가
        if(resultCode == RESULT_OK){
            int result = data.getIntExtra("result", 0);
            Toast.makeText(this, result+"", Toast.LENGTH_SHORT).show();
        }


    }
}