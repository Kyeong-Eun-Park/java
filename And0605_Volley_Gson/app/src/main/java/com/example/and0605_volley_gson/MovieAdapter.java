package com.example.and0605_volley_gson;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

// BaseAdapter 클래스를 상속받는 MovieAdapter 클래스 정의
public class MovieAdapter extends BaseAdapter {

    Context context; // 액티비티 객체를 전달받을 Context 타입 변수 선언
    ArrayList<Movie> dailyBoxOfficeList; // 영화목록 정보를 저장하는 ArrayList<Movie> 타입 변수 선언

    public MovieAdapter(Context context, ArrayList<Movie> dailyBoxOfficeList){
        this.context = context;
        this.dailyBoxOfficeList = dailyBoxOfficeList;
    }

    @Override
    public int getCount() {
        return dailyBoxOfficeList.size();
    }

    @Override
    public Object getItem(int i) {
        return dailyBoxOfficeList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int index, View view, ViewGroup viewGroup) {
        // View.inflate() 메서드를 호출하여 movie_item.xml 레이아웃 View 객체로 가져오기(연결)
        View itemLayout = View.inflate(context, R.layout.movie_item, null);

        ImageView ivItemImage = itemLayout.findViewById(R.id.ivItemImage);
        TextView tvMovieNm = itemLayout.findViewById(R.id.tvMovieNm);
        TextView tvAudiCnt = itemLayout.findViewById(R.id.tvAudiCnt);

        // TODO 영화이미지는 나중에

        tvMovieNm.setText(dailyBoxOfficeList.get(index).movieNm);
        tvAudiCnt.setText(dailyBoxOfficeList.get(index).audiCnt);

        return itemLayout;
    }
}
