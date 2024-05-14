package com.example.tpenca;


import android.util.Log;

import androidx.annotation.NonNull;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ApiClient implements Callback{
    private static final OkHttpClient client = new OkHttpClient();
    public String response123 = "";

    public static void fetchData(String url, Callback callback) {
        Request request = new Request.Builder()
                .url(url)
                .build();

        client.newCall(request).enqueue(callback);
    }

    @Override
    public void onFailure(@NonNull Call call, @NonNull IOException e) {
        e.printStackTrace();
    }

    @Override
    public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
        if (response.isSuccessful()) {
            String responseBody = response.body().string();
            Log.v("DATA" , responseBody);
            response123 = responseBody;
        } else {
            Log.e("EEEEEEEEEEEEEE" , "ERORORO");
        }
    }
}
