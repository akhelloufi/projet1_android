package com.example.userpc.projet1;

import com.example.userpc.projet1.Ball;

public class Ballthread extends Thread {

    private Ball ball;

    public Ballthread(Ball ball) {
        this.setBall(ball);
    }

    public void run() {
        while (ball.getX() < 500) {
            ball.update();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public void setBall(Ball ball) {
        this.ball = ball;
    }

    public Ball getBall() {
        return ball;
    }
}