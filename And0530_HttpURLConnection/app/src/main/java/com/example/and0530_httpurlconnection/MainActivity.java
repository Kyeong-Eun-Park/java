package com.example.and0530_httpurlconnection;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.PixelCopy;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    // 멀티쓰레딩 환경에서 메세지 출력을 위한 Handler 객체 생성
    Handler handler = new Handler();
    EditText etUrl;
    Button btnRequest;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUrl = findViewById(R.id.etUrl);
        btnRequest = findViewById(R.id.btnRequest);
        tvResult = findViewById(R.id.tvResult);

        btnRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strUrl = etUrl.getText().toString();

                // 쓰레드를 활용하여 입력받은 URL 요청을 통해 응답 데이터를 가져오기
                // => request() 메서드를 호출하여 작업 수행
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        request(strUrl);
                    }
                }).start();
//                new Thread(() -> request(strUrl).start());
            }
        });
    }// onCreate() 메서드 끝

    // 입력한 URL을 활용해 요청을 보낼 메서드 request(String Url)
    public void request(String strUrl){

        // 응답 페이지를 입력스트림으로 읽어들여 문자열 결합을 통해 저장할 변수 선언
        // => 문자열 결합이 잦은 경우 String 클래스 대신 StringBuilder 또는 StringBuffer 사용
        StringBuffer output = new StringBuffer(); // 멀티쓰레드 환경에서 안전

        try {
            // URL을 사용하여 HTTP 프로토콜을 통해 요청을 하기 위해서
            // 해당 URL을 관리하는 URL 객체 생성 필요
            URL url = new URL(strUrl); // MalformedURLException
            // URL 객체의 openConnection() 메서드를 호출하여 URL 접속 시도 후
            // 접속 성공 시 HttpURLConnection 객체 리턴받기
            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            // HttpUrlConnection 객체가 null이 아닐 경우
            // 타임아웃 시간 및 요청 방식 등 설정 후 입력데이터를 스트림으로 처리
            if(con != null){
                con.setConnectTimeout(10000); // 10000ms = 10초 연결 대시 시간 설정
                con.setRequestMethod("GET"); // 요청방식 설정("GET" 또는 "POST")
                con.setDoInput(true); // Connection 객체 입력 가능하도록 설정

                // 요청 결과 코드 리턴받기
                int responseCode = con.getResponseCode();
                // ex) responseCode 가 200이면 성공, 404는 Page Not Found 등 처리가능

                // 응답 페이지를 입력스트림으로 전달받아 버터에 모아서 TextView로 출력
                // InputStream(byte 단위) -> InputStreamReader(char 단위) -> BufferedReader(String 단위)
                BufferedReader buffer = new BufferedReader(
                        new InputStreamReader(con.getInputStream()));
                // 입력스트림이 연결된 BufferedReader 객체의 readLine() 메서드를 호출하여
                // 입력스트림을 문자열 형태로 1줄씩 가져오기 가능 -> 반복해서 전체 내용 가져오기
                String str = null; // 입력 스트림 데이터를 1줄 저장할 변수
                while(true){
                    str = buffer.readLine();

                    // 만약, 읽어온 문자열이 없을 경우 반복문 종료
                    if(str == null) break;

                    output.append(str + "\n");
                }

                // 자원반환
                buffer.close();
                con.disconnect(); // 연결 끊기
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 메세지를 출력하는 showMessage 메서드에 StringBuffer 객체를 문자열로 변환하여 전달
        showMessage(output.toString());
    }

    public void showMessage(String str){
        // 멀티쓰레딩 환경에서 메세지 출력을 위해 Handler
        handler.post(new Runnable() {
            @Override
            public void run() {
                tvResult.append(str + "\n");
            }
        });
//        handler.post(() -> tvResult.append(str + "\n"));
    }
}

