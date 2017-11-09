package com.AirPollutionRobot.thingspeakandroid.demo;


import android.Manifest;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.webkit.GeolocationPermissions;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;


public class webview_1 extends AppCompatActivity {
    /**
     * WebChromeClient subclass handles UI-related calls
     * Note: think chrome as in decoration, not the Chrome browser
     */
    public class GeoWebChromeClient extends WebChromeClient {
        @Override
        public void onGeolocationPermissionsShowPrompt(String origin,GeolocationPermissions.Callback callback) {
            // Always grant permissiojn since the app itself requires location
            // permission and the user has therefore already granted it
            callback.invoke(origin, true, false);
        }
    }

    private WebView mWebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview_1);


        Toast.makeText(getApplication(), "https://env.healthinfo.tw/air/", Toast.LENGTH_SHORT).show();

        mWebView = (WebView)findViewById(R.id.webView);

        ActivityCompat.requestPermissions(this, new String[]{
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION
        }, 0);


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
        webSettings.setGeolocationEnabled(true);

        mWebView.setWebChromeClient(new GeoWebChromeClient(){
            @Override
            public void onGeolocationPermissionsShowPrompt(String origin, GeolocationPermissions.Callback callback) {
                callback.invoke(origin, true, false);
                super.onGeolocationPermissionsShowPrompt(origin, callback);
            }
        });


        // 設定轉址的網頁還是由WebView開啟，不要用外部的瀏覽器。
        mWebView.setWebViewClient(new WebViewClient());

        mWebView.loadUrl("https://env.healthinfo.tw/air/");
        //mWebView.loadUrl("https://google.com.tw");
    }
}
