package com.example.helloworld.view;
import com.example.helloworld.Ball;
import com.example.helloworld.Game;
import com.example.helloworld.Player;
import com.example.helloworld.Racket;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class LabCanvas  extends Canvas {

    public LabCanvas(double width, double height) {
        super(width, height);;



//        Text player1 = new Text (10, 20, "Player1");
//        player1.setFill(Color.RED);
//        Text player2 = new Text (10, 20, "Player2");
//        player2.setFill(Color.WHITE);
//        player1.setX(50);
//        player1.setY(50);
    }


    public void drawGame(Game game) {

        GraphicsContext gc = this.getGraphicsContext2D();
        drawBackground(gc);
        drawBall(gc, game.getBall());
        drawRacket(gc, game.getPlayer1().getRacket());
        drawRacket(gc, game.getPlayer2().getRacket());
        drawTitle(gc, game.getPlayer1());
        drawTitle(gc, game.getPlayer2());
        playerName(gc, game.getPlayer1());
        playerName(gc, game.getPlayer2());
        playerScore(gc, game.getPlayer1());
        playerScore(gc, game.getPlayer2());
        resetSize(game);
    }


    private void resetSize(Game game) {
        this.setWidth(game.getDimensionX());
        this.setHeight(game.getDimensionY());
    }


    private void drawTitle(GraphicsContext gc, Player player) {
        //To Do
    }


    private void drawBackground(GraphicsContext gc) {
        gc.setFill(Color.BLACK);
        gc.clearRect(0,0, this.getWidth(), this.getHeight());
        gc.fillRect(0,0,this.getWidth(), this.getHeight());
    }


    private void drawBall(GraphicsContext gc, Ball ball)
    {
        /*System.out.println("DRAW ball "+ ball.getPosX()+","+ball.getPosY()+","+ball.getRadius());*/
        gc.setFill(Color.YELLOWGREEN);
        gc.fillOval(ball.getPosX(), ball.getPosY(), ball.getRadius(), ball.getRadius());
    }


    private void drawRacket(GraphicsContext gc, Racket racket)
    {
        /*System.out.println("DRAW Racket "+ racket.getPosX()+","+racket.getPosY()+","+racket.getThickness()+"x"+racket.getSize());*/
        gc.setFill(racket.getColor());
        gc.fillRect(racket.getPosX(), racket.getPosY(), racket.getThickness(), racket.getSize());
    }


    private void playerName(GraphicsContext gc, Player player)
    {
        /*System.out.println("in canvas derawing name "+player.getName());*/
        gc.setFill(Color.WHITE);
        gc.setFont(new Font(30));
        gc.fillText(player.getName(), player.getRacket().getPosX(), 30);
    }


    private void playerScore(GraphicsContext gc, Player player)
    {
        gc.setFill(Color.WHITE);
        gc.setFont(new Font(30));
        gc.fillText(String.valueOf(player.getScore()), player.getRacket().getPosX(), 60);
    }

}