package com.example.and0511_login_dialog_exam;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String dbId = "admin";
    String dbPass = "1234";

    Button btnLogin, btnAddr;
    TextView tvId, tvPass, tvAddr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin = findViewById(R.id.btnLogin);
        tvId = findViewById(R.id.tvId);
        tvPass = findViewById(R.id.tvPass);

        // 로그인 버튼 클릭 시 다이얼로그 생성하여 표시
        // 1) AlertDialog.Builder 객체 생성
        // 2) setTitle 제목설정 : 로그인 정보 입력
        // 3) setIcon 아이콘 지정
        // 4) setNegativeButton, setPositiveBotton 등
        // 5) 객체.show()
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                // => 주의! 현재 구현체 클래스 내이므로 this 대신 액티비티명.this 사용

                dialog.setTitle("로그인 정보 입력");
                dialog.setIcon(R.drawable.ic_menu_allfriends);

                // -------------------------------------
                // 다이얼로그 커스마이징을 위한 레이아웃 삽입
                // => layout 폴더 내의 login_dialog.xml 파일 내용을
                //    현재 생성된 다이얼로그 컨텐츠로 사용
                // => 외부 XML 파일을 불러오려면 Inflate 기능을 사용하여 메모리에 로딩 후
                //    필요한 객체에 전달하여 사용해야함
                // 1. 레이아웃 (XML 파일) 메모리에 로딩하기
                //    => View.inflate() 메서드 호출하여 XML 로딩하기
                View loginDialogView = View.inflate(
                        MainActivity.this, R.layout.login_dialog, null);
                // 2. 레이아웃을 현재 다이얼로그에 표시하기
                //    => AlertDialog.Builder 객체의 setView() 메서드를 호출하여 레이아웃 표시
                dialog.setView(loginDialogView);
                // -------------------------------------

                // 확인 버튼 클릭 시 다이얼로그 내의 EditText 에서 입력된 ID, Password 가져온 후
                // activity_main.xml 의 TextView 에 출력하기
                dialog.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // EditText 위젯 ID를 가져오기
//                        EditText etId = findViewById(R.id.etId);
                        // => 주의! 문법적 오류는 발생하지 않지만, 해당 객체에 접근하여 할 경우
                        //    NullPointerException 이 발생하게 된다!
//                        String id = etId.getText().toString();

                        EditText etId = loginDialogView.findViewById(R.id.etId);
                        EditText etPass = loginDialogView.findViewById(R.id.etPass);
                        String id = etId.getText().toString();
                        String pass = etPass.getText().toString();

                        if(id.equals(dbId) && pass.equals(dbPass)){
                            // TextView 위젯에 ID, Password 값 출력 후
                            // "로그인 성공" Toast 메시지 출력
                            tvId.setText("아이디 : " + id);
                            tvPass.setText("패스워드 : " + pass);
                            Toast.makeText(MainActivity.this, "로그인 성공", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(MainActivity.this, "로그인 실패", Toast.LENGTH_SHORT).show();
                        }

                    }
                });
                dialog.setNegativeButton("취소", null);

                dialog.show();
            }
        });

        // -----------------------------------------------------------------------------------
        // 주소 입력 버튼에 대한 이벤트 처리
        // 주소 입력 버튼 클릭시 다이얼로그 호출
        // => 이때, address_dialog.xml 표시!
        // 입력받은 주소를 activity_main.xml 에 표시
        btnAddr = findViewById(R.id.btnAddr);
        tvAddr = findViewById(R.id.tvAddr);

        btnAddr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("주소 정보 입력");

                View addrDialog = View.inflate(
                        MainActivity.this, R.layout.address_dialog, null);
                dialog.setView(addrDialog);

                dialog.setNegativeButton("취소", null);
                dialog.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        EditText etAddr = addrDialog.findViewById(R.id.etAddr);
                        String addr = etAddr.getText().toString();
                        tvAddr.setText("주소 : " + addr);
                    }
                });


                dialog.show();
            }
        });


    }
}