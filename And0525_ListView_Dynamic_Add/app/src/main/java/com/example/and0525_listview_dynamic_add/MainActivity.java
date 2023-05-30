package com.example.and0525_listview_dynamic_add;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etItem;
    Button btnAdd;
    ListView listView;

    ArrayList<String> itemList;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etItem = findViewById(R.id.etItem);
        btnAdd = findViewById(R.id.btnAdd);
        listView = findViewById(R.id.listView);

        itemList = new ArrayList<String>();
        adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, itemList
        );
        listView.setAdapter(adapter);

        btnAdd.setOnClickListener(view -> addData());

        // ListView 항목 롱클릭 시 클릭된 항목 삭제
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int index, long id) {
                itemList.remove(index);
                adapter.notifyDataSetChanged();
                return false;
            }
        });



    } // onCreate() 메서드 끝

    public void addData(){

        // 입력항목 길이가 0일때 입력 오류 처리
        if(etItem.length() == 0){
            return;
        }

        // EditText에 입력된 내용 가져와서 ArrayList에 추가
        itemList.add(etItem.getText().toString());

        // ArrayList에 항목 추가 후 ArrayAdapter 갱신 필수!
        adapter.notifyDataSetChanged();

        // EditText 입력란 초기화 및 커서 요청
        etItem.setText("");
        etItem.requestFocus();
    }



}