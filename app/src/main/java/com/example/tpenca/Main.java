package com.example.tpenca;

import android.app.Activity;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.media.Image;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;
import androidx.annotation.Nullable;

public class Main extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ll);

        TextView t = ((TextView)findViewById(R.id.message));
        t.setText(getString(R.string.sample));

    }

    private String s = null;
    private String ss = null;
    private String sss = null;
    public void fetch(String url,Boolean use){
        final TextView tv = ((TextView)findViewById(R.id.message));
        final ImageView iv = ((ImageView)findViewById(R.id.iv));
        new Thread(){
            @Override
            public void run() {
                super.run();
                //s = j.getJSONObject("debug").getString("id");
                JSONObject j = null;
                if(use) {
                    HttpData hd = new HttpData(url,iv);
                    j = hd.getData();
                }
                try {
                    if(!use)
                        j = new JSONObject(getString(R.string.sample));
                    ss = j.getJSONObject("debug").getString("id");
                    sss = j.getJSONObject("debug").getString("login");
                    s = j.getString("error");

                } catch (JSONException e) {throw new RuntimeException(e);}

                tv.post(new Runnable() {
                    @Override
                    public void run() {
                        tv.setText(ss+"\n"+sss+"\n"+s);
                    }
                });
            }
        }.start();
    }

}
