package com.example.and0420_radiobutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RadioButton rb1 = findViewById(R.id.rb1);
        RadioButton rb2 = findViewById(R.id.rb2);
        RadioGroup rGroup = findViewById(R.id.rGroup);

        Button btnOk = findViewById(R.id.btnOk);
        Button btnReset = findViewById(R.id.btnReset);

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                String result = "";
//                if(rb1.isChecked()){
//                    result = rb1.getText().toString();
//                } else if(rb2.isChecked()){
//                    result = rb2.getText().toString();
//                }
//
//                Toast.makeText(MainActivity.this, result, Toast.LENGTH_SHORT).show();

//                String result = "";
//                switch (rGroup.getCheckedRadioButtonId()) {
//                    case R.id.rb1: result = rb1.getText().toString(); break;
//                    case R.id.rb2: result = rb2.getText().toString(); break;
//                }
//                Toast.makeText(MainActivity.this, result, Toast.LENGTH_SHORT).show();

//                if(rGroup.getCheckedRadioButtonId() == 0 ){
//                    return;
//                }
                RadioButton rb = findViewById(rGroup.getCheckedRadioButtonId());
                Toast.makeText(MainActivity.this, rb.getText(), Toast.LENGTH_SHORT).show();
            }
        });

//        btnReset.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                rb1.setChecked(false);
////                rb2.setChecked(false);
//                rGroup.clearCheck();
//            }
//        });

        // 초기화
        btnReset.setOnClickListener(view -> rGroup.clearCheck());

    }
}