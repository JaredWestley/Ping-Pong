package com.example.helloworld.Controller;

import com.example.helloworld.Game;

public class LabController {
    private  Game game = new Game();

    public  Game getGame(){
        return game;
    }

    public void setGame(Game game){
        this.game = game;
    }
}
