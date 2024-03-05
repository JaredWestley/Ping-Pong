package com.example.helloworld.view;
import com.example.helloworld.Controller.MenuListener;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextInputDialog;

import java.util.Optional;

public class MyMenu {

    private MenuBar menuBar;
    private Menu menuFile;
    private Menu menuHelp;
    private Menu menuGame;
    private Menu menuPlayer;

    //File
    private MenuItem menuItemExit;

    //Game
    private MenuItem menuItemGameLimit;
    private MenuItem menuItemBallSpeed;
    private MenuItem menuItemGameReset;

    //Player
    private MenuItem menuItemPlayer1Name;
    private MenuItem menuItemPlayer2Name;
    private MenuItem menuItemPlayer1Colour;
    private MenuItem menuItemPlayer2Colour;


    //Help
    private MenuItem menuItemAbout;
    private MenuListener menuListener;

    public MyMenu(MenuListener menuListener)
    {
        menuBar= new MenuBar();
        menuFile = new Menu("File");
        menuGame = new Menu("Game");
        menuPlayer = new Menu("Player");
        menuHelp = new Menu("Help");

        //File
        menuItemExit = new MenuItem("Exit");

        //Game
        menuItemGameLimit= new MenuItem("Game Limit");
        menuItemBallSpeed = new MenuItem("Ball Speed");
        menuItemGameReset = new MenuItem(" Reset Game");

        menuItemPlayer1Name = new MenuItem("Player 1 Name");
        menuItemPlayer2Name = new MenuItem("Player 2 Name");
        menuItemPlayer1Colour = new MenuItem("Player 1 Colour");
        menuItemPlayer2Colour = new MenuItem("Player 2 Colour");

        //Help
        menuItemAbout= new MenuItem("About");


        //File
        menuFile.getItems().add(menuItemExit);

        //Game
        menuGame.getItems().add(menuItemGameLimit);
        menuGame.getItems().add(menuItemBallSpeed);
        menuGame.getItems().add(menuItemGameReset);

        //Player
        menuGame.getItems().add(menuItemPlayer1Name);
        menuGame.getItems().add(menuItemPlayer2Name);
        menuGame.getItems().add(menuItemPlayer1Colour);
        menuGame.getItems().add(menuItemPlayer2Colour);


        //Help
        menuHelp.getItems().add(menuItemAbout);
        menuBar.getMenus().addAll(menuFile, menuGame, menuHelp);
        this.menuListener=menuListener;

        handleClicking();
    }

    public MenuBar getMenuBar() {
        return menuBar;
    }

    public void setMenuBar(MenuBar menuBar) {
        this.menuBar = menuBar;
    }

    private void handleClicking() {
        //File
        menuItemExit.setOnAction(e->menuListener.setExit());

        //Help
        menuItemAbout.setOnAction(e->menuListener.setAbout());

        //Game
        menuItemBallSpeed.setOnAction(e->{
            TextInputDialog dialog = new TextInputDialog();
            dialog.setTitle("Ball Speed");
            dialog.setHeaderText(null);
            dialog.setContentText("Enter Ball Speed:");

            Optional<String> result = dialog.showAndWait();
            System.out.println(result);
            result.ifPresent(ballspeed -> {
                System.out.println("calling listener");
                menuListener.setBallSpeed(Integer.parseInt(ballspeed));
            });
        });
        menuItemGameLimit.setOnAction(e->menuListener.setGameLimit());
        menuItemGameReset.setOnAction(e->menuListener.setGameReset());

        //Player
        menuItemPlayer1Name.setOnAction(e -> {
            TextInputDialog dialog = new TextInputDialog();
            dialog.setTitle("Player 1 Name");
            dialog.setHeaderText(null);
            dialog.setContentText("Enter Player 1 Name:");

            Optional<String> result = dialog.showAndWait();
            System.out.println(result);
            result.ifPresent(player1Name -> {
                System.out.println("calling listener");
                menuListener.setPlayerName1(player1Name);
            });
        });
        menuItemPlayer2Name.setOnAction(e -> {
            TextInputDialog dialog = new TextInputDialog();
            dialog.setTitle("Player 2 Name");
            dialog.setHeaderText(null);
            dialog.setContentText("Enter Player 2 Name:");

            Optional<String> result = dialog.showAndWait();
            System.out.println(result);
            result.ifPresent(player2Name -> {
                System.out.println("calling listener");
                menuListener.setPlayerName2(player2Name);
            });
        });
        /*menuItemPlayer1Colour.setOnAction(e->{
            TextInputDialog dialog = new TextInputDialog();
            dialog.setTitle("Player 1 Colour");
            dialog.setHeaderText(null);
            dialog.setContentText("Enter Player 1 Colour:");

            Optional<String> result = dialog.showAndWait();
            System.out.println(result);
            result.ifPresent(player1Colour -> {
                System.out.println("calling listener");
                menuListener.setPlayer1Colour(player1Colour);
            });*/

        menuItemPlayer1Colour.setOnAction(e -> {
            TextInputDialog dialog = new TextInputDialog();
            dialog.setTitle("Player 1 Colour");
            dialog.setHeaderText(null);
            dialog.setContentText("Enter Player 1 Colour :");

            Optional<String> result = dialog.showAndWait();
            System.out.println(result);
            result.ifPresent(player1Colour -> {
                System.out.println("calling listener");
                menuListener.setPlayer1Colour(player1Colour);
            });
        });

        menuItemPlayer2Colour.setOnAction(e -> {
            TextInputDialog dialog = new TextInputDialog();
            dialog.setTitle("Player 2 Colour");
            dialog.setHeaderText(null);
            dialog.setContentText("Enter Player 2 Colour :");

            Optional<String> result = dialog.showAndWait();
            System.out.println(result);
            result.ifPresent(player2Colour -> {
                System.out.println("calling listener");
                menuListener.setPlayer2Colour(player2Colour);
            });
        });
    }


}

