package com.example.helloworld;

public class Game implements Resizable{

    private int target = 5;
    private Player player1= new Player(30);
    private Player player2= new Player(500);
    private Ball ball = new Ball();

    private double dimensionX;
    private double dimensionY;

    public int getTarget() {
        return target;
    }

    public void setTarget(int target) {
        this.target = target;
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public Ball getBall() {
        return ball;
    }

    public void setBall(Ball ball) {
        this.ball = ball;
    }

    public double getDimensionX() {
        return dimensionX;
    }

    public void setDimensionX(double dimensionX) {
        this.dimensionX = dimensionX;
    }

    public double getDimensionY() {
        return dimensionY;
    }

    public void setDimensionY(double dimensionY) {
        this.dimensionY = dimensionY;
    }

    @Override
    public void resizeX(double factor) {
        player1.getRacket().resizeX(factor);
        player2.getRacket().resizeX(factor);
        ball.resizeX(factor);
    }

    @Override
    public void resizeY(double factor) {
        player1.getRacket().resizeY(factor);
        player2.getRacket().resizeY(factor);
        ball.resizeY(factor);
    }
}
