package com.example.and0413_button_edittext;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
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

        EditText edit = findViewById(R.id.edit);
        TextView tv = findViewById(R.id.tv);
        Button btnOk = findViewById(R.id.btnOk);

        // Button 객체에 OnClickListener 를 연결하여 버튼 위젯 클릭 이벤트 처리하도록 구현
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // EditText 위젯에서 입력받은 텍스트를 가져오기
                // String str = edit.getText() // 리턴 타입이 Editable 이므로 저장 불가
                String str = edit.getText().toString(); // toString() 메서드 호출하여 형변환 필수!
                Toast.makeText(MainActivity.this, str, Toast.LENGTH_SHORT).show();

                // TextView 위젯에 출력
                tv.setText(str);
            }
        });

        // EditText 위젯에 키보드 입력을 감지하는 리스너 연결
        edit.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {

                // 주의! Toast 에서 출력할 메세지는 파라미터 타입이 문자열이므로
                // 정수 데이터를 전달할 경우 문법 오류가 발생하지 않고, 실행 시 논리적 오류 발생함
                // => 반드시 정수 -> 문자열로 변환하여 전달!
//                Toast.makeText(MainActivity.this, i + "", Toast.LENGTH_SHORT).show();
                if(keyCode == KeyEvent.KEYCODE_ENTER){
                    String str = edit.getText().toString();
                    tv.setText(str);
                }
                
                return false;
            }
        });
    }
}