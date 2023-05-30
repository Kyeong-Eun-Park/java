package com.example.and0525_listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.listView);
        
        // ListView 에 표시될 데이터를 String[] 타입으로 생성
        // => List 타입 객체 (ArrayList) 생성해도 저장 가능
        String[] strList = {
          "Java", "JSP Model 1", "JSP Model 2", "Android", "Oracle Database", "MySQL Database",
          "Linux", "HTML5", "CSS3", "스프링 프레임워크", "Network Programming", "JDBC",
          "AJAX", "JSON", "Javascript"      
        };

        // ArrayAdapter 객체를 생성(제네릭 타입은 표시할 목록의 데이터타입으로 지정)
        // => 파라미터로 현재 액티비티, 리스트뷰 모양, 표시할 데이터 객체 전달
        // => 안드로이드에서 제공되는 레이아웃(android.R.layout.simple_list_item_XXX 값) 사용
        // -----------------------------------------------------------------------------
        // 1. 목록을 단순 목록 형태로 나열하기 위한 기본 목록 모양 지정
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
//                this, android.R.layout.simple_list_item_1, strList
//        );
        // -----------------------------------------------------------------------------
        // 2. 목록을 라디오버튼 형태로 표시하여 단일 또는 다중 선택이 가능하도록 지정
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
//                this, android.R.layout.simple_list_item_single_choice, strList
//        );

        // ListView 객체의 setChoiceMode() 메서드를 호출하여 선택 형식 지정 필수!
        // => 기본값 비선택 모드 (AbsListView.CHOICE_MODE_NONE) 이며 CHOICE_MODE_XXX 상수를 사용하여 선택
//        listView.setChoiceMode(AbsListView.CHOICE_MODE_NONE);
//        listView.setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);
//        listView.setChoiceMode(AbsListView.CHOICE_MODE_MULTIPLE);
        // -----------------------------------------------------------------------------
        // 3. 목록을 체크박스 형태로 표시하여 단일 또는 다중 선택이 가능하도록 지정
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_multiple_choice, strList
        );
//        listView.setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);
        listView.setChoiceMode(AbsListView.CHOICE_MODE_MULTIPLE);
        listView.setAdapter(adapter);

        // ListView 항목 클릭 시 동작할 이벤트 처리: OnItemClickListener 연결
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int index, long id) {
                Toast.makeText(MainActivity.this, strList[index], Toast.LENGTH_SHORT).show();
                Toast.makeText(MainActivity.this, id + "", Toast.LENGTH_SHORT).show();
            }
        });






        


    }
}