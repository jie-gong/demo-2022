package com.example.gjtk12;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity4 extends AppCompatActivity {

    private Toolbar toolbar;
    private TextView titleTv;
    private ImageView imageJkzp;
    private Button jkzpCancel;
    int[] images = {R.drawable.weizhang5, R.drawable.weizhang6, R.drawable.weizhang7, R.drawable.weizhang5};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        initView();
        titleTv.setText("");
        int bh = getIntent().getIntExtra("bh", 0);
        imageJkzp.setImageResource(images[bh]);
        imageJkzp.setOnTouchListener(new ImageListener(imageJkzp));
    }
    public void FH(View view)
    {
        Intent intent=new Intent(MainActivity4.this,MainActivity3.class);
        startActivity(intent);
    }
    private void initView() {
        toolbar = findViewById(R.id.toolbar);
        titleTv = findViewById(R.id.title_tv);
        imageJkzp = findViewById(R.id.image_jkzp);
        jkzpCancel = findViewById(R.id.jkzp_cancel);
    }
}