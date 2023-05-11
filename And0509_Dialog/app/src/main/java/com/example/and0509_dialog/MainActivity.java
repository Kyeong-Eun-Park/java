package com.example.and0509_dialog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.StringJoiner;

public class MainActivity extends AppCompatActivity {

    int selectedItem = -1;  // 선택 항목에 대한 인덱스를 저장할 변수 선언
    // => 리스너 구현체 내부에서 접근하기 위해서는 final로 선언하거나 멤버변수로 선언해야함

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showListDialog(View view){
        // 1. new AlertDialog.Builder() 객체 생성
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);

        dialog.setTitle("좋아하는 과목은?");
        dialog.setIcon(R.mipmap.ic_launcher_round);

        // 목록 대화상자 출력을 위해 목록으로 사용할 데이터를 배열로 생성
        String[] listItems = {"Java", "JSP", "Android", "SPRING"};
        dialog.setItems(listItems, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int index) {
                Toast.makeText(MainActivity.this, listItems[index], Toast.LENGTH_SHORT).show();
            }
        });

        dialog.setNegativeButton("취소", null);
        dialog.setNeutralButton("중립", null);
        dialog.setPositiveButton("확인", null);

        dialog.show();

    }

    // 라디오버튼 형태 목록 다이얼로그
    public void showRadioDialog(View view){
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);

        dialog.setTitle("좋아하는 과목은?");
        dialog.setIcon(R.mipmap.ic_launcher_round);
        String[] listItems = {"Java", "JSP", "Android", "SPRING"};

        dialog.setSingleChoiceItems(listItems, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int index) {
                selectedItem = index;
            }
        });

        dialog.setPositiveButton("확인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, listItems[selectedItem], Toast.LENGTH_SHORT).show();
            }
        });


        dialog.show();
    }

    // 체크박스 형태 목록 다이얼로그
    public void showCheckboxDialog(View view){
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);

        dialog.setTitle("좋아하는 과목은?");
        dialog.setIcon(R.mipmap.ic_launcher_round);
        String[] listItems = {"Java", "JSP", "Android", "SPRING"};
        boolean[] checkItems = {true, true, false, false};
//        boolean[] checkItems = null;
        // => null 과 목록배열크기를 넘어서는 배열은 오류가 발생하지 않지만
        //    항목 갯수보다 모자란 배열은 오류 발생!

        dialog.setMultiChoiceItems(listItems, checkItems, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int index, boolean isChecked) {
//                checkItems[index] = isChecked;
            }
        });

        // 확인 버튼 클릭 시 선택된 체크박스 항목 출력
        // ex) "Java Android" 형식으로 출력
        dialog.setPositiveButton("확인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int index) {
                StringJoiner sj = new StringJoiner(", ");
                for(int i = 0; i < checkItems.length; i++){
                    if(checkItems[i]) sj.add(listItems[i]);
                }
                Toast.makeText(MainActivity.this, sj.toString(), Toast.LENGTH_SHORT).show();
            }
        });

        dialog.show();
    }
}