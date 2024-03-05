package com.example.helloworld;

public class Ball implements Resizable{

    private double posX=300;

    private double posY=325;
    private double radius=50;

    private int stepX=-1;
    private int stepY=-1;

    public int getStepX() {
        return stepX;
    }

    public int getStepY() {
        return stepY;
    }

    public void setStepY(int stepY) {
        this.stepY = stepY;
    }

    public void setStepX(int stepX) {
        this.stepX = stepX;
    }

    @Override
    public void resizeX(double factor) {
        this.posX = this.posX*factor;
    }

    public double getPosX() {
        return posX;
    }

    public void setPosX(double posX) {
        this.posX = posX;
    }

    public double getPosY() {
        return posY;
    }

    public void setPosY(double posY) {
        this.posY = posY;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public void resizeY(double factor) {
        this.posY = this.posY*factor;
    }

    public void move() {
        this.posX = this.posX+stepX;
        this.posY = this.posY+stepY;
    }
}
