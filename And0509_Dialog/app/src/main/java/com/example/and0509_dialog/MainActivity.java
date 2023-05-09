package com.example.and0509_dialog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.StringJoiner;

public class MainActivity extends AppCompatActivity {

    int selectedItem = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    
    public void showListDialog(View view){
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);

        dialog.setTitle("좋아하는 과목은?");
        dialog.setIcon(R.mipmap.ic_launcher_round);

        String[] listItems = {"Java", "JSP", "Android", "Spring"};
        dialog.setItems(listItems, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int index) {
                Toast.makeText(MainActivity.this, listItems[index], Toast.LENGTH_SHORT).show();
            }
        });

        dialog.setNegativeButton("취소", null);
        dialog.setNeutralButton("중립", null);
//        dialog.setPositiveButton("확인", null);

        dialog.show();
    }

    public void showRadioDialog(View view){
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);

        dialog.setTitle("좋아하는 과목은?");
        dialog.setIcon(R.mipmap.ic_launcher_round);
        String[] listItems = {"Java", "JSP", "Android", "Spring"};

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
    public void showCheckboxDialog(View view){
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);

        dialog.setTitle("좋아하는 과목은?");
        dialog.setIcon(R.mipmap.ic_launcher_round);
        String[] listItems = {"Java", "JSP", "Android", "Spring"};
        boolean[] checkItems = {true, true, false, false};

        dialog.setMultiChoiceItems(listItems, checkItems, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int index, boolean isChecked) {
//                checkItems[index] = isChecked;
            }
        });

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