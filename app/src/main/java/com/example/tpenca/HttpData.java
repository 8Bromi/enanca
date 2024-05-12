package com.example.tpenca;

import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpData  {

    String res = null;
    HttpURLConnection conn = null;
    OutputStream out = null;
    InputStream in = null;
    BufferedReader r = null;
    String result = null;
    URL url = null;
    ImageView imgv = null;
    public HttpData(String u,ImageView imgvv){
        try {//
            this.imgv = imgvv;
            url = new URL(u);
        } catch (MalformedURLException e) {url = null;}
    }
    public JSONObject getData() {
        setConn();
        setOut();
        setIn();
        setBuff();
        setString();
        try {
            JSONObject json = new JSONObject(result);
            Log.v("Success",json.toString());
            return json;

        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public void setConn() {
        try {
            if(url == null)
                url = new URL("https://belatar.name/rest/profile.php?login=test&passwd=test&id=xxxx");
            conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setChunkedStreamingMode(0);
            Log.v("Success", "Conn");
        } catch (Exception e) {
            Log.e("Err", "Conn");
        }
    }



    public void setOut(){
        try {
            conn.getOutputStream();
            Log.v("Success", "out");
        } catch (IOException e) {
            Log.e("Err", "out");
        }
    }

    public void setIn(){
        try {
            in = new BufferedInputStream(conn.getInputStream());
            Log.v("Success", "In");
        } catch (IOException e) {
            Log.e("Err", "in");
        }
    }

    public void setBuff(){
        try {
            r = new BufferedReader(new InputStreamReader(in));
            Log.v("Success", "Buffreader");
        }catch(Exception e){
            Log.e("Err", "Buffreeader");
        }
    }

    public void setString()  {
        try {
            StringBuilder sb = new StringBuilder();
            String line = null;
            while((line = r.readLine()) != null) {
                sb.append(line).append('\n');
            }
            result = sb.toString();
            Log.v("Success", "Reading");
        }catch(IOException e){
            Log.e("Err", "reading");
        }
    }




}