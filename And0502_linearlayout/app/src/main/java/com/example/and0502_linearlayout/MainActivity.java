package com.example.and0502_linearlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_main);

        /*
        * [ 자바 코드를 사용하여 레이아웃을 직접 생성하기 ]
        * 1. LinearLayout 객체 생성
        *    => 현재 액티비 클래스 객체를 전달해야하므로 레퍼런스 this를 파라미터로 전달
        * 2. LinearLayout 객체의 setXXX() 메서드를 호출하여 속성 설정
        *    => 필수 속성 중 orientation 속성 변경 위해 setOrientation() 메서드 호출
        * -----------------------------------------------------------------------
        * [ 레이아웃 내에서 표시할 위젯 생성하기 ]
        * 3. 생성할 위젯의 객체 생성
        * 4. 위젯 속성 변경
        * -----------------------------------------------------------------------
        * [ 생성된 위젯과 레이아웃을 각각 표시하기 ]
        * 5. 생성된 레이아웃에 생성된 위젯 표시 (addView())
        * 6. 레이아웃을 액티비티에 표시 (setContentView())
        * */

        LinearLayout layout = new LinearLayout(this);
        // => 현재 액티비티 객체 (AppCompatActivity 클래스를 상복받은 객체)를 파라미터로 전달
        layout.setOrientation(LinearLayout.VERTICAL);   // orientation 속성을 VERTICAL로 변경

        // 버튼 위젯 생성을 위한 Button 객체 생성
        Button btn = new Button(this);
        // 1. 버튼 텍스트 변경
        btn.setText("버튼");
        // 2. 버튼 텍스트 사이즈 변경
        btn.setTextSize(20);
        // 3. 버튼 크기 변경을 위해 LayoutParams 객체를 생성하여 WIDTH, HEIGHT 값 설정
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );
        // 4. 지정된 레이아웃 크기를 담은 LayoutParams 객체를
        //    Button 객체의 setLayoutParams() 메서드 호출하여 파라미터로 전달
        btn.setLayoutParams(params);

        // 5. 생성된 레이아웃 객체의 addView() 메서드 호출하여 Button 객체를 파라미터로 전달
        layout.addView(btn);

        // 6. setContentView() 메서드를 호출하여 생성된 레이아웃 객체를 파라미터로 전달하여 표시
        setContentView(layout);


    }
}