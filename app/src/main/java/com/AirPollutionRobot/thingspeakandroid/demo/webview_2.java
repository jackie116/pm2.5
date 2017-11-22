package com.AirPollutionRobot.thingspeakandroid.demo;

import android.Manifest;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class webview_2 extends AppCompatActivity {

    private WebView mWebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview_2);

        mWebView = (WebView)findViewById(R.id.webView_2);

        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);   // 開啟Java Script 解譯功能

        //设置加载进来的页面自适应手机屏幕
        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(true);
        //支持屏幕缩放
        webSettings.setSupportZoom(true);
        webSettings.setBuiltInZoomControls(true);
        //不显示webview缩放按钮
        webSettings.setDisplayZoomControls(false);
        webSettings.setPluginState(WebSettings.PluginState.ON);


        // 設定轉址的網頁還是由WebView開啟，不要用外部的瀏覽器。
        mWebView.setWebViewClient(new WebViewClient());

        mWebView.loadUrl("http://www.dcint.com.tw");
    }




}
