package com.example.userpc.projet1;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Main2Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Button b1=findViewById(R.id.buttonIsta);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //click ici
                try {
                    Toast.makeText(Main2Activity.this, "message envoyer", Toast.LENGTH_LONG).show();
                    SmsManager s = SmsManager.getDefault();
                    s.sendTextMessage("+212628698760", "0215", "salam " + this.toString(), null, null);
                }catch(Exception ex){
                    Log.e( "",ex.getMessage());
                }
            }
        });
    }
}
