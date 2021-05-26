package sk.kosickaakademia.spivak.ticTacToe5;

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

    private boolean turnX = true; //the first player's turn, or the second player's turn

    private Parent createContent() {
        Pane root = new Pane();
        root.setPrefSize(600, 600);

        //Dividing an empty field into squares
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                Tile tile = new Tile();
                tile.setTranslateX(j * 40); //Translate X axis 0 - 560 pixel
                tile.setTranslateY(i * 40); //Translate Y axis 0 - 560 pixel
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

        private Text text = new Text();

        public Tile() {
            Rectangle border = new Rectangle(40, 40); //class that helps to draw a square
            border.setFill(null); //color inside the square
            border.setStroke(Color.LIGHTGRAY); //border color

            text.setFont(Font.font(20));

            setAlignment(Pos.CENTER); //defines the position of the element
            getChildren().addAll(border, text); //returns a collection of elements
            // nested in the container as an object of the ObservableList<Node>interface

            //Clicking the left mouse button draws "X", clicking the right mouse button draws "O"
            setOnMouseClicked(event -> {
                if(event.getButton() == MouseButton.PRIMARY){

                    if (!turnX)
                        return;
                    text.setFill(Color.BLUE);
                    drawX();
                    turnX = false;
                }
                if(event.getButton() == MouseButton.SECONDARY){

                    if (turnX)
                        return;
                    text.setFill(Color.PURPLE);
                    drawO();
                    turnX = true;
                }
            });
        }

        /**
         * Draws the value "X" in the square
         */
        private void drawX() {
            text.setText("X");
        }

        /**
         * Draws the value "O" in the square
         */
        private void drawO() {
            text.setText("O");
        }


    }

}
