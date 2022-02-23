package com.example.gjtk12;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.gjtk12.net.OkHttpLo;
import com.example.gjtk12.net.OkHttpTo;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private TextView titleTv;
    private EditText plateEt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        titleTv.setText("车辆违章");
    }
    private static final String TAG = "MainActivity";
    public void CX(View view){
        if (TextUtils.isEmpty(plateEt.getText().toString())) {
            Toast.makeText(this, "请输入车牌号", Toast.LENGTH_SHORT).show();
        }
        final String cp = "鲁" + plateEt.getText().toString().toUpperCase();
        getPeccancy(cp);
    }
    private void getPeccancy(String cp) {
        new OkHttpTo().setUrl("get_peccancy_plate")
                .setJsonObject("UserName", "user1")
                .setJsonObject("plate", cp)
                .setOkHttpLo(new OkHttpLo() {
                    @Override
                    public void onFailure(IOException e) {
                        Toast.makeText(MainActivity.this, "没有查询到" + cp + "车的违章数据！", Toast.LENGTH_SHORT).show();
                    }
                    @Override
                    public void onResponse(JSONObject jsonObject) {
                        JSONArray jsonArray = jsonObject.optJSONArray("id");
                        if (jsonArray.length() == 0) {
                            Toast.makeText(MainActivity.this, "没有查询到" + cp + "车的违章数据！", Toast.LENGTH_SHORT).show();
                        } else {
                            String[] ids = new String[jsonArray.length()];
                            for (int i = 0; i < jsonArray.length(); i++) {
                                ids[i] = jsonArray.optString(i);
                            }
                            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                            intent.putExtra("id", ids);
                            intent.putExtra("plate", cp);
                            startActivity(intent);
                        }
                    }
                }).start();
    }
    private void initView() {
        titleTv = findViewById(R.id.title_tv);
        plateEt = findViewById(R.id.plate_et);
    }
}