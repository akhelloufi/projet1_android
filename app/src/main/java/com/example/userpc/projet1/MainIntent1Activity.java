package com.example.userpc.projet1;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainIntent1Activity extends Activity {

    @Override
    @SuppressLint("WrongViewCast")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_intent1);

       // ImageButton bimg1=(ImageButton)findViewById(R.id.bimg1);
        EditText et1=(EditText)findViewById(R.id.et1);
        Button b2=(Button)findViewById(R.id.button2);
        MainIntent1Activity x=this;//context

        b2.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
               Toast t= Toast.makeText(x, "salut sava ", Toast.LENGTH_LONG);
               t.show();
            }
        });

    }
}
