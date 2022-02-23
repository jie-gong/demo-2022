package com.example.gjtk12.net;

import org.json.JSONObject;

import java.io.IOException;

public interface OkHttpLo {
    void onFailure(IOException e);

    void onResponse(JSONObject jsonObject);
}
