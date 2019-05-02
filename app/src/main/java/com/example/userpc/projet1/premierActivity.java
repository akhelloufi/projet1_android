package com.example.userpc.projet1;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class premierActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
NewMessageNotification x=new NewMessageNotification();
    public void affiNote(View view) {
        x.notify(this,"coucou",12581);
    }
}
