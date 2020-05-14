import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import javax.swing.*;

public class Main extends Application implements EventHandler<ActionEvent>{

    Button buttonRun;
    Boolean runPause = true;
    MyWorld world;
    Button buttonReset;
    Boolean resetPressed = false;
    AnimationTimer timer;
    BorderPane layout;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Centipede");
        primaryStage.setResizable(false);
        layout = new BorderPane();
        HBox bottomLayout = bottomLayout();
        layout.setBottom(bottomLayout);
        world = new MyWorld(500, 660);
        layout.setCenter(world);
        Scene scene = new Scene(layout, 500, 707);//increased by 7 because the top menu has 7 height
        primaryStage.setScene(scene);
        primaryStage.show();
        timer = new AnimationTimer() {
            @Override
            public void handle(long l){
                if (runPause) {
                    world.act();
                }
            }
        };
        timer.start();

    }


    public HBox bottomLayout(){
        HBox bottomLayout = new HBox();
        bottomLayout.setPadding(new Insets(10, 12, 10, 12));
        bottomLayout.setSpacing(10);
        bottomLayout.setStyle("-fx-background-color: #C1C1C1");


        buttonRun = new Button("Run");
        buttonRun.setPrefSize(100, 20);
        buttonRun.setOnAction(this);

        buttonReset = new Button("Reset");
        buttonReset.setPrefSize(100, 20);
        bottomLayout.getChildren().addAll(buttonRun, buttonReset);
        buttonReset.setOnAction(this);

        return bottomLayout;

    }

    @Override
    public void handle(ActionEvent event) {
        //System.out.println("width: " + world.getWidth());
       // System.out.println("height: " + world.getHeight());

        if (event.getSource() == buttonRun) {
            if (runPause) {
                buttonRun.setText("Pause");
                runPause = false;

            }else {
                buttonRun.setText("Run");
                runPause = true;
            }
        }

        if (event.getSource() == buttonReset){
            timer.stop();
            runPause = true;
            resetPressed = true;
            buttonRun.setText("Run");
            world.newWorld();
            timer.start();

        }
    }
}