package com.example.helloworld;

public class Player {

    private String name = "Player";
    private int score;

    private Racket racket= new Racket();

    public Player(int i)
    {
        racket.setPosX(i);
    }

    public String getName() {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = this.score+score;
    }

    public Racket getRacket() {
        return racket;
    }

    public void setRacket(Racket racket) {
        this.racket = racket;
    }
}
