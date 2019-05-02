package com.example.userpc.projet1;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.*;

public class Main3SommeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(new GameView(this));

        Ball b=new Ball(this,10,20,20);
       /* Ballthread t=new Ballthread(b);
        t.start();*/
        //setContentView(b);


       // setContentView(R.layout.activity_main3_somme);
        //recuperer les view par id
      /*  Button  cal=(Button )findViewById(R.id.calculer)  ;//cast
        EditText a=(EditText)findViewById(R.id.a);
        EditText b=(EditText)findViewById(R.id.b);
        TextView  resultat=(TextView)findViewById(R.id.resultat);
        //on creer evenement clicklistener
        //stocker this dans une variable globale sera le context de l activity
        Main3SommeActivity c=this;
        cal.setOnClickListener(new View.OnClickListener() {
            //classe anonyme
            @Override
            public void onClick(View v) {
                //ici le code apres click sur le button
                //on veut faire une Cancatenation de a et b dans resultat
                String va=a.getText().toString();
                String vb=b.getText().toString();
                //si on veut faire la somme il faut convertir
                //va et vb vers int ou double
              Integer na=  Integer.valueOf(va);
                Integer nb=  Integer.valueOf(vb);
                Integer s=na+nb;
                resultat.setText(s.toString());
                //on teste
            }
        });
*/
    }
}

class GameView extends View {

    private GameLoop mainLoop;
    Bitmap gameBitmap;
    Canvas gameCanvas;

    public GameView(Context context) {
        super(context);
        this.setDrawingCacheEnabled(true);

        gameCanvas = new Canvas();

        mainLoop = new GameLoop(getResources(), gameCanvas);
        mainLoop.start();
    }

    @SuppressLint("DrawAllocation") @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        int w = MeasureSpec.getSize(widthMeasureSpec);
        int h = MeasureSpec.getSize(heightMeasureSpec);

        gameBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);

        gameCanvas.setBitmap(gameBitmap);

        setMeasuredDimension(w, h);
    }

    @Override
    public void onDraw(Canvas canvas) {
        canvas.drawBitmap(gameBitmap, 0, 0, new Paint());
        invalidate();
    }

}

class GameLoop extends Thread {

    private float frameRate = 60;
    private float frameTime = 1000 / frameRate;

    private Game logicGame;
    private Resources gameResources;
    private Canvas gameCanvas;

    public GameLoop(Resources res, Canvas canvas) {
        logicGame = new Game(res, canvas);
    }

    @Override
    public void run()
    {
        while (true) {
            float startTime = System.currentTimeMillis();

            logicGame.Update();
            logicGame.Draw();

            float endTime = System.currentTimeMillis();
            long deltaTime = (long) (frameTime - (endTime - startTime));
            try {
                Thread.sleep(deltaTime);
            } catch (InterruptedException e) {
            }
        }
    }

}

class Game {
    private Resources resources;
    private Canvas canvas;

    private int x = 0;
    private Paint paint;

    public Game(Resources res, Canvas cas) {
        resources = res;
        canvas = cas;

        paint = new Paint();
        paint.setTextSize(50);
    }

    public void Draw() {
        canvas.drawColor(Color.WHITE);
        canvas.drawRect(new Rect(x, 0, x + 50, 50), paint);
    }

    public void Update() {
        x += 1;
        Log.d("DEBUG", "X: " + x);
    }
}
