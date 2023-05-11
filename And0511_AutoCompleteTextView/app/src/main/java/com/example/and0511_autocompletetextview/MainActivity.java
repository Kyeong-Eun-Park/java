package com.example.and0511_autocompletetextview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AutoCompleteTextView autoCom = findViewById(R.id.autoCom);
        MultiAutoCompleteTextView multiCom = findViewById(R.id.multiCom);

        // 자동완성에 사용될 후보 단어 목록을 저장할 String[] 배열 생성
        String[] items = {
          "Java", "Javascript", "JSP Model 1", "JSP Model2",
          "Android", "HTML", "HTTP 기초", "Apache Server",
          "자바", "자바스크립트"
        };

        // =======================================================
        // AutoCompleteTextView: 자동완성 기준에 적합한 갯수의 글자가 입력되면
        //                       관련된 단어가 있을 경우 목록으로 표시하고
        //                       해당 목록의 단어를 선택하면 자동으로 입력하는 위젯
        // 후보 단어 목록을 ArrayAdapter 객체를 사용하여 생성
        // => 단어로 사용될 데이터가 String 타입이므로 제네릭 타입 String 지정
        // => 파라미터 : Context 객체, 목록을 표시할 형태 (레이아웃), 목록으로 사용될 배열
        //    => 목록 표시 형태는 안드로이드에서 제공하는 레이아웃을 로딩하여 사용
        //       (android.R.layout.XXX 형태의 상수로 제공됨 => 주의! R.layout 이 아님!!)
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_dropdown_item_1line ,items
        );

        autoCom.setAdapter(adapter);

        // =======================================================
        // MultiAutoCompleteTextView : AutoCompleteTextView와 기본 동작은 동일하지만
        // 하나의 단어만 자동완성하는 것이 아니라, 단어 완성 후 콤마(,)를 붙여서
        // 다음 단어도 자동완성으로 동작하도록 하는 위젯
        List<String> items2 = Arrays.asList(items); // 배열 -> List 객체로 변환

        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(
                this, android.R.layout.simple_dropdown_item_1line, items2
        );
        multiCom.setAdapter(adapter2);

        // 자동완성 단어를 콤마(,)로 구분하기 위해 CommaTokenizer 객체 생성
        // => AutoCompleteTextView 와 달라지는 부분
        MultiAutoCompleteTextView.CommaTokenizer tokenizer =
            new MultiAutoCompleteTextView.CommaTokenizer();

        multiCom.setTokenizer(tokenizer);

    }
}