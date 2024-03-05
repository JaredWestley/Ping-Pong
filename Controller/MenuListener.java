package com.example.helloworld.Controller;

import com.example.helloworld.Game;
import com.example.helloworld.view.LabCanvas;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.TextInputDialog;
import javafx.scene.paint.Color;

import java.util.Optional;

public class MenuListener {
    private final Game game;
    private LabCanvas canvas;
    private BallManager ballManager;
    public MenuListener(Game game, LabCanvas canvas)
    {
        this.game=game;this.canvas=canvas;
    }

    public void setExit() {
        System.out.println("EXIT");
        Platform.exit();
    }

    public void setAbout() {
        System.out.println("ABOUT");
        var alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Super Ping pong");
        alert.setHeaderText("Made in Cork");
        alert.setContentText("All rights reserved");
        alert.showAndWait().ifPresent((btnType) -> {
        });
    }
    public void setGameLimit()
    {
        TextInputDialog dialog = new TextInputDialog();  // create an instance

        dialog.setTitle("Title");
// other formatting etc

        Optional<String> result = dialog.showAndWait();
// this shows the dialog, waits until it is closed, and stores the result
// if the result is present (i.e. if a string was entered) call doSomething() on it
        result.ifPresent(string -> {
            game.setTarget(Integer.parseInt(result.get()));
        });
    }

    public void setBallSpeed(int ballspeed) {
        ballManager.setBallspeed(ballspeed*10);
    }

    public void setPlayerName1(String name) {
        /*System.out.println("Setting name in listener to "+name);*/

        game.getPlayer1().setName(name);
        /*System.out.println("name set to "+game.getPlayer1().getName());*/
        canvas.drawGame(game);
    }

    public void setPlayerName2(String name) {
        /*System.out.println("Setting name in listerner to "+name);*/

        game.getPlayer2().setName(name);
        /*System.out.println("name set to "+game.getPlayer2().getName());*/
        canvas.drawGame(game);
    }

    public void setPlayer1Colour(String color) {
        game.getPlayer1().getRacket().setColor(Color.valueOf(color));
    }

    public void setPlayer2Colour(String colour) {
        game.getPlayer2().getRacket().setColor(Color.valueOf(colour));
    }

    public void setGameReset() {
    }
}

