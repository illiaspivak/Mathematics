package sk.kosickaakademia.spivak.ticTacToeGUI;

import java.util.ArrayList;
import java.util.List;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {


    private Parent createContent() {
        Pane root = new Pane();
        root.setPrefSize(600, 600);

        //Dividing an empty field into squares
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Tile tile = new Tile();
                tile.setTranslateX(j * 200); //Translate X axis 0, 200, 400 pixel
                tile.setTranslateY(i * 200); //Translate Y axis 0, 200, 400 pixel
                root.getChildren().add(tile); //Gathers all the elements together
            }
        }
        return root;
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(new Scene(createContent()));
        primaryStage.setTitle("Tic Tac Toe");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private class Tile extends StackPane { //StackPane allows you to place elements on top of other elements

        public Tile() {
            Rectangle border = new Rectangle(200, 200); //class that helps to draw a square
            border.setFill(null); //color inside the square
            border.setStroke(Color.DARKGREEN); //border color

            setAlignment(Pos.CENTER); //defines the position of the element
            getChildren().addAll(border); //returns a collection of elements
            // nested in the container as an object of the ObservableList<Node>interface
        }
    }
}
