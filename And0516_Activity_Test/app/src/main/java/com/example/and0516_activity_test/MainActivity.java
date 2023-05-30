package com.example.and0516_activity_test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RadioGroup rGroup = findViewById(R.id.rGroup);
        Button btnNewActivity = findViewById(R.id.btnNewActivity);
        btnNewActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Class cls = null;
                switch (rGroup.getCheckedRadioButtonId()){
                    case R.id.rbSecond: cls = Second.class; break;
                    case R.id.rbThird:  cls = Third.class;  break;
                }
                Intent intent = new Intent(MainActivity.this, cls);
                startActivity(intent);
            }
        });
    }
}