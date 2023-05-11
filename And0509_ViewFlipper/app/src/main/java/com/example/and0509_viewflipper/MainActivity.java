package com.example.and0509_viewflipper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnPrev = findViewById(R.id.btnPrev);
        Button btnNext = findViewById(R.id.btnNext);
        ViewFlipper viewFlipper = findViewById(R.id.viewFlipper);

        btnPrev.setOnClickListener(view -> viewFlipper.showPrevious());
        btnNext.setOnClickListener(view -> viewFlipper.showNext());

        // ------------------------------------------------------------
        Button btnStart = findViewById(R.id.btnStart);
        Button btnStop = findViewById(R.id.btnStop);
        ViewFlipper viewFlipper2 = findViewById(R.id.viewFlipper2);

        btnStart.setOnClickListener(view -> {
            viewFlipper2.startFlipping();
            viewFlipper2.setFlipInterval(0);
        });
        btnStop.setOnClickListener(view -> viewFlipper2.stopFlipping());

    }
}