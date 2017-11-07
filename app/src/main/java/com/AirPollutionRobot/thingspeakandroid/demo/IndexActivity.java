package com.AirPollutionRobot.thingspeakandroid.demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.IOException;

public class IndexActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);

        getNewThread();

        ImageButton nextPageBtn = (ImageButton)findViewById(R.id.button01);
        nextPageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(IndexActivity.this  , DemoActivity.class);
                startActivity(intent);
            }
        });
        Button web_1 = (Button)findViewById(R.id.web_1);
        web_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(IndexActivity.this  , webview_1.class);
                startActivity(intent);
            }
        });


    }

    private void makeGetRequest() {
        try {
            HttpClient client = new DefaultHttpClient();
            HttpGet request = new HttpGet("http://140.115.197.16/?school=tku&app=airpollutionrobot&year=106");
            HttpResponse response = client.execute(request);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private  void getNewThread() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                makeGetRequest();
            }
        });
        thread.start();
    }
}
