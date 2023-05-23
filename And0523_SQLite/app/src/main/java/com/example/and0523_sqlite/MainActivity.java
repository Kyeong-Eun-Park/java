package com.example.and0523_sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // DB작업에 필요한 멤버변수 선언
    // 1.
    MyDbHelper myDbHelper;
    // 2.
    SQLiteDatabase sqlDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText etNum = findViewById(R.id.etNum);
        Button btnInsert = findViewById(R.id.btnInsert);
        Button btnSelect = findViewById(R.id.btnSelect);
        Button btnReset = findViewById(R.id.btnReset);
        TextView tvResult = findViewById(R.id.tvResult);

        // SQLiteOpenHelper 클래스 구현체 클래스 인스턴스 생성
        myDbHelper = new MyDbHelper(this); // 파라미터로 컨텍스트 객체 전달
        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //INSERT 작업 수행
                int num = Integer.parseInt(etNum.getText().toString());
                // 데이터 저장을 위해서 데이터베이스를 쓰기 가능 모드로 열기
                sqlDb = myDbHelper.getWritableDatabase();

                // PreparedStatement 객체처럼 만능문자(?)를 사용한 쿼리문 작성하는 경우
                // 1. 쿼리문 작성 (만능문자 ? 사용하여 데이터 부분을 대체)
                String sql = "INSERT INTO test VALUES (?)";

                // 2. SQLiteDatabase 객체의 compileStatement() 메서드를 호출하여 SQL 구문 전달 후
                // SQLiteStatement 객체 리턴받기
                // => JDBC에서 pstmt = con.preparedStatement(sql);
                SQLiteStatement stmt = sqlDb.compileStatement(sql);

                // 3. SQLiteStatement 객체의 bindXXX() 메서드를 호출하여
                // 만능문자(?)를 원하는 데이터로 대체
                // => JDBC에서 pstmt.setXXX() 메서드와 동일
                stmt.bindLong(1, num);

                // 4. SQLiteStatement 객체의 executeXXX() 메서드를 호출하여 쿼리 실행
                // => JDBC에서는 pstmt.executeUpdate() 메서드가 INSERT, UPDATE, DELETE 통합했으나
                // SQLite에서는 INSERT와 UPDATE & DELETE가 다름!
                stmt.executeInsert();

                // 5. SQLiteStatement 자원반환
                stmt.close();
                sqlDb.close();

                Toast.makeText(MainActivity.this, "입력성공!", Toast.LENGTH_SHORT).show();
            }
        });

        btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // SELECT 작업 수행
                // 조회 작업을 위해서 읽기 전용 모드로 열기
               sqlDb =  myDbHelper.getReadableDatabase();

                // SELECT 구문을 query() 또는 rawQuery() 메서드로 실행 후
                // 결과를 Cursor타입으로 리턴받기 => ResulSet 객체와 구조 유사함
               String sql = "SELECT * FROM test";
               Cursor cursor = sqlDb.rawQuery(sql, null);

               // 조회결과를 tvResult에 출력
                // while문을 사용하여 Cursor 객체의 마지막 레코드까지 반복해서 이동하기 위해
                // moveToNext() 메서드를 반복 호출
                // => JDBC에서 rs.next()와 동일
                String strResult = "";
                while(cursor.moveToNext()){
                    // rs.getXXX()
                    // Cursor 객체의 getXXX() 메서드를 호출하여 컬럼데이터 꺼내기
                    // => 주의! 파라미터로 전달할 컬럼번호는 0번부터 시작됨
                    strResult += cursor.getInt(0) + "\n";
                }
                tvResult.setText(strResult);

                cursor.close();
                sqlDb.close();
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // MyDbHelper 객체의 getXXXDatabase() 메서드를 호출하여 DB열기
                // => 쓰기 가능 모드 : getWritableDatabase() 메서드 호출 필요
                // => 읽기 전용 모드 : getReadableDatabase() 메서드 호출 필요

                // 테이블 갱신 작업을 위해 조작이 필요하므로 쓰기 가능 모드로 열기
                // 주의!! 초기화 작업 전 생성할 DB를 수동으로 생성한 경우 삭제 후 초기화 필요
                sqlDb = myDbHelper.getWritableDatabase();

                // MyDbHelper 객체의 onUpgrade() 메서드 호출하여 테이블 갱신
                myDbHelper.onUpgrade(sqlDb, 1, 2);

                // 작업이 끝난 후 자원반환
                sqlDb.close();
            }
        });

    } // onCreate() 메서드 끝

    // 데이터베이스 작업을 위해 SQLiteQpenHelper 클래스를 상속받는 구현체 클래스 정의
    // => onCreate(), onUpgrade() 메서드 오버라이딩(구현) 필수!
    // => 생성자 정의 필수
    private class MyDbHelper extends SQLiteOpenHelper {

        // 생성자 정의 - DB 생성 작업 담당
        public MyDbHelper(Context context) {
            // 컨텍스트 객체, DB명, Factory 객체, 버전번호
            super(context, "test_db", null, 1);
        }

        // 테이블 생성을 담당하는 onCreate() 메서드 정의
        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            String sql = "CREATE TABLE test(idx INT PRIMARY KEY)";
            sqLiteDatabase.execSQL(sql);
        }

        // 테이블 리셋을 담당하는 onUpgrade() 메서드 정의
        // => 기존 테이블 삭제 후 다시 생성 또는 기존 테이블 갱신
        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
            String sql = "DROP TABLE IF EXISTS test";
            sqLiteDatabase.execSQL(sql);

            // 테이블 재생성을 위해 onCreate() 메서드를 호출
            onCreate(sqLiteDatabase);
        }
    }
}