package com.example.and0525_listview_custom;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // 1. 이미지 파일 ID 저장
    int[] imageId = {
      R.drawable.mov01, R.drawable.mov02, R.drawable.mov03, R.drawable.mov04,
      R.drawable.mov05, R.drawable.mov06, R.drawable.mov07, R.drawable.mov08,
      R.drawable.mov09, R.drawable.mov10
    };

    // 2. 영화 제목 저장
    String[] titles = {
      "써니", "완득이", "괴물", "라디오 스타", "비열한 거리",
      "왕의 남자", "아일랜드", "웰컴 투 동막골", "헬보이", "Back to the Future"
    };

    // 3. 영화 내용 저장
    String[] contents = {
            "전라도 벌교 전학생 나미는 긴장하면 터져 나오는 사투리 탓에 첫날부터 날라리들의 놀림감이 된다. 이때 범상치 않는 포스의 친구들이 어리버리한 그녀를 도와주는데… 그들은 진덕여고 의리짱 춘화, 쌍꺼풀에 목숨 건 못난이 장미, 욕배틀 대표주자 진희, 괴력의 다구발 문학소녀 금옥, 미스코리아를 꿈꾸는 사차원 복희 그리고 도도한 얼음공주 수지. 나미는 이들의 새 멤버가 되어 경쟁그룹 ‘소녀시대’와의 맞짱대결에서 할머니로부터 전수받은 사투리 욕 신공으로 위기상황을 모면하는 대활약을 펼친다. 일곱 명의 단짝 친구들은 언제까지나 함께 하자는 맹세로 칠공주 ‘써니’를 결성하고 학교축제 때 선보일 공연을 야심차게 준비하지만 축제 당일, 뜻밖의 사고가 일어나 뿔뿔이 흩어지게 된다.",
            "남들보다 키는 작지만 자신에게만은 누구보다 큰 존재인 아버지와 언제부터인가 가족이 되어버린 삼촌과 함께 사는 고등학생 완득이",
            "괴물은 나오는 영화",
            "안봐서 모르겠음",
            "친구끼리 싸우는 영화",
            "왕의 남자???",
            "이것도 안봐서...",
            "별로 안 웰컴",
            "헬창보이",
            "빽투더퓨처~~~"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.listView);

        // ArrayAdapter 대신 커스터마이징을 위한 클래스 (MyListViewAdapter) 인스턴스 생성
        MyListViewAdapter adapter = new MyListViewAdapter(this);

        listView.setAdapter(adapter);

        // 목록중 하나를 클릭 했을 경우 이벤트 처리
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int index, long id) {
                // 1. View 클래스의 inflate() 메서드를 호출하여 외부 레이아웃 연결
                View dialogView = View.inflate(
                        MainActivity.this, R.layout.listview_dialog, null);

                ImageView iv = dialogView.findViewById(R.id.ivItem);
                TextView title = dialogView.findViewById(R.id.tvTitle);
                TextView content = dialogView.findViewById(R.id.tvContent);

                iv.setImageResource(imageId[index]);
                title.setText(titles[index]);
                content.setText(contents[index]);
                // 만약, TextView 위젯에 스크롤 기능을 포함하려면 ScrollView 대신
                // setMovementMethod() 메서드를 호출하여 ScrollingMoveMentMethod 객체전달
                content.setMovementMethod(new ScrollingMovementMethod());

                // 다이얼로그 생성을 위해 AlertDialog.Builder 객체 생성
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);

                dialog.setTitle("영화 상세정보");
                dialog.setPositiveButton("닫기", null);

                // 다이얼로그에 표시할 View 객체를 setView() 메서드에 전달
                dialog.setView(dialogView);

                // 다이얼로그 표시
                dialog.show();
            }
        });

    } // onCreate() 메서드 끝

    // ListView에 표시할 항목을 커스터마이징 하기 위해
    // BaseAdapter 클래스를 상속받는 서브클래스 MyListViewAdapter 클래스 정의
    // => 추상메서드 4개 (getCount, getItem, getItemId, getView)
    private class MyListViewAdapter extends BaseAdapter {
        Context context;

        public MyListViewAdapter(Context context){ this.context = context; }

        @Override
        public int getCount() {
            return titles.length;
        }

        @Override
        public View getView(int index, View view, ViewGroup viewGroup) {
            // ListView 에 표시할 1개의 데이터 (레이아웃 담은 View 객체)를 생성하여 리턴하는 메서드
            // => 외부 레이아웃(list.xml)을 연결하여
            //    해당 레이아웃 내의 ImageView, TextView 에 접근하여 데이터를 설정하고
            //    해당 레이아웃을 담은 View 객체 리턴(Dialog 커스터마이징과 유사함)
            // 1. View 클래스의 inflate() 메서드 호출하여 레이아웃 연결
            View listViewLayout = View.inflate(context, R.layout.list, null);

            // 2. 1번에서 생성된 View 객체의 findViewById() 메서드를 호출하여
            //    list.xml 레이아웃 내의 위젯 ID연결
            ImageView iv = listViewLayout.findViewById(R.id.ivItem);
            TextView title = listViewLayout.findViewById(R.id.tvTitle);
            TextView content = listViewLayout.findViewById(R.id.tvContent);

            // 3. ImageView와 각각 TextView에 데이터 전달하여 표시
            iv.setImageResource(imageId[index]);
            title.setText(titles[index]);
            content.setText(contents[index]);

            // 4. 생성된 View 객체 리턴
            return listViewLayout;
        }


        @Override
        public Object getItem(int i) { return "영화"; }

        @Override
        public long getItemId(int i) { return 0; }
    }

}