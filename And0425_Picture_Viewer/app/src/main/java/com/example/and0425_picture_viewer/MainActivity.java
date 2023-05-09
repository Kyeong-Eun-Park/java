package com.example.and0425_picture_viewer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
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

        // 1. 체크박스 체크 시 tvPet, rGroup, ivPet Visible 처리
        //    체크 해제시 Invisible 처리
        checkStart.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
//                if(isChecked){
//                    tvPet.setVisibility(View.VISIBLE);
//                    rGroup.setVisibility(View.VISIBLE);
//                    ivPet.setVisibility(View.VISIBLE);
//                } else {
//                    tvPet.setVisibility(View.INVISIBLE);
//                    rGroup.setVisibility(View.INVISIBLE);
//                    ivPet.setVisibility(View.INVISIBLE);
//                }

                Toast.makeText(MainActivity.this, "onCheckedChanged", Toast.LENGTH_SHORT).show();

                int result = isChecked ? View.VISIBLE : View.INVISIBLE;
                tvPet.setVisibility(result);
                rGroup.setVisibility(result);
                ivPet.setVisibility(result);
            }
        });


        // 2. 라디오 버튼 선택시 해당하는 이미지를 ivPet에 표시
        rGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int selectedId) {
//                if(selectedId == R.id.rbDog){
//                    Toast.makeText(MainActivity.this, "강아지", Toast.LENGTH_SHORT).show();
//                }

                switch (selectedId) {
                    case R.id.rbDog: ivPet.setImageResource(R.drawable.dog); break;
                    case R.id.rbCat: ivPet.setImageResource(R.drawable.cat); break;
                    case R.id.rbRabbit: ivPet.setImageResource(R.drawable.rabbit); break;
                }
            }
        });

        // 3. 초기화 버튼 클릭 시 숨김처리(tvPet, rGroup, ivPet Inviisible) 및
        //    체크박스와 라디오버튼 선택 해제
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // checkStart 해제
                checkStart.setChecked(false);

                // tvPet, rGroup, ivPet Invisible
                // 체크박스 초기화 시 자동으로 리스너를 통해 숨김처리가 동작
//                tvPet.setVisibility(View.INVISIBLE);
//                rGroup.setVisibility(View.INVISIBLE);
//                ivPet.setVisibility(View.INVISIBLE);

                // rGroup clear
                rGroup.clearCheck();

                // 이미지 초기화
                ivPet.setImageResource(0);
            }
        });


        // 4. 종료 버튼 클릭 시 프로그램 끝내기
        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                finish();
                finishAndRemoveTask();
            }
        });

    }
}