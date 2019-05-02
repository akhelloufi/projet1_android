package com.example.userpc.projet1;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public class Ball extends View {
    private float x;
    private float y;
    private final int r;
    private final Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Canvas canvas;
    private Bitmap titleGraphic;
    private int screenW;
    private int screenH;

    public Ball(Context context, float x, float y, int r) {
        super(context);
        mPaint.setColor(0xFFFF0000);
        this.x = x;
        this.y = y;
        this.r = r;
        titleGraphic =  BitmapFactory.decodeResource(getResources(),
                R.drawable.ic_launcher_background);
    }

    public void update() {
        x++;
    }
    @Override
    public void onSizeChanged (int w, int h, int oldw,  int oldh){
             super.onSizeChanged(w, h, oldw, oldh);
             screenW = w;
             screenH = h;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //canvas.drawCircle(x, y, r, mPaint);
       // this.canvas=canvas;
        canvas.drawBitmap(titleGraphic,screenW-titleGraphic.getWidth(), 0, null);
        this.canvas=canvas;
    }
    public boolean onTouchEvent(MotionEvent event) {
        int eventaction = event.getAction();
        int X = (int)event.getX();
        int Y = (int)event.getY();
        switch (eventaction ) {
        case MotionEvent.ACTION_DOWN:          break;
        case MotionEvent.ACTION_MOVE:          break;
        case MotionEvent.ACTION_UP:
            x=X;
            y=Y;
            break;
        }
        invalidate();
        return true;
    }


    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public int getR() {
        return r;
    }

    public void setCanvas(Canvas canvas) {
        this.canvas = canvas;
    }

    public Canvas getCanvas() {
        return canvas;
    }

}