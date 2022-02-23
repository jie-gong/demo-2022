package com.example.gjtk12;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity3 extends AppCompatActivity {

    private Toolbar toolbar;
    private TextView titleTv;
    private ImageView image1;
    private ImageView image2;
    private ImageView image3;
    private ImageView image4;
    private Button btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        initView();
        titleTv.setText("监控抓拍");

    }
    public void onClick(View view) {
        Intent intent = new Intent(this, MainActivity4.class);
        switch (view.getId()) {

            case R.id.image1:
                intent.putExtra("bh", 0);
                break;
            case R.id.image2:
                intent.putExtra("bh", 1);
                break;
            case R.id.image3:
                intent.putExtra("bh", 2);
                break;
            case R.id.image4:
                intent.putExtra("bh", 3);
                break;
            case R.id.btn_cancel:
                finish();
                break;
        }
        startActivity(intent);
    }

    private void initView() {
        toolbar = findViewById(R.id.toolbar);
        titleTv = findViewById(R.id.title_tv);
        image1 = findViewById(R.id.image1);
        image2 = findViewById(R.id.image2);
        image3 = findViewById(R.id.image3);
        image4 = findViewById(R.id.image4);
        btnCancel = findViewById(R.id.btn_cancel);
    }
}