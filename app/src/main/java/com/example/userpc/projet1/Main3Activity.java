package com.example.userpc.projet1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
    }

    public void gogo(View view) {
        Bundle x=new Bundle();
        x.putString("cle1","amine");
        Intent i=new Intent(this,Main4Activity.class);
        i.putExtra("bund1",x);
        startActivity(i);
    }
}
