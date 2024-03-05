package com.example.helloworld;
import com.example.helloworld.Controller.BallManager;
import com.example.helloworld.Controller.KeyboardListener;
import com.example.helloworld.Controller.LabController;
import com.example.helloworld.Controller.MenuListener;
import com.example.helloworld.view.LabCanvas;
import com.example.helloworld.view.MyMenu;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class helloworld extends Application {


    private LabController labController = new LabController();
    private LabCanvas canvas ;
    MenuListener menuListener ;

    MyMenu myMenu;

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override public void start(Stage primaryStage) {
        canvas=  new LabCanvas(600,650);
        menuListener = new MenuListener(labController.getGame(), canvas);
        myMenu = new MyMenu(menuListener);
        primaryStage.setTitle("Hello World!");
        BorderPane root = new BorderPane();

        root.setTop(myMenu.getMenuBar());
        root.setCenter(canvas);
        canvas.drawGame(labController.getGame());

//        root.setStyle("-fx-background-color: black;");
        primaryStage.setScene(new Scene(root, 600, 650));
        primaryStage.show();

        labController.getGame().setDimensionX(primaryStage.getWidth());
        labController.getGame().setDimensionY(primaryStage.getHeight());

        primaryStage.widthProperty().addListener(observable -> {
            double factor= primaryStage.getWidth()/labController.getGame().getDimensionX();
            System.out.println("Width changed " + primaryStage.getWidth()+" "+factor);
            labController.getGame().setDimensionX(primaryStage.getWidth());
            labController.getGame().resizeX(factor);
            canvas.drawGame(labController.getGame());
        });
        primaryStage.heightProperty().addListener(observable -> {
            double factor = primaryStage.getHeight() / labController.getGame().getDimensionY();
            System.out.println("Height changed " + primaryStage.getHeight() + " " + factor);
            labController.getGame().setDimensionY(primaryStage.getHeight());
            labController.getGame().resizeY(factor);
            canvas.drawGame(labController.getGame());
        });

        KeyboardListener keyboardListener = new KeyboardListener( labController.getGame(), canvas);
        canvas.setOnKeyPressed(keyboardListener );
        canvas.setOnKeyTyped(keyboardListener );
        canvas.setFocusTraversable(true);

        BallManager ballManager= new BallManager(labController.getGame(), canvas);
        Thread thread = new Thread(ballManager);
        thread.start();
        /*Thread.yield();*/

    }
}
