package com.example.and0516_activity_test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnNewActivity = findViewById(R.id.btnNewActivity);
        RadioButton btnSecond = findViewById(R.id.btnSecond);
        RadioButton btnThird = findViewById(R.id.btnThird);

        btnNewActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Class cl = null;

                if(btnSecond.isChecked()) cl = Second.class;
                else if(btnThird.isChecked()) cl = Third.class;

                Intent intent = new Intent(MainActivity.this, cl);
                startActivity(intent);

            }
        });
    }
}