package com.example.helloworld.Controller;

import com.example.helloworld.Ball;
import com.example.helloworld.Game;
import com.example.helloworld.view.LabCanvas;
import javafx.scene.control.Alert;

public class BallManager implements Runnable{

    private Game game;
    private LabCanvas canvas;
    private int ballspeed= 20;
    public BallManager(Game c, LabCanvas canvas) {
        this.game=c;
        this.canvas=canvas;
    }

    public int getBallspeed() {
        return ballspeed;
    }

    public void setBallspeed(int speed) {
        System.out.println(speed);
    }

    @Override
    public void run() {
        Ball ball = game.getBall();
        int counter=0;
        while(true)
        {
            counter++;
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            ball.move();

            if (ball.getPosX()<10)
            {
                //player 2 has scored, add code here
                game.getPlayer2().setScore(1);
                canvas.drawGame(game);
                ball.setPosX(300);
                ball.setStepY(325);
                ball.setStepX(1);
                ball.setStepY(1);
            }
            if (ball.getPosX()>game.getDimensionX()-ball.getRadius())
            {
                //player 1 has scored, add code here
                game.getPlayer1().setScore(1);
                canvas.drawGame(game);
                ball.setPosX(300);
                ball.setStepY(325);
                ball.setStepX(-1);
                ball.setStepY(-1);
            }

            if (ball.getPosY()> game.getDimensionY() - 2* (ball.getRadius()))
            {
                ball.setStepY(-1);
            }

            if (ball.getPosY()< 5)
            {
                ball.setStepY(1);
            }

            //Player 1 Racket
            // check both horizontal and vertical copnditions

            if (ball.getPosX()<(game.getPlayer1().getRacket().getPosX() + game.getPlayer1().getRacket().getThickness())){
                if (ball.getPosY()> game.getPlayer1().getRacket().getPosY()) {
                    if (ball.getPosY()<game.getPlayer1().getRacket().getPosY()+game.getPlayer1().getRacket().getSize())
                    {
                        ball.setStepX(1);
                    }
                }
            }

            //Player 2 Racket
            if (ball.getPosX()<(game.getPlayer2().getRacket().getPosX())){
                if (ball.getPosY()> game.getPlayer2().getRacket().getPosY()) {
                    if (ball.getPosY()<game.getPlayer2().getRacket().getPosY()+game.getPlayer2().getRacket().getSize())
                    {
                        ball.setStepX(-1);
                    }
                }
            }

            // CODE to CHECK BOUNCING WITH RACKET
            canvas.drawGame(game);
        }
    }
}
