package com.example.userpc.projet1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Main4Activity extends AppCompatActivity {
    TextView c1;
    String valeurReturn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        Bundle x= getIntent().getBundleExtra("bund1");

          valeurReturn =x.getString("cle1");
       c1 =findViewById(R.id.c1);

    }

    public void gogogo(View view) {
        c1.setText(valeurReturn);
    }
}
