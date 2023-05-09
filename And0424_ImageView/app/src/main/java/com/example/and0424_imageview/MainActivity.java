package com.example.and0424_imageview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView iv = findViewById(R.id.iv);
        ImageButton iBtn = findViewById(R.id.iBtn);
        Button btn = findViewById(R.id.btn);
        ImageButton toggle = 0;

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iv.setImageResource(R.drawable.dog);
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iv.setImageResource(R.drawable.horse);
            }
        });

        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "ImageView 클릭됨", Toast.LENGTH_SHORT).show();
            }
        });

        iv.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                toggle = 1;
                iv.setImageResource(R.drawable.ic_launcher_background);
                return false;
            }
        });
    }

}