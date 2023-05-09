package com.example.and0425_picture_viewer;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CheckBox checkStart;
    TextView tvPet;
    RadioGroup rGroup;
    Button btnReset, btnFinish;
    ImageView ivPet;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkStart = findViewById(R.id.checkStart);
        tvPet = findViewById(R.id.tvPet);
        rGroup = findViewById(R.id.rGroup);
        btnReset = findViewById(R.id.btnReset);
        btnFinish = findViewById(R.id.btnFinish);
        ivPet = findViewById(R.id.ivPet);

        checkStart.setOnCheckedChangeListener((checkStart, isChecked) -> {

                int result = isChecked ? View.VISIBLE : View.INVISIBLE;
                tvPet.setVisibility(result);
                rGroup.setVisibility(result);
                ivPet.setVisibility(result);

        });

        rGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int selectedId) {

//                if(selectedId == R.id.rbDog) {
//                    Toast.makeText(MainActivity.this, "강아지", Toast.LENGTH_SHORT).show();
//                }

                switch (selectedId) {
                    case R.id.rbDog: ivPet.setImageResource(R.drawable.dog); break;
                    case R.id.rbCat: ivPet.setImageResource(R.drawable.cat); break;
                    case R.id.rbRabbit: ivPet.setImageResource(R.drawable.rabbit); break;
                }

            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkStart.setChecked(false);
//                tvPet.setVisibility(View.INVISIBLE);
//                rGroup.setVisibility(View.INVISIBLE);
//                ivPet.setVisibility(View.INVISIBLE);

                rGroup.clearCheck();

                ivPet.setImageResource(0);
            }
        });

        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}