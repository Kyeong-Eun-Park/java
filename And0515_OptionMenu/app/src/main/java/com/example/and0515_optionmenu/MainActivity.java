package com.example.and0515_optionmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    LinearLayout baseLayout;
    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        baseLayout = findViewById(R.id.baseLayout);
        iv = findViewById(R.id.iv);
    }

    // 옵션 메뉴를 등록하기 위해서는 onCreateOptionsMenu() 메서드 오버라이딩 필수!
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        // 메뉴 XML 파일을 메모리에 로딩하기 위해서는 MenuInflater 객체 사용 필요
        // => getMenuInflater() 메서드를 호출하여 MenuInflater 객체 가져온 후
        //    inflate() 메서드를 호출하여 로딩할 XML 파일과 Menu 객체 전달
//        MenuInflater menuInflater = getMenuInflater();
//        menuInflater.inflate(R.menu.menu, menu);

        // =========================================================================
        // 자바코드로 옵션메뉴 생성하기
        // 메서드 파라미터로 전달되는 menu 객체의
        // add() 메서드르르 호출하여 각 메뉴 항목 추가
        // groupId, itemId, order, title
        menu.add(0,1,0,"배경색(빨강)");
        menu.add(0,2,0,"배경색(초록)");
        menu.add(0,3,0,"배경색(파랑)");
        // 서브메뉴 생성시에는 SubMenu 객체를 사용
        // => Menu 객체의 addSubMenu() 메서드를 호출하여 SubMenu 객체 생성하고
        //    SubMenu 객체의 add() 메서드를 호출하여 각 서브메뉴 항목 추가
        SubMenu sMenu = menu.addSubMenu("버튼 변경(서브메뉴) >>");
        sMenu.add(0, 4, 0, "이미지 회전");
        sMenu.add(0, 5, 0, "이미지 확대");

        return true;
    }

    // 옵션메뉴의 항목 클릭 시 동작 처리를 위해서는 onOptionsItemSelected() 메서드 오버라이딩 필수!
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);

//        switch (item.getItemId()){
//            case R.id.itemRed:      baseLayout.setBackgroundColor(Color.RED); break;
//            case R.id.itemGreen:    baseLayout.setBackgroundColor(Color.GREEN); break;
//            case R.id.itemBlue:     baseLayout.setBackgroundColor(Color.BLUE); break;
//            case R.id.subItemRotate:
//                iv.setRotation(iv.getRotation() + 30);
//                break;
//            case R.id.subItemExpand:
//                iv.setScaleX(iv.getScaleX() + 1);
//                iv.setScaleY(iv.getScaleY() + 1);
//                break;
//        }

        // ========================================================================
        // 자바코드로 옵션메뉴 생성하여 switch문에서 비교할때
        // case문의 값을 itemId 정수값(1,2,3...) 사용
        switch (item.getItemId()){
            case 1: baseLayout.setBackgroundColor(Color.RED); break;
            case 2: baseLayout.setBackgroundColor(Color.GREEN); break;
            case 3: baseLayout.setBackgroundColor(Color.BLUE); break;
            case 4:
                iv.setRotation(iv.getRotation() + 30);
                break;
            case 5:
                iv.setScaleX(iv.getScaleX() + 1);
                iv.setScaleY(iv.getScaleY() + 1);
                break;
        }

        return true;
    }
}