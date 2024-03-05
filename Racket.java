package com.example.helloworld;

import javafx.scene.paint.Color;

public class Racket {
    private double posX =30;

    private double posY =300;


    private double thickness=20;
    private double size=60;

    private Color color=Color.WHITE;

    public double getPosX() {
        return posX;
    }


    public void setPosX(double posX) {
        this.posX = posX;
    }


    public double getPosY() {
        return posY;
    }


    public void r1_setPosY(double posY) {
        this.posY = posY;
    }

    public double getThickness() {
        return thickness;
    }

    public void setThickness(double thickness) {
        this.thickness = thickness;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void resizeX(double factor) {
        this.posX = this.posX *factor;
        this.thickness = this.thickness*factor;
    }


    public void resizeY(double factor) {
        this.posY = this.posY *factor;
        this.thickness = this.thickness*factor;
    }

    public void moveUp() {
        this.posY=this.posY-5;
    }

    public void moveDown() {
        this.posY=this.posY+5;
    }
}
