package com.example.userpc.projet1;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.Toast;

public class principaleActivity extends Activity {
    private WebView myWebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principale);
        Button  b1=(Button)findViewById(R.id.b1);
        myWebView = (WebView) findViewById(R.id.activity_main_webview);
        myWebView.loadUrl("http://www.google.com");
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
b1.setOnClickListener(this::afficher);

     }

    public void afficher(View v){
        Toast.makeText(this,"salut demarrer ",Toast.LENGTH_LONG).show();

    }
}
