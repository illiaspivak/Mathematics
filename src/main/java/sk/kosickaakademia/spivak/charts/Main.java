package sk.kosickaakademia.spivak.charts;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class Main extends Application {
    private int HEIGHT = 300;
    private int WIDTH = 500;

    public void start(Stage primaryStage) throws Exception {
        Group group = new Group();

        group.getChildren().addAll(
                new Line(0, HEIGHT/2, WIDTH, HEIGHT/2),
                new Line(WIDTH/2, 0, WIDTH/2, HEIGHT)
        );


        Scene scene = new Scene(group, WIDTH, HEIGHT);
        primaryStage.setTitle("Chart");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
