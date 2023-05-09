package com.example.and0418_checkbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import java.util.StringJoiner;

public class MainActivity extends AppCompatActivity {
    CheckBox cbAnd, cbIPhone, cbWindow, cbAll;
    Button btnOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cbAnd = findViewById(R.id.cbAnd);
        cbIPhone = findViewById(R.id.cbIPhone);
        cbWindow = findViewById(R.id.cbWindow);
        cbAll = findViewById(R.id.cbAll);
        btnOk = findViewById(R.id.btnOk);

        // 전체선택
        cbAll.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
//                if(isChecked){
//                    cbAnd.setChecked(true);
//                    cbIPhone.setChecked(true);
//                    cbWindow.setChecked(true);
//                } else {
//                    cbAnd.setChecked(false);
//                    cbIPhone.setChecked(false);
//                    cbWindow.setChecked(false);
//                }

                cbAnd.setChecked(isChecked);
                cbIPhone.setChecked(isChecked);
                cbWindow.setChecked(isChecked);
            }
        });

        // 확인 버튼 클릭 시 현재 선택되어 있는 항목 Toast 메세지 출력
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 1번 방법
//                String items = ""; // 항목을 묶어서 저장할 변수
//
//                if(cbAnd.isChecked()){
//                    items += cbAnd.getText() + " / ";
//                }
//
//                if(cbIPhone.isChecked()){
//                    items += cbIPhone.getText() + " / ";
//                }
//
//                if(cbWindow.isChecked()){
//                    items += cbWindow.getText() + " / ";
//                }
//
//                items = items.substring(0, items.length() - 3);
//
//                Toast.makeText(MainActivity.this, items, Toast.LENGTH_SHORT).show();

                // 2번 방법
                CheckBox[] cbs = {cbAnd, cbIPhone, cbWindow};
                StringJoiner sj = new StringJoiner(" / ", "[ ", " ]");
                for(CheckBox cb : cbs){
                    if(cb.isChecked()) sj.add(cb.getText());
                }

                Toast.makeText(MainActivity.this, sj.toString(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}