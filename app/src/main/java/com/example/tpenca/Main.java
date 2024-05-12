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
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import org.json.JSONArray;
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
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import androidx.annotation.Nullable;

public class Main extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ll);

        fetch("localhost:8080",false);
    }

    private int count = -1;
    private LinkedList<Product> list = null;
    private JSONArray arr = null;
    private JSONObject li = null;

    public void fetch(String url,Boolean use){
        final TextView tv = ((TextView)findViewById(R.id.message));
        final ImageView iv = ((ImageView)findViewById(R.id.iv0));
        final ListView lv = (ListView)findViewById(R.id.lv);
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
                    count = j.getInt("count");
                    arr = j.getJSONArray("li");
                    list = new LinkedList<>();

                    for(int i = 0;i < count ;i++){
                        li = arr.getJSONObject(i);
                        list.add(new Product(li.getInt("id")
                                , li.getString("name")
                                , "todo update sample String"
                                , li.getDouble("price")
                                , li.getInt("quantity")
                                , li.getString("state"))
                        );

                    }

                } catch (JSONException e) {throw new RuntimeException(e);}

                tv.post(new Runnable() {
                    @Override
                    public void run() {
                        ProductAdapter adapter =  new ProductAdapter(
                                lv.getContext()
                                ,R.layout.layout
                                ,list
                        );
                        lv.setAdapter(adapter);
                        //tv.setText( list.get(0).getDesc());

                    }
                });
            }
        }.start();
    }

}
