package com.example.and0420_switch_togglebutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Switch sw1 = findViewById(R.id.sw1);
        TextView tv = findViewById(R.id.tv);
        Switch swSub = findViewById(R.id.swSub);

        // sw1이 on 되었을때
        // 1. TextView와 swSub visible 처리
        // 2. ToastMessage로 Wi-Fi ON 출력
        // sw1이 off 되었을때
        // 1. TextView와 swSub gone 처리
        // 2. ToastMessage로 Wi-Fi OFF 출력
        sw1.setOnCheckedChangeListener((compoundButton, isChecked) -> {

            String result = "Wi-Fi ";
            int res = 0;
            if(isChecked){
                result += "ON";
                res = View.VISIBLE;
            } else {
                result += "OFF";
                res = View.INVISIBLE;
            }

            tv.setVisibility(res);
            swSub.setVisibility(res);

            Toast.makeText(this, result, Toast.LENGTH_SHORT).show();

        });





    }
}