package sk.kosickaakademia.spivak.ticTacToe5;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {

    private static int[][] array;
    private int player = 1;
    private int count = 0;

    public Main() {
        array=new int[15][15];
        initArray(array);
    }


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
                    if (player == 2)
                        return;
                    text.setFill(Color.BLUE);
                    drawX();
                    player = 2;
                    int a = play(event.getSceneX(),event.getSceneY());
                    if(a == 1)
                        System.out.println("Player 1 is winner");
                    if(a == 2)
                        System.out.println("Player 2 is winner");
                    if(a == 3)
                        System.out.println("Standoff");
                }
                if(event.getButton() == MouseButton.SECONDARY){
                    if (player == 1)
                        return;
                    text.setFill(Color.PURPLE);
                    drawO();
                    player = 1;
                    int a = play(event.getSceneX(),event.getSceneY());
                    if(a == 1)
                        System.out.println("Player 1 is winner");
                    if(a == 2)
                        System.out.println("Player 2 is winner");
                    if(a == 3)
                        System.out.println("Standoff");
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

    public void initArray(int[][] field) {
        for(int i = 0; i < field.length; i++){
            for(int j = 0; j < field[0].length; j++){
                field[i][j] = 0;
            }
        }
    }

    public static void printGame(int[][] field) {
        for(int i=0;i< field.length;i++){
            System.out.print("-" + "\t");
        }
        System.out.println();
        for(int i=0;i<15;i++){
            for(int j=0;j<15;j++){
                System.out.print(field[i][j]+ "\t");
            }
            System.out.println();
        }
        for(int i=0;i< field.length;i++){
            System.out.print("-" + "\t");
        }
        System.out.println();
    }

    public int play (double xPixel, double yPixel){
        int x = (int)Math.round(xPixel);
        int y = (int)Math.round(yPixel);
        for(int i = 0; i < 15; i++){
            for(int j = 0; j < 15; j++){
                if(y >= i*40 && y <= 40+i*40  && x >= j*40  && x <= 40+j*40 ){
                    array[i][j] = player;
                }
            }
        }
        int result = isWinnerNxN(array);
        count++;
        if(result == 1){
            return 1;
        }
        if(result == 2){
            return 2;
        }
        if(result == 0 && count == 225){
            return 3;
        }
        if(result == 0){
            return 0;
        }
        return -1;
    }

    private int isWinner5on5(int[][] field){
        if(field.length != 5 || field[0].length != 5){
            return -1;
        }
        for(int i = 0; i < 5; i++){
            if(field[i][0]*field[i][1]*field[i][2]*field[i][3]*field[i][4]==1 || field[0][i]*field[1][i]*field[2][i]*field[3][i]*field[4][i]==1)
                return 1;
            if(field[i][0]*field[i][1]*field[i][2]*field[i][3]*field[i][4]==32 || field[0][i]*field[1][i]*field[2][i]*field[3][i]*field[4][i]==8)
                return 2;
        }
        if(field[0][0]*field[1][1]*field[2][2]*field[3][3]*field[4][4]==1 || field[0][4]*field[1][3]*field[2][2]*field[3][1]*field[4][0]==1)
            return 1;
        if(field[0][0]*field[1][1]*field[2][2]*field[3][3]*field[4][4]==32 || field[0][4]*field[1][3]*field[2][2]*field[3][1]*field[4][0]==32)
            return 2;
        return 0;
    }

    private int isWinnerNxN(int[][] field){
        if(field.length != field[0].length || field.length < 5){
            return -1;
        }
        int n = field.length;
        for(int i = 0; i < n-4; i++) {
            for (int j = 0; j < n-4; j++) {
                int[][] array = new int[5][5];
                for (int x = 0; x < 5; x++) {
                    for (int y = 0; y < 5; y++) {
                        array[x][y] = field[x + i][y + j];
                    }
                }
                int result = isWinner5on5(array);
                if(result == 1){
                    return 1;
                }
                if(result == 2){
                    return 2;
                }
            }
        }
        return 0;
    }


}
