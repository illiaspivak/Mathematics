package sk.kosickaakademia.spivak.ticTacToe;

import java.util.Scanner;

public class TicTacToe {

    private int playerInt = 1;
    private String playerString = "X";
    private int count = 0;

    /**
     * Determines whether one of the players on the 5-on-5 field has won
     * @param field
     * @return -1   Array not of size 5 by 5
     *          0   No one won
     *          1   The number one player won
     *          2   The number two player won
     */
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

    /**
     * Determines whether one of the players on the N-on-N field has won
     * @param field
     * @return -1   Array not of size N by N
     *          0   No one won
     *          1   The number one player won
     *          2   The number two player won
     */
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

    /**
     * Filling an array with zeros
     * @param field
     */
    private void initArray(int[][] field) {
        for(int i = 0; i < field.length; i++){
            for(int j = 0; j < field[0].length; j++){
                field[i][j] = 0;
            }
        }
    }

    /**
     * Filling the array with values from 1 to NxN
     * @param field
     */
    private void initArrayString(String[][] field) {
        int n = 1;
        for(int i = 0; i < field.length; i++){
            for(int j = 0; j < field[0].length; j++){
                field[i][j] = String.valueOf(n);
                n++;
            }
        }
    }

    /**
     * Output an array to the console
     * @param field
     */
    private void printGame(String[][] field) {
        for(int i=0;i< field.length;i++){
            System.out.print("-" + "\t");
        }
        System.out.println();
        for(int i=0;i< field.length;i++){
            for(int j=0;j< field[0].length;j++){
                System.out.print(field[i][j] + "\t");
            }
            System.out.println();
        }
        for(int i=0;i< field.length;i++){
            System.out.print("-" + "\t");
        }
        System.out.println();
    }

    private void printGameInt(int[][] field) {
        for(int i=0;i< field.length;i++){
            System.out.print("-" + "\t");
        }
        System.out.println();
        for(int i=0;i< field.length;i++){
            for(int j=0;j< field[0].length;j++){
                System.out.print(field[i][j] + "\t");
            }
            System.out.println();
        }
        for(int i=0;i< field.length;i++){
            System.out.print("-" + "\t");
        }
        System.out.println();
    }

    private void nextPlayerInt() {
        if(playerInt==1)
            playerInt=2;
        else
            playerInt=1;
    }

    private void nextPlayerString() {
        if(playerString.equals("X"))
            playerString="⃝";
        else
            playerString="X";
    }

    public void play(){
        System.out.println("This is a 5-in-a-row tic-tac-toe game!");
        System.out.println("Enter the size of the field:");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); //field size
        int[][] fieldInt = new int[n][n]; //array for game logic
        String[][] fieldString = new String[n][n]; //array to display on the screen
        initArray(fieldInt); //filling in the array
        initArrayString(fieldString); //filling in the array
        int input; //the cell selected by the player
        while(isWinnerNxN(fieldInt)==0) {
            System.out.println("Player's turn " + playerInt);
            printGame(fieldString);
            System.out.println("Enter a number from 1 to " + n*n);
            input = scanner.nextInt();
            if (input < 1 || input > n*n) {
                System.out.println("Input must be between 1 and " + n*n);
                continue;
            }
            int r=(input-1)/n;
            int c=(input-1)%n;
            if(fieldInt[r][c]!=0) {
                System.out.println("Tile you chosed is not empty");
                continue;
            }
            fieldInt[r][c]=playerInt;
            fieldString[r][c]=playerString;
            count++;
            if(count == n*n){
                break;
            }
            nextPlayerInt();
            nextPlayerString();
        }
        if(isWinnerNxN(fieldInt)==1){
            System.out.println("Player 1 is winner");
            printGame(fieldString);
        }
        else if(isWinnerNxN(fieldInt)==2){
            System.out.println("Player 2 is winner");
            printGame(fieldString);
        }else{
            System.out.println("Standoff");
            printGame(fieldString);
        }
    }
}
